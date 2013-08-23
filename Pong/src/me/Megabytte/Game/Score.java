package me.Megabytte.Game;

public class Score extends GameObject
{
	public Numbers numbers;
	public Numbers numbers2;
	
	public Score() 
	{	
		numbers = new Numbers(0, 10, 32, 32);
		
		numbers2 = new Numbers(608, 10, 32, 32);
	}
	
	public void draw()
	{
		numbers.draw();
		numbers2.draw();
	}
	
	public void update()
	{
		numbers.update();
		numbers2.update();
	}
	
}
