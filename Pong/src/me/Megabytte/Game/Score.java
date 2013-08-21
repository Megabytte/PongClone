package me.Megabytte.Game;

public class Score extends GameObject
{
	public Numbers numbers;
	
	public Score() 
	{
		// 106 was 212 and 152 was 304
		
		numbers = new Numbers(0, 20, 0, 64, 64);
		numbers.identifyImage();
	}
	
	public void draw()
	{
		numbers.draw();
	}
	
	public void update()
	{
		numbers.update();
	}
	
}
