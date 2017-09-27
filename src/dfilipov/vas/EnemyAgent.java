package dfilipov.vas;

import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.Enemy;
import dfilipov.vas.object2d.obstruction.Obstruction;
import dfilipov.vas.util.MessageFactory;
import dfilipov.vas.util.PositionInfo;
import jade.core.Agent;
import jade.core.behaviours.FSMBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class EnemyAgent extends Agent
{
	private Enemy enemy;
	private int exitValue;

	private final String STATE_IDLE = "IDLE";
	private final String STATE_CHASE = "CHASE";
	private final String STATE_DEAD = "DEAD";

	public static final int TRANSITION_TO_IDLE = 0;
	public static final int TRANSITION_TO_CHASE = 1;
	public static final int TRANSITION_TO_DEAD = 2;
	
	public Enemy getEnemy()
	{
		return enemy;
	}
	
	public void setExitValue(int exitValue)
	{
		this.exitValue = exitValue;
	}

	@Override
	protected void setup()
	{
		enemy = (Enemy) getArguments()[0];
		enemy.setAgent(this);
		exitValue = TRANSITION_TO_IDLE;

		FSMBehaviour behaviour = new FSMBehaviour();
		behaviour.registerFirstState(new EnemyIdleBehaviour(), STATE_IDLE);
		behaviour.registerState(new EnemyChaseBehaviour(), STATE_CHASE);
		behaviour.registerLastState(new EnemyDeadBehaviour(), STATE_DEAD);

		behaviour.registerTransition(STATE_IDLE, STATE_IDLE, TRANSITION_TO_IDLE);
		behaviour.registerTransition(STATE_CHASE, STATE_CHASE, TRANSITION_TO_CHASE);
		behaviour.registerTransition(STATE_IDLE, STATE_CHASE, TRANSITION_TO_CHASE);
		behaviour.registerTransition(STATE_CHASE, STATE_IDLE, TRANSITION_TO_IDLE);
		behaviour.registerTransition(STATE_CHASE, STATE_DEAD, TRANSITION_TO_DEAD);

		addBehaviour(behaviour);
		System.out.println("Created agent " + getLocalName() + "...");
	}

	@Override
	protected void takeDown()
	{
		System.out.println("Stopped agent " + getLocalName() + "...");
	}

	
	private class EnemyChaseBehaviour extends OneShotBehaviour
	{
		@Override
		public void action()
		{
			ACLMessage message = getAgent().receive();
			if (message != null)
			{
				if (message.getOntology().equals("update"))
				{
					try
					{
						PositionInfo positionInfo = (PositionInfo) message.getContentObject();
						if (enemy.getPosition().distance(positionInfo.getPlayerPosition()) <= 300.0f)
						{
							moveTowardsEnemy(positionInfo);
							processCollision(positionInfo.getObstructions());
							
							try
							{
								ACLMessage updateConfirmation = 
										MessageFactory.createUpdateConfirmationMessage(getEnemy().getPosition(), GameAgent.MainAgent);
								send(updateConfirmation);
							}
							catch (IOException ex)
							{
								System.out.println("Unable to send update confirmation (EnemyChase): " + ex.getMessage());
							}
						}
						else
						{
							setExitValue(TRANSITION_TO_IDLE);
						}
					}
					catch (UnreadableException ex)
					{
						System.out.println("Unable to read position info (EnemyChase): " + ex.getMessage());
					}
				}
			}
			else
			{
				block();
			}
		}

		private void moveTowardsEnemy(PositionInfo positionInfo)
		{
			Vec2 movement = positionInfo.getPlayerPosition().copy();
			movement.subtract(enemy.getPosition()).normalize().scalar(enemy.getVelocity());
			enemy.getPosition().translate(movement);
			
			for (String key : positionInfo.getEnemies().keySet())
			{
				Enemy otherEnemy = positionInfo.getEnemies().get(key);
				if (!key.equals(getAgent().getLocalName()))
				{
					otherEnemy.processCollision(enemy);
				}
			}
		}
		
		private void processCollision(List<Obstruction> obstructions)
		{
			obstructions.forEach((o) -> o.processCollision(enemy));
		}
		
		@Override
		public int onEnd()
		{
			return exitValue;
		}
	}

	
	private class EnemyIdleBehaviour extends OneShotBehaviour
	{
		@Override
		public void action()
		{
			ACLMessage message = getAgent().receive();
			if (message != null)
			{
				if (message.getOntology().equals("update"))
				{
					try
					{
						PositionInfo positionInfo = (PositionInfo) message.getContentObject();
						if (enemy.getPosition().distance(positionInfo.getPlayerPosition()) <= 200.0f)
						{
							setExitValue(TRANSITION_TO_CHASE);
						}
					}
					catch (UnreadableException ex)
					{
						System.out.println("Unable to read position info (EnemyIdle): " + ex.getMessage());
					}
				}
			}
			else
			{
				block();
			}
		}

		@Override
		public int onEnd()
		{
			return exitValue;
		}
	}
	
	
	private class EnemyDeadBehaviour extends OneShotBehaviour
	{
		@Override
		public void action()
		{
			doDelete();
		}
	}
}
