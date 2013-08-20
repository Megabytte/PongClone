package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.*;

import java.util.Random;

import org.lwjgl.input.Keyboard;

public class Ball extends GameObject
{
	int sleep = 35;
	public int direction = 0;
	public int start = 0;
	Random rand = new Random();
	private PongGame localG;
	public boolean isAlive = true;
	int lastHit = 0;
	volatile boolean soundCoolDown;
	
	public Ball(int tlX, int tlY, int trX, int trY, int blX, int blY, int brX, int brY, float dX, float dY) 
	{
		TLX = tlX;
		TLY = tlY;
		TRX = trX;
		TRY = trY;
		BLX = blX;
		BLY = blY;
		BRX = brX;
		BRY = brY;
		DX = dX;
		DY = dY;
		
		randomStart();
		
	}
	
	public void randomStart()
	{
		start = rand.nextInt(2);
		switch(start)
		{	
		    case 0: direction = 6;
		    break;
			case 1: direction = 5;
			break;
			case 2: direction = 5;
			break;
			case 3: direction = 6;
			break;
		}
	}
	
	public void setDirection(int a)
	{
		direction = a;
	}
	
	public void Draw()
	{
		if(isAlive)
		{	
			glBegin(GL_QUADS);
				glColor3d(1, 0, 0);
				//Top Left (0,0)
				glVertex2i(TLX, TLY);
				//Top Right (1,0)
				glVertex2i(TRX, TRY);
				//Low Right (1,1)
				glVertex2i(BRX, BRY);
				//Low Left (0,1)
				glVertex2i(BLX, BLY);
				glColor3d(1, 1, 1);
			glEnd();
		}
	}
	
	public void sendGame(PongGame game1)
	{
		localG = game1;
	}
	
	public void updateBall()
	{	
		if(isAlive == false)
		{
			TLX = 310;
			TLY = 230;
			TRX = 320;
			TRY = 230;
			BLX = 310;
			BLY = 240;
			BRX = 320;
			BRY = 240;
			isAlive = true;
			DX = 0.2f;
			DY = 0.2f;
			randomStart();
		}
		else
		{
		//Paddle 1
		if(TLX <= localG.p1.TRX && TLY >= localG.p1.TRY && BLX <= localG.p1.BRX && BLY <= localG.p1.BRY)
		{
			lastHit = 1;
			localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
			soundCoolDown = true;
			new Thread(new Runnable() {
				
				@Override
				public void run() 
				{
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) { e.printStackTrace(); }
					finally
					{
						soundCoolDown = false;
					}
				}
			}).run();
			if(Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				setDirection(2);
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				setDirection(3);
			}
			else
			{
				if(direction == 1)
				{
					setDirection(2);
				}
				else if(direction == 4)
				{
					setDirection(3);
				}
				else
					setDirection(3);
			}
			if(DX <= 2 && DY <= 2)
			{
				DX += 0.02; 
				DY += 0.02;
			}
		}
		//Paddle 2
		if(TRX >= localG.p2.TLX && TRY >= localG.p2.TLY && BRX >= localG.p1.BLX && BRY <= localG.p2.BLY)
		{
			if(DX <= 2 && DY <= 2)
			{
				DX += 0.02; 
				DY += 0.02;
			}
			lastHit = 2;
			localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
			soundCoolDown = true;
			new Thread(new Runnable() {
				
				@Override
				public void run() 
				{
					try {
						Thread.sleep(sleep);
					} catch (InterruptedException e) { e.printStackTrace(); }
					finally
					{
						soundCoolDown = false;
					}	
				}
			}).run();
			if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			{
				setDirection(1);
			}
			else if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			{
				setDirection(4);
			}
			else
			{
				if(direction == 3)
				{
					setDirection(4);
				}
				else if(direction == 2)
				{
					setDirection(1);
				}
				else	
					setDirection(1);
			}
		}
		
		if(TLY <= 10)
		{
			if(lastHit == 1)
			{
				setDirection(3);
				localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
			}
			if(lastHit == 2)
			{
				localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
				setDirection(4);
			}
		}
		if(BLY >= 470)
		{
			if(lastHit == 1)
			{
				localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
				setDirection(2);
			}
			if(lastHit == 2)
			{
				setDirection(1);
				localG.sc.hit.playAsSoundEffect(1.0f, 1.0f, false);
			}
		}
		if(TLX <= 0)
		{
			isAlive = false;
		}
		if(TRX >= localG.ScreenW)
		{
			isAlive = false;
		}
	}
	}
	
	public void move()
	{
		switch(direction)
		{
			//1 Up/Left
			case 1:
			{
				TLY -= DY * localG.delta;
				TRY -= DY * localG.delta;
				BLY -= DY * localG.delta;
				BRY -= DY * localG.delta;
				
				TLX -= DX * localG.delta;
				BLX -= DX * localG.delta;
				TRX -= DX * localG.delta;
				BRX -= DX * localG.delta;
			}
			break;
			//4 Up/Right
			case 2:
			{
				TLY -= DY * localG.delta;
				TRY -= DY * localG.delta;
				BLY -= DY * localG.delta;
				BRY -= DY * localG.delta;
				
				TLX += DX * localG.delta;
				BLX += DX * localG.delta;
				TRX += DX * localG.delta;
				BRX += DX * localG.delta;
			}
			break;
			//3 Low/Right
			case 3:
			{
				TLY += DY * localG.delta;
				TRY += DY * localG.delta;
				BLY += DY * localG.delta;
				BRY += DY * localG.delta;
				
				TLX += DX * localG.delta;
				BLX += DX * localG.delta;
				TRX += DX * localG.delta;
				BRX += DX * localG.delta;
			}
			break;
			//4 Low/Left
			case 4:
			{
				TLY += DY * localG.delta;
				TRY += DY * localG.delta;
				BLY += DY * localG.delta;
				BRY += DY * localG.delta;
				
				TLX -= DX * localG.delta;
				BLX -= DX * localG.delta;
				TRX -= DX * localG.delta;
				BRX -= DX * localG.delta;
			}
			break;
			case 5:
			{
				TLX -= DX * localG.delta;
				BLX -= DX * localG.delta;
				TRX -= DX * localG.delta;
				BRX -= DX * localG.delta;
			}
			break;
			case 6:
			{
				TLX += DX * localG.delta;
				BLX += DX * localG.delta;
				TRX += DX * localG.delta;
				BRX += DX * localG.delta;
			}
			break;
		}
	}
}
