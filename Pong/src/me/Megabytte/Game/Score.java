package me.Megabytte.Game;

public class Score extends GameObject
{
	public Numbers numbers;
	public Numbers numbers2;
	
	public Score() 
	{	
		numbers = new Numbers(0, 20, 64, 64, 0);
		
		numbers2 = new Numbers(576, 20, 64, 64, 1);
	}
	
	public void draw()
	{
		numbers.draw();
		numbers2.draw();
		
		numbers.debug();
		numbers2.debug();
	}
	
	public void update()
	{
		numbers.update();
		numbers2.update();
	}
	
}
