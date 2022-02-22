package main;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.SplashScreen;

import javax.swing.*;



import Character.Car;
import Character.Police;
import Character.Character;
import rewards.Reward;
import tile.TileChecker;

public class GameScreen extends JPanel implements Runnable{
	
	final static int N = 16;

	//SCREEN SETTINGS OPTION
	final int originalTileSize = N; //NXN grid N = 16
	final int scale = 3; //scaling 16 bit game for modern monitors
	
	public final int tileSize = originalTileSize * scale; //3 (NxN) tile
	public final int maxScreenCol = 24; //24* 48 pixels
	public final int maxScreenRow = 18; //18* 48 pixels
	public final int screenWidth = tileSize * maxScreenCol; //768 pixels x 576 pixels
	public final int screenHeight = tileSize * maxScreenRow; 
	final int FPS = 60; //setting fps to 60
	
	Image titleScreenImage = Toolkit.getDefaultToolkit().getImage("img/titleScreen.jpg");

	Controller control = new Controller();
	Car player1 = new Car(this,control);
	Police police1 = new Police(this, control);
	public TileChecker tileManager = new TileChecker(this);
	public CollisionChecker checker = new CollisionChecker(this);
	public RewardSetter rsetter = new RewardSetter(this);
	public Reward obj[] = new Reward[4]; //we can display up to 10 object at the same time.
	Thread gameThread;
	 
	
	/* game panel constructor*/
	public GameScreen()
	{
		
		
		this.setPreferredSize(new Dimension(screenWidth,screenHeight));
		this.setBackground(Color.white);
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

	public void update()
	{
		player1.update(); //call update method from car
		police1.update(player1);
		//System.out.println("Car X:" + player1.x/48 + "Car Y:" + player1.y/48);
		//System.out.println("Police X:" + police1.x/48 + "Police Y:" + police1.y/48);
		if(player1.x/48 == police1.x/48 && police1.y/48 == player1.y/48)
		{
			//System.out.println("Game has ended");
			gameThread.stop();
		}
		
	}
	
	  @Override //draw player.
	    public void paintComponent(Graphics g) {
	        super.paintComponent(g);

	        Graphics2D g2d = (Graphics2D) g;
	        
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
	        g2d.dispose();
	    }

	    
	   


	public void run() {
		// core of the game
		double drawInterval = 1000000000/FPS;
		double nextDrawTime = System.nanoTime() + drawInterval;
		
		
		while(gameThread != null) //as long as thread is alive, the game is looping. -Ali
		{
			
			update();
			repaint();
			

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
