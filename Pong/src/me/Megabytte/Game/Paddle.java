package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.input.Keyboard;

public class Paddle extends GameObject
{
	
	public int Player;
	public PongGame localG;
	
 	public Paddle(int tlX, int tlY, int trX, int trY, int blX, int blY, int brX, int brY, float dY, int player) 
	{
		TLX = tlX;
		TLY = tlY;
		TRX = trX;
		TRY = trY;
		BLX = blX;
		BLY = blY;
		BRX = brX;
		BRY = brY;
		DY = dY;
		Player = player;
	}
	
	public void Draw()
	{
		if(Player == 1)
		{
			glBegin(GL_QUADS);
				glColor3d(0, 1, 0);
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
		else if(Player == 2)
		{
			glBegin(GL_QUADS);
				glColor3d(0, 0, 1);
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
	
	public void updatePaddles()
	{
		if(Player == 1)
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_S))
			{
				if(BLY >=  470) {}
				else
				{
					TLY += DY * localG.delta;
					TRY += DY * localG.delta;
					BLY += DY * localG.delta;
					BRY += DY * localG.delta;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_W))
			{
				if(TLY <= 10) {}
				else
				{
					TLY -= DY * localG.delta;
					TRY -= DY * localG.delta;
					BLY -= DY * localG.delta;
					BRY -= DY * localG.delta;
				}
			}
			
		}else if(Player == 2)
		{
			if(Keyboard.isKeyDown(Keyboard.KEY_DOWN))
			{
				if(BLY >=  470) {}
				else
				{
					TLY += DY * localG.delta;
					TRY += DY * localG.delta;
					BLY += DY * localG.delta;
					BRY += DY * localG.delta;
				}
			}
			if(Keyboard.isKeyDown(Keyboard.KEY_UP))
			{
				if(TLY <= 10) {}
				else
				{
					TLY -= DY * localG.delta;
					TRY -= DY * localG.delta;
					BLY -= DY * localG.delta;
					BRY -= DY * localG.delta;
				}
			}
		}
		else
		{
			System.out.println("Error! No Player Found!");
		}	
	}
	
	public void sendGame(PongGame game1)
	{
		localG = game1;
	}
}
