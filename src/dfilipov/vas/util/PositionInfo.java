package dfilipov.vas.util;

import dfilipov.vas.math.Vec2;
import dfilipov.vas.object2d.Enemy;
import dfilipov.vas.object2d.obstruction.Obstruction;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PositionInfo implements Serializable
{
	private Vec2 playerPosition = null;
	private final Map<String, Enemy> enemies = new HashMap<>();
	private final List<Obstruction> obstructions = new ArrayList<>();

	public Vec2 getPlayerPosition()
	{
		return playerPosition;
	}

	public Map<String, Enemy> getEnemies()
	{
		return enemies;
	}
	
	public List<Obstruction> getObstructions()
	{
		return obstructions;
	}

	public void setPlayerPosition(Vec2 playerPosition)
	{
		this.playerPosition = playerPosition.copy();
	}

	public void addEnemy(String key, Enemy enemy)
	{
		enemies.put(key, enemy);
	}
	
	public void addObstruction(Obstruction obs)
	{
		obstructions.add(obs);
	}
}
