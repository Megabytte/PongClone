package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.TextureImpl;
import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.opengl.Texture;
// 138 x 232 All Image Dimensions

public class Numbers extends GameObject
{
	public int X, Y, Image = 0;
	public Texture t1, t2, t3, t4, t5, t6, t7, t8, t9, t0;
	public LoadTexture tLoader;
	public int Board = 0;
	
	public Numbers(int x, int y, int DimWidth, int DimHeight, int board)
	{
		tLoader = new LoadTexture();
		
		Board = board;
		
		X = x;
		Y = y;
		
		TLX = x;
		TLY = y;
		TRX = x + DimWidth;
		TRY = y;
		BRX = x + DimWidth;
		BRY = y + DimHeight;
		BLX = x;
		BLY = y + DimHeight;
		initImages();
	}
	
	public void initImages()
	{
		t0 = tLoader.loadImage("numbers/0", t0);
		t1 = tLoader.loadImage("numbers/1", t1);
		t2 = tLoader.loadImage("numbers/2", t2);
		t3 = tLoader.loadImage("numbers/3", t3);
		t4 = tLoader.loadImage("numbers/4", t4);
		t5 = tLoader.loadImage("numbers/5", t5);
		t6 = tLoader.loadImage("numbers/6", t6);
		t7 = tLoader.loadImage("numbers/7", t7);
		t8 = tLoader.loadImage("numbers/8", t8);
		t9 = tLoader.loadImage("numbers/9", t9);
	}
	
	public void debug()
	{
	//	if(Board == 0)
		//	System.err.println("Board 0: " + Image );
		
	//	if(Board == 1)
		//	System.err.println("Board 1: " + Image );
	}
		
	public void draw()
	{	
		switch(Image)
		{
			case 0: t0.bind();
				break;
			case 1: t1.bind();
				break;
			case 2: t2.bind();
				break;
			case 3: t3.bind();
				break;
			case 4: t4.bind();
				break;
			case 5: t5.bind();
				break;
			case 6: t6.bind();
				break;
			case 7: t7.bind();
				break;
			case 8: t8.bind();
				break;
			case 9: t9.bind();
				break;
		}
		
		
		glLoadIdentity();
		
		glEnable(GL_TEXTURE_2D);
		
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
		
		glLoadIdentity();
		
	}
	
	public void update()
	{
		
	}
	
	public void changeImage(int image)
	{
		Image = image;
	}
	
	
}
