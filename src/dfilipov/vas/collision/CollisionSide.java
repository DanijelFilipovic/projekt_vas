package dfilipov.vas.collision;

public class CollisionSide
{
	public static final int NONE	= 0;
	public static final int TOP		= 1 << 1;
	public static final int LEFT	= 1 << 2;
	public static final int RIGHT	= 1 << 3;
	public static final int BOTTOM	= 1 << 4;
	
	public static boolean isTop(int collisionSide)
	{
		return (collisionSide & TOP) != NONE;
	}
	
	public static boolean isLeft(int collisionSide)
	{
		return (collisionSide & LEFT) != NONE;
	}
	
	public static boolean isRight(int collisionSide)
	{
		return (collisionSide & RIGHT) != NONE;
	}
	
	public static boolean isBottom(int collisionSide)
	{
		return (collisionSide & BOTTOM) != NONE;
	}
}
