package dfilipov.vas.math;

import java.io.Serializable;

public class Vec2 implements Serializable
{
	private float x;
	private float y;

	public Vec2()
	{
		this.x = 0.0f;
		this.y = 0.0f;
	}

	public Vec2(float x, float y)
	{
		this.x = x;
		this.y = y;
	}

	public float getX()
	{
		return x;
	}

	public float getY()
	{
		return y;
	}

	public void setX(float x)
	{
		this.x = x;
	}

	public void setY(float y)
	{
		this.y = y;
	}

	public Vec2 subtract(Vec2 other)
	{
		x -= other.x;
		y -= other.y;
		return this;
	}
	
	public float dot(Vec2 other)
	{
		return (x * other.x) + (y * other.y);
	}

	public Vec2 translate(float xAmount, float yAmount)
	{
		x += xAmount;
		y += yAmount;
		return this;
	}

	public Vec2 translate(Vec2 other)
	{
		x += other.x;
		y += other.y;
		return this;
	}

	public Vec2 translateX(float xAmount)
	{
		x += xAmount;
		return this;
	}

	public Vec2 translateY(float yAmount)
	{
		y += yAmount;
		return this;
	}

	public float distance(float x, float y)
	{
		float xDiff = this.x - x;
		float yDiff = this.y - y;
		return (float) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}

	public float distance(Vec2 other)
	{
		float xDiff = this.x - other.x;
		float yDiff = this.y - other.y;
		return (float) Math.sqrt(Math.pow(xDiff, 2) + Math.pow(yDiff, 2));
	}

	public float length()
	{
		return (float) Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}

	public Vec2 scalar(float scl)
	{
		x *= scl;
		y *= scl;
		return this;
	}

	public Vec2 normalize()
	{
		float length = length();
		x /= length;
		y /= length;
		return this;
	}

	public Vec2 copy()
	{
		return new Vec2(x, y);
	}
}
