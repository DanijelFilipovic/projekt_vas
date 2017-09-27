package dfilipov.vas.object2d.obstruction;

import dfilipov.vas.collision.Collider;
import dfilipov.vas.collision.CollisionSide;
import dfilipov.vas.math.Vec2;

public class Wall extends Obstruction
{
	private final float red = 0.2f;
	private final float green = 0.2f;
	private final float blue = 1.0f;
	
	public Wall(Vec2 point, float width, float height)
	{
		super(point, width, height);
	}
	
	@Override
	public void processCollision(Collider collider)
	{
		int collisionSide = checkCollisionSide(collider);
		if (collisionSide != CollisionSide.NONE)
		{
			collider.relocate(collisionSide);
		}
	}

	@Override
	public float getRadius(Collider collider)
	{
		return collider.getRadius();
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
