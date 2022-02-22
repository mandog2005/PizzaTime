package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.util.spi.ResourceBundleControlProvider;
import java.awt.SplashScreen;

import javax.swing.*;



import Character.Car;
import Character.Police;
import Character.Character;
import rewards.Pizza;
import rewards.Reward;
import tile.TileChecker;
/**
 * This is handle the game's main engine and binds all the logic together
 * also sets up the initial values of characters and etc.
 * please refer to @Main for Jpanel controls.
 * @author Ali Alden
 *
 */
public class GameScreen extends JPanel implements Runnable{
	
	final static int N = 16;

	//SCREEN SETTINGS OPTION
	final int originalTileSize = N; //NXN grid N = 16
	final int scale = 3; //scaling 16 bit game for modern monitors
	
	public final int tileSize = originalTileSize * scale; //3 (NxN) tile
	public final int maxScreenCol = 24; //24* 48 pixels
	public final int maxScreenRow = 18; //18* 48 pixels

	
	public final int screenWidth = tileSize * maxScreenCol; //1152 pixels x 862 pixels
	public final int screenHeight = tileSize * maxScreenRow; 
	final int FPS = 60; //setting fps to 60
	
	Image titleScreenImage = Toolkit.getDefaultToolkit().createImage("/screens/intro.jpg");

	Controller control = new Controller();
	Car player1 = new Car(this,control);
	Police police1 = new Police(this, control,16,1);
	Police police2 = new Police(this, control,1,1);
	public TileChecker tileManager = new TileChecker(this);
	public CollisionChecker checker = new CollisionChecker(this);
	public RewardSetter rsetter = new RewardSetter(this);
	public Reward obj[] = new Reward[20]; //we can display up to 10 object at the same time.


	Thread gameThread;
	Thread gameThread1;
	Screens screen = new Screens();
	 
	
	/* game panel constructor*/
	public GameScreen()
	{
		
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.black);
		this.addKeyListener(control);
		this.setFocusable(true);
		this.setVisible(true);
		
		
	}
	

	public void setupGame()
	{
		rsetter.setObject();
	}

	
	public void startGameThread() //keeps the game in a loop.
	{
		long currentTime = System.nanoTime(); //update too fast for our CPU. setting to 60 FPS  
	   
		gameThread = new Thread(this);
		gameThread.start(); // this is going to call run() method. -Ali
		
		
	}
	

	public void startScreen()
	{
		
	}

	public void update()
	{
		
		
		player1.update(); //call update method from car
		police1.update(player1);
		police2.update(player1);
		if(posCheck(player1,police1) || posCheck(player1,police2))
		{
			System.out.println("Game has ended");
			control.startPress = false;
			screen.endGame = true;
			
		}
		if(posCheck(player1, obj[0]))
		{
			System.out.println("Pizza picked");
			player1.setHasPizza(true);
			
			((Pizza) obj[0]).update( player1.getHasPizza());
		}
		
		/*if(posCheck(player1, obj[2]))
		{
			System.out.println("Wrench picked");
			player1.setHasWrench(true);
			
			((Pizza) obj[2]).update( player1.getHasWrench());
		}*/
		
	}
	public boolean posCheck(Character player, Character police)
	{
		if(player.x/48 == police.x/48 && police.y/48 == player.y/48)
		{
			return true;
		}
		return false;
	}
	
	public boolean posCheck(Character player, Reward reward)
	{
		if(player.x/48 == reward.x/48 && reward.y/48 == player.y/48)
		{
			return true;
		}
		return false;
	}
	
	  @Override //draw player.
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;
	      
	        
	        if(control.startPress == false)
	        {
	        	((Screens) screen).draw(g2d);
	        }
	        
	        else {
	        
	        
	        //load tile
	        tileManager.draw(g2d);
	        
	        //load object draw which obj? obj.length = array size
	        for(int i = 0; i<obj.length;i++)
	        {
	        	if(obj[i] != null)
	        	{
	        		obj[i].draw(g2d, this);
	        	}
	        }
	        
	        //load player
	        	player1.draw(g2d);
	        	police1.draw(g2d);
	        	police2.draw(g2d);
	        }
	        
	        
	        g2d.dispose();
	    }



	public void run() {
		// core of the game
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
	
		
		while(gameThread != null) //as long as thread is alive, the game is looping. -Ali
		{
			
			if(control.startPress == true)
			{
				update();
				repaint();
			}
			

			try {
				
				
				double remainingTime = nextDrawTime - System.nanoTime();
				remainingTime = remainingTime/1000000;
				
				Thread.sleep((long) remainingTime);
				
				
				
				nextDrawTime += drawInterval;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
	}
	
	
}
