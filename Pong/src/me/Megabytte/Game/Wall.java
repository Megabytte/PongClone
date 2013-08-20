package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.*;

public class Wall extends GameObject
{
	public Wall(int tlX, int tlY, int trX, int trY, int blX, int blY, int brX, int brY) 
	{
		TLX = tlX;
		TLY = tlY;
		TRX = trX;
		TRY = trY;
		BLX = blX;
		BLY = blY;
		BRX = brX;
		BRY = brY;	
	}
	
	public void Draw()
	{
		glBegin(GL_QUADS);
			glColor3f(0.32F, 0.32F, 0.32F);
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
