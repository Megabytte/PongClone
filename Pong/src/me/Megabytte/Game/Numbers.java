package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.TextureLoader;
import org.newdawn.slick.opengl.Texture;
// 138 x 232 All Image Dimensions

public class Numbers extends GameObject
{
	public int X, Y, IMAGE;
	public Texture t1, t2, t3, t4, t5, t6, t7, t8, t9, t0;
	
	public Numbers(int x, int y, int image, int DimX, int DimY)
	{
		X = x;
		Y = y;
		IMAGE = image;
		
		TLX = x;
		TLY = y;
		TRX = x + DimX;
		TRY = y;
		BRX = x + DimX;
		BRY = y + DimY;
		BLX = x;
		BLY = y + DimY;
		initImages();
	}
	
	public void initImages()
	{
		loadImage("0", t0);
		loadImage("1", t1);
		loadImage("2", t2);
		loadImage("3", t3);
		loadImage("4", t4);
		loadImage("5", t5);
		loadImage("6", t6);
		loadImage("7", t7);
		loadImage("8", t8);
		loadImage("9", t9);
	}
	
	public void loadImage(String key, Texture texture)
	{
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/images/numbers/" + key + ".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void identifyImage()
	{
		switch(IMAGE)
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
	}
	
	
	public void draw()
	{		
		glBegin(GL_QUADS);
			glVertex2i(TLX, TLY);
			glVertex2i(TRX, TRY);
			glVertex2i(BRX, BRY);
			glVertex2i(BLX, BLY);
		glEnd();
	}
	
	public void update()
	{
		
	}
	
	
}
