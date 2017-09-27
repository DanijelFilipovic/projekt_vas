package dfilipov.vas.object2d.obstruction;

import dfilipov.vas.collision.Collider;
import dfilipov.vas.collision.CollisionSide;
import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.Drawable;
import java.io.Serializable;
import org.lwjgl.opengl.GL11;
import dfilipov.vas.collision.Collideable;

public abstract class Obstruction implements Drawable, Serializable, Collideable
{
	protected final Vec2 point;
	protected final float width;
	protected final float height;

	public Obstruction(Vec2 point, float width, float height)
	{
		this.point = point;
		this.width = width;
		this.height = height;
	}

	public Vec2 getPoint()
	{
		return point;
	}

	public float getWidth()
	{
		return width;
	}

	public float getHeight()
	{
		return height;
	}
	
	@Override
	public void draw()
	{
		GL11.glBegin(GL11.GL_POLYGON);
		GL11.glColor3f(getRed(), getGreen(), getBlue());
		GL11.glVertex2f(point.getX(), point.getY());
		GL11.glVertex2f(point.getX() + width, point.getY());
		GL11.glVertex2f(point.getX() + width, point.getY() - height);
		GL11.glVertex2f(point.getX(), point.getY() - height);
		GL11.glEnd();
	}
	
	protected int checkCollisionSide(Collider collider)
	{
		int collisionSide = CollisionSide.NONE;
		
		if (checkTopCollision(collider)) collisionSide = collisionSide | CollisionSide.TOP;
		if (checkLeftCollision(collider)) collisionSide = collisionSide | CollisionSide.LEFT;
		if (checkRightCollision(collider)) collisionSide = collisionSide | CollisionSide.RIGHT;
		if (checkBottomCollision(collider)) collisionSide = collisionSide | CollisionSide.BOTTOM;
		
		return collisionSide;
	}

	protected boolean checkTopCollision(Collider collider)
	{
		Vec2 colliderVec = collider.getPosition().copy();
		colliderVec.subtract(point);
		
		if (colliderVec.length() <= getRadius(collider))
		{
			return true;
		}
		
		Vec2 edge = new Vec2(point.getX() + width, point.getY());
		edge.subtract(point);
		
		float edgeMagnitude = (float) Math.pow(edge.length(), 2);
		float scalar = edge.dot(colliderVec) / edgeMagnitude;
		if (scalar >= 0.0f && scalar <= 1.0f)
		{
			Vec2 projection = edge.copy().scalar(scalar);
			Vec2 rejection = colliderVec.copy().subtract(projection);
			if (rejection.length() <= getRadius(collider))
			{
				return true;
			}
		}
		return false;
	}

	protected boolean checkRightCollision(Collider collider)
	{
		Vec2 colliderVec = collider.getPosition().copy();
		colliderVec.subtract(new Vec2(point.getX() + width, point.getY()));
		
		if (colliderVec.length() <= getRadius(collider))
		{
			return true;
		}
		
		Vec2 edge = new Vec2(point.getX() + width, point.getY() - height);
		edge.subtract(new Vec2(point.getX() + width, point.getY()));
		
		float edgeMagnitude = (float) Math.pow(edge.length(), 2);
		float scalar = edge.dot(colliderVec) / edgeMagnitude;
		if (scalar >= 0.0f && scalar <= 1.0f)
		{
			Vec2 projection = edge.copy().scalar(scalar);
			Vec2 rejection = colliderVec.copy().subtract(projection);
			if (rejection.length() <= getRadius(collider))
			{
				return true;
			}
		}
		return false;
	}

	protected boolean checkBottomCollision(Collider collider)
	{
		Vec2 colliderVec = collider.getPosition().copy();
		colliderVec.subtract(new Vec2(point.getX() + width, point.getY() - height));
		
		if (colliderVec.length() <= getRadius(collider))
		{
			return true;
		}
		
		Vec2 edge = new Vec2(point.getX(), point.getY() - height);
		edge.subtract(new Vec2(point.getX() + width, point.getY() - height));
		
		float edgeMagnitude = (float) Math.pow(edge.length(), 2);
		float scalar = edge.dot(colliderVec) / edgeMagnitude;
		if (scalar >= 0.0f && scalar <= 1.0f)
		{
			Vec2 projection = edge.copy().scalar(scalar);
			Vec2 rejection = colliderVec.copy().subtract(projection);
			if (rejection.length() <= getRadius(collider))
			{
				return true;
			}
		}
		return false;
	}

	protected boolean checkLeftCollision(Collider collider)
	{
		Vec2 colliderVec = collider.getPosition().copy();
		colliderVec.subtract(new Vec2(point.getX(), point.getY() - height));
		
		if (colliderVec.length() <= getRadius(collider))
		{
			return true;
		}
		
		Vec2 edge = point.copy();
		edge.subtract(new Vec2(point.getX(), point.getY() - height));
		
		float edgeMagnitude = (float) Math.pow(edge.length(), 2);
		float scalar = edge.dot(colliderVec) / edgeMagnitude;
		if (scalar >= 0.0f && scalar <= 1.0f)
		{
			Vec2 projection = edge.copy().scalar(scalar);
			Vec2 rejection = colliderVec.copy().subtract(projection);
			if (rejection.length() <= getRadius(collider))
			{
				return true;
			}
		}
		return false;
	}
	
	public boolean sameAs(Obstruction other)
	{
		return point.getX() == other.point.getX()
			&& point.getY() == other.point.getY()
			&& width == other.width
			&& height == other.height;
	}
	
	protected abstract float getRed();
	protected abstract float getGreen();
	protected abstract float getBlue();
	protected abstract float getRadius(Collider collider);
}
