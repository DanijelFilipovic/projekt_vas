package dfilipov.vas.object2d.obstruction;

import dfilipov.vas.collision.Collider;
import dfilipov.vas.collision.CollisionSide;
import dfilipov.vas.math.Vec2;

public class Trap extends Obstruction
{
	private final float red = 1.0f;
	private final float green = 0.2f;
	private final float blue = 0.2f;
	
	public Trap(Vec2 point, float width, float height)
	{
		super(point, width, height);
	}
	
	@Override
	public void processCollision(Collider collider)
	{
		int collisionSide = checkCollisionSide(collider);
		if (collisionSide != CollisionSide.NONE)
		{
			collider.kill(this);
		}
	}

	@Override
	public float getRadius(Collider collider)
	{
		return 5f;
	}

	@Override
	protected float getRed()
	{
		return red;
	}

	@Override
	protected float getGreen()
	{
		return green;
	}

	@Override
	protected float getBlue()
	{
		return blue;
	}
}
