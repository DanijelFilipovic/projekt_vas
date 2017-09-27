package dfilipov.vas.util;

import dfilipov.vas.EnemyAgent;
import dfilipov.vas.GameAgent;
import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.Enemy;
import dfilipov.vas.object2d.obstruction.Trap;
import jade.content.lang.Codec;
import jade.content.lang.sl.SLCodec;
import jade.content.onto.Ontology;
import jade.content.onto.OntologyException;
import jade.content.onto.basic.Action;
import jade.core.Agent;
import jade.domain.JADEAgentManagement.JADEManagementOntology;
import jade.domain.JADEAgentManagement.ShutdownPlatform;
import jade.lang.acl.ACLMessage;
import java.io.IOException;
import java.util.List;

public class MessageFactory
{
	private MessageFactory()
	{
	}
	
	public static ACLMessage createShutdownMessage(Agent agent) throws Codec.CodecException, OntologyException
	{
		Codec codec = new SLCodec();
		Ontology ontology = JADEManagementOntology.getInstance();

		agent.getContentManager().registerLanguage(codec);
		agent.getContentManager().registerOntology(ontology);

		ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
		message.addReceiver(agent.getAMS());
		message.setLanguage(codec.getName());
		message.setOntology(ontology.getName());
		
		agent.getContentManager().fillContent(message, new Action(agent.getAID(), new ShutdownPlatform()));
		return message;
	}
	
	public static ACLMessage createUpdateRequestMessage
		(PositionInfo positionInfo, List<Triple<String, EnemyAgent, Enemy>> enemies) throws IOException
	{
		ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
		message.setOntology("update");
		message.setContentObject(positionInfo);
		enemies.forEach((t) -> message.addReceiver(t.getSecond().getAID()));
		return message;
	}
		
	public static ACLMessage createTrapRemovalRequestMessage(Trap trap, Agent receiver) throws IOException
	{
		ACLMessage message = new ACLMessage(ACLMessage.REQUEST);
		message.setOntology("trap_removal");
		message.setContentObject(trap);
		message.addReceiver(receiver.getAID());
		return message;
	}
	
	public static ACLMessage createUpdateConfirmationMessage(Vec2 position, Agent receiver) throws IOException
	{
		ACLMessage message = new ACLMessage(ACLMessage.CONFIRM);
		message.setOntology("updated");
		message.setContentObject(position);
		message.addReceiver(receiver.getAID());
		return message;
	}
}
