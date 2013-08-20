package me.Megabytte.Game;

public class Score extends GameObject
{
	public Numbers numbers;
	
	public Score() 
	{
		numbers = new Numbers(0, 0, 0, 212, 302);
		numbers.identifyImage();
	}
	
	public void draw()
	{
		numbers.draw();
	}
}
