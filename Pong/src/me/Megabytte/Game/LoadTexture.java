package me.Megabytte.Game;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.newdawn.slick.opengl.Texture;
import org.newdawn.slick.opengl.TextureLoader;

public class LoadTexture 
{	
	Texture texture;
	
	
	public LoadTexture() 
	{
		
	}
	
	public Texture loadImage(String key, Texture texture)
	{		
		try {
			texture = TextureLoader.getTexture("PNG", new FileInputStream(new File("res/Images/" + key + ".png")));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return texture;
	}
	
	
}
