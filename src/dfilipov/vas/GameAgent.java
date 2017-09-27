package dfilipov.vas;

import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.Enemy;
import dfilipov.vas.object2d.obstruction.Obstruction;
import dfilipov.vas.object2d.Player;
import dfilipov.vas.object2d.obstruction.Trap;
import dfilipov.vas.object2d.obstruction.Wall;
import dfilipov.vas.util.screendraw.ScreenDraw;
import dfilipov.vas.util.MessageFactory;
import dfilipov.vas.util.PositionInfo;
import dfilipov.vas.util.Triple;
import dfilipov.vas.util.observer.input.KeyboardInputObservable;
import dfilipov.vas.util.observer.input.KeyboardInputObserver;
import jade.content.lang.Codec;
import jade.content.onto.OntologyException;
import jade.core.Agent;
import jade.core.ProfileImpl;
import jade.core.Runtime;
import jade.core.behaviours.CyclicBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import jade.wrapper.AgentContainer;
import jade.wrapper.StaleProxyException;
import java.io.IOException;
import java.util.ArrayList;
import org.lwjgl.glfw.Callbacks;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.glfw.GLFWKeyCallbackI;
import org.lwjgl.opengl.GL;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL13;

public class GameAgent extends Agent implements GLFWKeyCallbackI, KeyboardInputObserver
{
	public static final int WINDOW_WIDTH = 800;
	public static final int WINDOW_HEIGHT = 600;
	
	private boolean paused = false;
	private boolean victorious = false;
	private boolean gameOver = false;
	private boolean started = false;
	
	private long window;
	private Player player;
	
	private int nthEnemy = 1;

	private final ArrayList<Triple<String, EnemyAgent, Enemy>> enemies = new ArrayList<>();
	private final ArrayList<Obstruction> obstructions = new ArrayList<>();
	private final KeyboardInputObservable keyboardInputObservable = new KeyboardInputObservable();
	
	@Override
	protected void setup()
	{
		addBehaviour(new RenderBehaviour());
		create();
		initializeWindow();
		initializeGL();
		System.out.println("Starting game agent...");
	}

	@Override
	protected void takeDown()
	{
		System.out.println("Closing game agent...");
		destroy();
		sendShutdownMessage();
	}

	@Override
	public void invoke(long window, int key, int scancode, int action, int mods)
	{
		keyboardInputObservable.notifyObservers(key, action);
	}

	@Override
	public void onNotify(int key, int action)
	{
		if ((key == GLFW.GLFW_KEY_P || key == GLFW.GLFW_KEY_ESCAPE) && action == GLFW.GLFW_PRESS) 
		{
			paused = !paused;
		}
		else if ((victorious || gameOver) && key == GLFW.GLFW_KEY_R && action == GLFW.GLFW_RELEASE)
		{
			restart();
		}
	}

	private void create()
	{
		if (started)
		{
			player.setX(0.0f);
			player.setY(0.0f);
			player.setKilled(false);
		}
		else
		{
			player = new Player();
			keyboardInputObservable.addObserver(player);
			keyboardInputObservable.addObserver(this);

			obstructions.add(new Wall(new Vec2(-400f, 300f), 800f, 10f));
			obstructions.add(new Wall(new Vec2(-400f, 300f), 10f, 600f));
			obstructions.add(new Wall(new Vec2(-400f, -290f), 800f, 10f));
			obstructions.add(new Wall(new Vec2(390f, 300f), 10f, 600f));
			obstructions.add(new Wall(new Vec2(-114f, 88f), 20f, 176f));
			obstructions.add(new Wall(new Vec2(-114f, 88f), 228f, 20f));
			obstructions.add(new Wall(new Vec2(94f, 88f), 20f, 176f));
			obstructions.add(new Wall(new Vec2(-114f, -68f), 58f, 20f));
			obstructions.add(new Wall(new Vec2(56f, -68f), 58f, 20f));
			obstructions.add(new Wall(new Vec2(191f, -140f), 20f, 60f));
			obstructions.add(new Wall(new Vec2(191f, -120f), 60f, 20f));
			obstructions.add(new Wall(new Vec2(-220f, 190f), 20f, 340f));
			obstructions.add(new Wall(new Vec2(-200f, 190f), 400f, 20f));
			obstructions.add(new Wall(new Vec2(200f, 190f), 20f, 240f));
			started = true;
		}
		
		obstructions.add(0, new Trap(new Vec2(-390f, -58f), 170f, 72f));
		obstructions.add(0, new Trap(new Vec2(220f, 170f), 170f, 72f));
		obstructions.add(0, new Trap(new Vec2(211f, -140f), 100f, 100f));

		Enemy enemy1 = new Enemy(250.0f, 250.0f);
		Enemy enemy2 = new Enemy(-280.0f, 250.0f);
		Enemy enemy3 = new Enemy(-280.0f, -250.0f);
		EnemyAgent enemyAgent1 = new EnemyAgent();
		EnemyAgent enemyAgent2 = new EnemyAgent();
		EnemyAgent enemyAgent3 = new EnemyAgent();

		enemyAgent1.setArguments(new Object[] {enemy1});
		enemyAgent2.setArguments(new Object[] {enemy2});
		enemyAgent3.setArguments(new Object[] {enemy3});

		String enemyName1 = "enemy" + nthEnemy++;
		String enemyName2 = "enemy" + nthEnemy++;
		String enemyName3 = "enemy" + nthEnemy++;
		
		enemies.add(new Triple(enemyName1, enemyAgent1, enemy1));
		enemies.add(new Triple(enemyName2, enemyAgent2, enemy2));
		enemies.add(new Triple(enemyName3, enemyAgent3, enemy3));
		
		try
		{
			GAME_CONTAINER.acceptNewAgent(enemyName1, enemyAgent1).start();
			GAME_CONTAINER.acceptNewAgent(enemyName2, enemyAgent2).start();
			GAME_CONTAINER.acceptNewAgent(enemyName3, enemyAgent3).start();
		}
		catch (StaleProxyException ex)
		{
			System.out.println("Cannot start enemy agents: " + ex.getMessage());
			doDelete();
		}
	}
	
	private void restart()
	{
		enemies.forEach((t) -> t.getSecond().doDelete());
		enemies.clear();
		obstructions.removeIf((obs) -> obs instanceof Trap);
		create();
		paused = false;
		victorious = false;
		gameOver = false;
		
	}

	private void initializeWindow()
	{
		if (!GLFW.glfwInit())
		{
			throw new IllegalStateException("GLFW won't initialize.");
		}

		GLFW.glfwWindowHint(GLFW.GLFW_RESIZABLE, 0);
		GLFW.glfwWindowHint(GLFW.GLFW_SAMPLES, 4);

		window = GLFW.glfwCreateWindow(WINDOW_WIDTH, WINDOW_HEIGHT, "MASG", 0, 0);
		if (window == 0)
		{
			throw new RuntimeException("Unable to create GLFW window.");
		}

		GLFW.glfwSetInputMode(window, GLFW.GLFW_STICKY_KEYS, 1);
		GLFW.glfwSetKeyCallback(window, this);

		GLFW.glfwMakeContextCurrent(window);
		GLFW.glfwSwapInterval(1);
		GLFW.glfwShowWindow(window);
	}

	private void initializeGL()
	{
		GL.createCapabilities();
		GL11.glClearColor(0.1f, 0.1f, 0.2f, 0.0f);
		GL11.glEnable(GL13.GL_MULTISAMPLE);
		GL11.glEnable(GL11.GL_LINE_SMOOTH);
		GL11.glEnable(GL11.GL_BLEND);
		GL11.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GL11.glMatrixMode(GL11.GL_PROJECTION);
		GL11.glLoadIdentity();
		GL11.glOrtho(-WINDOW_WIDTH / 2, WINDOW_WIDTH / 2, -WINDOW_HEIGHT / 2, WINDOW_HEIGHT / 2, 1.0f, -1.0f);
		GL11.glMatrixMode(GL11.GL_MODELVIEW);
	}
	
	private void draw()
	{
		if (!paused && !victorious && !gameOver)
		{
			player.update();
			obstructions.forEach((o) -> o.processCollision(player));
			enemies.forEach((t) -> t.getThird().processCollision(player));
		}
		
		obstructions.forEach((o) -> o.draw());
		player.draw();
		enemies.forEach((t) -> t.getThird().draw());
		
		if (paused) ScreenDraw.drawPauseScreen(-64f);
		if (victorious) ScreenDraw.drawVictoryScreen(-96f);
		if (gameOver) ScreenDraw.drawGameOverScreen(-150f);
	}

	private void destroy()
	{
		Callbacks.glfwFreeCallbacks(window);
		GLFW.glfwDestroyWindow(window);
		GLFW.glfwTerminate();
	}
	
	private void removeKilledEnemies()
	{
		enemies.removeIf((t) -> t.getSecond().getState() == Agent.AP_DELETED);
	}
	
	private void processMessages()
	{
		ACLMessage message;
		while ((message = receive()) != null)
		{
			if (message.getOntology().equals("trap_removal"))
			{
				try
				{
					Trap trap = (Trap) message.getContentObject();
					obstructions.removeIf((o) -> o.sameAs(trap));
				}
				catch (UnreadableException ex)
				{
					System.out.println("Unable to read Trap object for removal: " + ex.getMessage());
				}
			}
			else if (message.getOntology().equals("updated"))
			{
				try
				{
					Vec2 position = (Vec2) message.getContentObject();
					for (Triple<String, EnemyAgent, Enemy> t : enemies)
					{
						if (message.getSender().getLocalName().equals(t.getFirst()))
						{
							t.getThird().setPosition(position);
						}
					}
				}
				catch (UnreadableException ex)
				{
					System.out.println("Unable to read Vec2 object for update: " + ex.getMessage());
				}
			}
		}
	}

	private void sendShutdownMessage()
	{
		try
		{
			ACLMessage message = MessageFactory.createShutdownMessage(this);
			send(message);
		}
		catch (Codec.CodecException | OntologyException ex)
		{
			System.out.println("Unable to send shutdown message: " + ex.getMessage());
		}
	}

	private void sendUpdateRequest()
	{
		PositionInfo positionInfo = new PositionInfo();
		positionInfo.setPlayerPosition(player.getPosition());
		enemies.forEach((t) -> positionInfo.addEnemy(t.getFirst(), t.getSecond().getEnemy()));
		obstructions.forEach((o) -> positionInfo.addObstruction(o));
		
		try
		{
			ACLMessage updateRequest = MessageFactory.createUpdateRequestMessage(positionInfo, enemies);
			send(updateRequest);
		}
		catch (IOException ex)
		{
			System.out.println("Unable to send update requests: " + ex.getMessage());
			doDelete();
		}
	}
	
	private void checkVictoryCondition()
	{
		if (!victorious && enemies.isEmpty())
		{
			victorious = true;
		}
	}
	
	private void checkGameOverCondition()
	{
		if (player.isKilled())
		{
			gameOver = true;
		}
	}
	

	private class RenderBehaviour extends CyclicBehaviour
	{
		@Override
		public void action()
		{
			GL11.glClear(GL11.GL_COLOR_BUFFER_BIT | GL11.GL_DEPTH_BUFFER_BIT);
			removeKilledEnemies();
			processMessages();
			draw();
			GLFW.glfwSwapBuffers(window);
			
			if (!paused && !victorious && !gameOver) 
			{
				sendUpdateRequest();
			}
			
			checkVictoryCondition();
			checkGameOverCondition();			
			GLFW.glfwPollEvents();
			if (GLFW.glfwWindowShouldClose(window))
			{
				doDelete();
			}
		}
	}

	public static AgentContainer GAME_CONTAINER;
	public static Agent MainAgent = new GameAgent();

	public static void main(String[] args) throws StaleProxyException
	{
		Runtime runtime = Runtime.instance();
		ProfileImpl profile = new ProfileImpl(null, 8080, null);
		GAME_CONTAINER = runtime.createMainContainer(profile);
		GAME_CONTAINER.acceptNewAgent("game-agent", MainAgent).start();
	}
}
