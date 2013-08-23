package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.GL_BLEND;
import static org.lwjgl.opengl.GL11.GL_ONE_MINUS_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_QUADS;
import static org.lwjgl.opengl.GL11.GL_SRC_ALPHA;
import static org.lwjgl.opengl.GL11.GL_TEXTURE_2D;
import static org.lwjgl.opengl.GL11.glBegin;
import static org.lwjgl.opengl.GL11.glBlendFunc;
import static org.lwjgl.opengl.GL11.glColor3d;
import static org.lwjgl.opengl.GL11.glDisable;
import static org.lwjgl.opengl.GL11.glEnable;
import static org.lwjgl.opengl.GL11.glEnd;
import static org.lwjgl.opengl.GL11.glLoadIdentity;
import static org.lwjgl.opengl.GL11.glTexCoord2f;
import static org.lwjgl.opengl.GL11.glVertex2i;

import org.lwjgl.input.Keyboard;
import org.newdawn.slick.opengl.Texture;

public class Paddle extends GameObject
{
	
	public int Player;
	public PongGame localG;
	public Texture paddle;
	public LoadTexture tLoader;
	
 	public Paddle(int tlX, int tlY, int trX, int trY, int blX, int blY, int brX, int brY, float dY, int player) 
	{
 		tLoader = new LoadTexture();
 		paddle = tLoader.loadImage("paddle", paddle);
 		
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
			paddle.bind();
			glLoadIdentity();
			
			glEnable(GL_TEXTURE_2D);
			glEnable(GL_BLEND);
        	glBlendFunc(GL_SRC_ALPHA, GL_ONE_MINUS_SRC_ALPHA);
			
			glBegin(GL_QUADS);	
				glTexCoord2f(0, 0);
				glVertex2i(TLX, TLY);			
				glTexCoord2f(1, 0);
				glVertex2i(TRX, TRY);			
				glTexCoord2f(1, 1);
				glVertex2i(BRX, BRY);
				glTexCoord2f(0, 1);
				glVertex2i(BLX, BLY);
			glEnd();
			
			glDisable(GL_TEXTURE_2D);
			glDisable(GL_BLEND);
			glLoadIdentity();
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
