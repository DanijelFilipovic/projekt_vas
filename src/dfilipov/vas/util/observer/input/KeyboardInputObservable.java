package dfilipov.vas.util.observer.input;

import java.util.ArrayList;

public class KeyboardInputObservable
{
	private final ArrayList<KeyboardInputObserver> observers = new ArrayList<>();

	public void addObserver(KeyboardInputObserver observer)
	{
		observers.add(observer);
	}

	public void removeObserver(KeyboardInputObserver observer)
	{
		observers.remove(observer);
	}

	public void clear()
	{
		observers.clear();
	}

	public void notifyObservers(int key, int action)
	{
		for (int i = 0; i < observers.size(); i++)
		{
			observers.get(i).onNotify(key, action);
		}
	}
}
