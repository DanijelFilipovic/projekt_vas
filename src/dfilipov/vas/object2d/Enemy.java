package dfilipov.vas.object2d;

import dfilipov.vas.EnemyAgent;
import dfilipov.vas.GameAgent;
import dfilipov.vas.collision.Collideable;
import dfilipov.vas.collision.Collider;
import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.obstruction.Trap;
import dfilipov.vas.util.MessageFactory;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.io.Serializable;
import org.lwjgl.opengl.GL11;

public class Enemy extends Collider implements Drawable, Collideable, Serializable
{
	private final float RADIUS = 25.0f;
	private final float VELOCITY = 2.0f;

	private Vec2 position;
	private EnemyAgent agent;

	public Enemy()
	{
		this.position = new Vec2(0.0f, 0.0f);
	}

	public Enemy(float x, float y)
	{
		this.position = new Vec2(x, y);
	}

	public float getX()
	{
		return position.getX();
	}

	public float getY()
	{
		return position.getY();
	}

	@Override
	public Vec2 getPosition()
	{
		return position;
	}
	
	public EnemyAgent getAgent()
	{
		return agent;
	}

	public void setX(float x)
	{
		position.setX(x);
	}

	public void setY(float y)
	{
		position.setY(y);
	}

	public void setPosition(Vec2 position)
	{
		this.position = position.copy();
	}
	
	public void setAgent(EnemyAgent agent)
	{
		this.agent = agent;
	}

	@Override
	public void draw()
	{
		float radians = (float) (Math.PI / 180.0d);
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(1.0f, 0.0f, 0.0f);
		for (int i = 0; i < 360; i++)
		{
			float r = i * radians;
			float x = (float) (Math.cos(r) * RADIUS);
			float y = (float) (Math.sin(r) * RADIUS);
			GL11.glVertex2f(position.getX() + x, position.getY() + y);
		}
		GL11.glEnd();
	}

	@Override
	public float getVelocity()
	{
		return VELOCITY;
	}
	
	@Override
	public float getRadius()
	{
		return RADIUS;
	}
	
	@Override
	public void kill(Trap trap)
	{
		agent.setExitValue(EnemyAgent.TRANSITION_TO_DEAD);
		try
		{
			ACLMessage message = MessageFactory.createTrapRemovalRequestMessage(trap, GameAgent.MainAgent);
			agent.send(message);
		}
		catch (IOException ex)
		{
			System.out.println("Unable to send trap removal request: " + ex.getMessage());
		}
	}

	@Override
	public void processCollision(Collider collider)
	{
		if (getPosition().distance(collider.getPosition()) < getRadius() * 2)
		{
			if (collider instanceof Player)
			{
				collider.kill(null);
			}
			else
			{
				Vec2 relocation = collider.getPosition().copy();
				relocation.subtract(getPosition())
						.normalize()
						.scalar(getVelocity());
				collider.relocate(relocation);
			}
		}
	}
}
