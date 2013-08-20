package me.Megabytte.Game;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SoundController
{
	public Audio hit;
	
	public SoundController() 
	{
		try 
		{
			hit = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/sounds/Hit.ogg"));
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
