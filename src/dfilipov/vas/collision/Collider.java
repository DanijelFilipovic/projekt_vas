package dfilipov.vas.collision;

import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.obstruction.Trap;

public abstract class Collider
{
	public void relocate(int collisionSide)
	{
		if (CollisionSide.isTop(collisionSide)) getPosition().translateY(getVelocity());
		if (CollisionSide.isLeft(collisionSide)) getPosition().translateX(-getVelocity());
		if (CollisionSide.isRight(collisionSide)) getPosition().translateX(getVelocity());
		if (CollisionSide.isBottom(collisionSide)) getPosition().translateY(-getVelocity());
	}
	
	public void relocate(Vec2 relocation)
	{
		getPosition().translate(relocation);
	}
	
	public abstract Vec2 getPosition();
	public abstract float getVelocity();
	public abstract float getRadius();
	public abstract void kill(Trap trap);
}
