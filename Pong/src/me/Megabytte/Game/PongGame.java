package me.Megabytte.Game;

import static org.lwjgl.opengl.GL11.*;

import org.lwjgl.openal.AL;
import org.lwjgl.opengl.*;
import org.lwjgl.*;

public class PongGame {
	
	public final int ScreenW = 640, ScreenH = 480;
			
	private static long lastFrame;
	public Paddle p1, p2;
	public Ball b1;
	Score score;
	public Wall w1, w2;
	public SoundController sc;
	public boolean running = true;
	long delta;
	
	public static void main(String[] args) 
	{
		@SuppressWarnings("unused")
		PongGame game = new PongGame();
	}

	public PongGame() 
	{	
		initOpenGL(ScreenW, ScreenH);
		initGame();
		
		while(!Display.isCloseRequested() && running == true)
		{
			delta = (long) getDelta();
			draw();
			update();
			
			Display.update();
			Display.sync(60);
		}
		
		Display.destroy();
		AL.destroy();
		System.exit(0);
	}	
	
	public void update()
	{
		p1.updatePaddles();
		p2.updatePaddles();
		p1.sendGame(this);
		p2.sendGame(this);
		b1.sendGame(this);
		b1.updateBall();
		b1.move();
	}
	
	public void draw()
	{
		glClear(GL_COLOR_BUFFER_BIT);
		
	//	score.draw();
		w1.Draw();
		w2.Draw();
		b1.Draw();
		p1.Draw();
		p2.Draw();
	}
	
	public void initOpenGL(int screenw, int screenh)
	{
		try
		{
			Display.setDisplayMode(new DisplayMode(screenw, screenh));
			Display.setTitle("Pong Game");
			Display.create();
			Display.setVSyncEnabled(true);
			Display.setResizable(false);
		} catch (LWJGLException e) { e.printStackTrace();}
				
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, screenw, screenh, 0, 1, -1);
		glMatrixMode(GL_MODELVIEW);
		glEnable(GL_TEXTURE_2D);
	}
	
	public void initGame()
	{
		lastFrame = getTime();
		sc = new SoundController();
		score = new Score();
		
		w1 = new Wall(0, 0, ScreenW, 0, 0, 10, ScreenW, 10);
		w2 = new Wall(0, ScreenH - 10, ScreenW, ScreenH - 10, 0, ScreenH, ScreenW, ScreenH);
		p1 = new Paddle(50, 200, 55, 200, 50, 326, 55, 326, 0.5f, 1);
		p2 = new Paddle(590, 200, 595, 200, 590, 326, 595, 326, 0.5f, 2);
		b1 = new Ball(310, 230, 320, 230, 310, 240, 320, 240, 0.2f, 0.2f);
	}
	
	private static long getTime() 
	{
		return (Sys.getTime() * 1000) / Sys.getTimerResolution();
	}
	
	private static double getDelta() 
	{
		long currentTime = getTime();
		double delta = (double) currentTime - (double) lastFrame;
		lastFrame = getTime();
		return delta;
	}
}

