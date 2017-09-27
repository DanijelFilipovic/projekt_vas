package dfilipov.vas.object2d;

import dfilipov.vas.collision.Collider;
import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.obstruction.Trap;
import org.lwjgl.glfw.GLFW;
import org.lwjgl.opengl.GL11;
import dfilipov.vas.util.observer.input.KeyboardInputObserver;

public class Player extends Collider implements Drawable, KeyboardInputObserver 
{
	private final float RADIUS = 25.0f;
	private final float VELOCITY = 4f;

	private Vec2 position;

	private boolean moveUp = false;
	private boolean moveDown = false;
	private boolean moveLeft = false;
	private boolean moveRight = false;

	private boolean killed = false;
	
	public Player()
	{
		this.position = new Vec2(0.0f, 0.0f);
	}

	public Player(float x, float y)
	{
		this.position = new Vec2(x, y);
	}

	public Player(float radius, Vec2 position)
	{
		this.position = position.copy();
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

	public void update()
	{
		if (moveUp)	position.translateY(VELOCITY);
		if (moveDown) position.translateY(-VELOCITY);
		if (moveLeft) position.translateX(-VELOCITY);
		if (moveRight) position.translateX(VELOCITY);
	}

	@Override
	public void draw()
	{
		float radians = (float) (Math.PI / 180.0d);
		
		GL11.glColor3f(1.0f, 0.8f, 0.0f);
		GL11.glBegin(GL11.GL_POLYGON);
		for (int i = 0; i < 360; i++)
		{
			float r = i * radians;
			float x = (float) (Math.cos(r) * RADIUS);
			float y = (float) (Math.sin(r) * RADIUS);
			GL11.glVertex2f(position.getX() + x, position.getY() + y);
		}
		GL11.glEnd();
		
		GL11.glColor3f(0.3f, 0.1f, 0.0f);
		GL11.glBegin(GL11.GL_POLYGON);
		for (int i = 0; i < 360; i++)
		{
			float r = i * radians;
			float x = (float) (Math.cos(r) * 5);
			float y = (float) (Math.sin(r) * 5);
			GL11.glVertex2f(position.getX() - 10 + x, position.getY() + 5 + y);
		}
		GL11.glEnd();
		GL11.glBegin(GL11.GL_POLYGON);
		for (int i = 0; i < 360; i++)
		{
			float r = i * radians;
			float x = (float) (Math.cos(r) * 5);
			float y = (float) (Math.sin(r) * 5);
			GL11.glVertex2f(position.getX() + 10 + x, position.getY() + 5 + y);
		}
		GL11.glEnd();
		GL11.glBegin(GL11.GL_LINE_STRIP);
		for (int i = 180; i <= 360; i++)
		{
			float r = i * radians;
			float x = (float) (Math.cos(r) * 17.5f);
			float y = (float) (Math.sin(r) * 17.5f);
			GL11.glVertex2f(position.getX() + x, position.getY() + y);
		}
		GL11.glEnd();
	}

	@Override
	public void onNotify(int key, int action)
	{
		boolean set = action != GLFW.GLFW_RELEASE;
		switch (key)
		{
			case GLFW.GLFW_KEY_UP:
			{
				moveUp = set;
				break;
			}
			case GLFW.GLFW_KEY_DOWN:
			{
				moveDown = set;
				break;
			}
			case GLFW.GLFW_KEY_LEFT:
			{
				moveLeft = set;
				break;
			}
			case GLFW.GLFW_KEY_RIGHT:
			{
				moveRight = set;
				break;
			}
		}
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
	
	public boolean isKilled()
	{
		return killed;
	}
	
	public void setKilled(boolean killed)
	{
		this.killed = killed;
	}

	@Override
	public void kill(Trap trap)
	{
		killed = true;
	}
}
