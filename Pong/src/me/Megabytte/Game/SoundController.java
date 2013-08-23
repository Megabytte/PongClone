package me.Megabytte.Game;

import java.io.IOException;

import org.newdawn.slick.openal.Audio;
import org.newdawn.slick.openal.AudioLoader;
import org.newdawn.slick.util.ResourceLoader;

public class SoundController
{
	public Audio hit, point, gameover, startup;
	
	public SoundController() 
	{
		try 
		{
			hit = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/sounds/Hit.ogg"));
			point = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/sounds/point.ogg"));
			gameover = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/sounds/gameover.ogg"));
			startup = AudioLoader.getAudio("OGG", ResourceLoader.getResourceAsStream("res/sounds/startup.ogg"));
		}
		catch (IOException e) { e.printStackTrace(); }
	}
}
