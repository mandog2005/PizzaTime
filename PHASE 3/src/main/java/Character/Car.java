package Character;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.*;

public class Car extends Character {
	
	GameScreen gs;
	Controller control;
	
	private int carx,cary;
	private int speed,lives;
	int spriteValue = 0;
	int spriteCounter = 0;
	private boolean hasPizza;
	boolean hasWrench;
	static int testx, testy;

	public Car(GameScreen gs, Controller control) //this is the constructor that takes care of its this own methods -AA
	{
		this.gs = gs;
		this.control = control;
		this.setDefaultValues();
		this.loadCarImage();
		
		this.solidPart = new Rectangle(8,8, 16,16); //easier for collision detection -Ali
		this.solidAreaDefaultX = this.solidPart.x;
		this.solidAreaDefaultY = this.solidPart.y;

	}
	
	public void setDefaultValues()  //setting initial value for player where they can be, speed, lives, etc. -AA
	{
		
		x = 14*gs.tileSize;
		y = 8*gs.tileSize;
		this.setHasPizza(false);
		this.setHasWrench(false);;
		testx = x;
		testy = y;
		
		carx = x;
		cary = y;
		
		speed = 3;
		lives = 5;
		direction = 1;
		
	}
	
	//checks where player is and check where they are being dropped
	public int getDefaultValue()  //setting initial value for player where they can be, speed, lives, etc. -AA
	{	
		return testx + testy;
	}
	
	public void isValidDest(boolean collisionOn)
	{
		
	}
	
	public void update() //this gets called in the game loop 60FPS times per second.
	{
		if(control.upPress == true || control.downPress == true || control.leftPress == true || control.rightPress == true )
		{
			
			if(control.upPress == true )
			{
	
				direction = 1; //key here is up = 1
			}
			else if(control.downPress == true)
			{
	
				direction = -1; //key here is down = -1
			}
			else if(control.leftPress == true)
			{
	
				direction = 2; //key is left = 2
			}
			else if(control.rightPress == true)
			{
	
				direction = -2; //key is right = -2
			}
		
			//CHECK MAP COLLISION
			collisionOn = false; //set it to false first
			gs.checker.checkTile(this);
			
			//CHECK REWARDS COLLISION
			int rewardIndex = gs.checker.checkRewards(this, true);
			
			
			if(collisionOn == false)
			{
				switch(direction) 
				{//key here is up = 1
				case 1:y = y - speed; 
				break;
				//key here is down = -1
				case -1: y = y + speed; 
				break;
				 //key is left = 2
				case 2:x = x - speed; 
				break;
				 //key is right = -2
				case -2:x = x + speed; 
				break;
				}
			 
		}
		
		
		
		spriteCounter++; 	
		//spriteValue updates every N frames	
		if(spriteCounter > 60) //in this case 10 frames -AA
		{
			if(spriteValue == 1)
			{
				spriteValue = 2;
			}
			
			else 
			{
				spriteValue = 1;
			}
			
			spriteCounter = 0;
		}
		
	}
}	
	public void draw(Graphics2D g2d)
	{
		Image image = null;
		//directional map 1 is up -1 is down, 2 is up and -2 is down
		
		switch(direction) {
			
			case 1:
				if(spriteValue == 1)
				{
					image = up;
				}
				
				if(spriteValue == 2)
				{
					image = up2;
				}
				
				
				break;
			case -1:
				
				if(spriteValue == 1)
				{
					image = down;
				}
				
				if(spriteValue == 2)
				{
					image = down2;
				}
				
				break;
			case 2:
				if(spriteValue == 1)
				{
					image = left;
				}
				
				if(spriteValue == 2)
				{
					image = left2;
				}
				
				break;
			case -2:
				if(spriteValue == 1)
				{
					image = right;
				}
				
				if(spriteValue == 2)
				{
					image = right2;
				}
				
				break;
		}
				
		g2d.drawImage(image, x, y,gs.tileSize,gs.tileSize,null);
	}
	
	public void loadCarImage() 
	{
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/car/redup.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/car/redup2.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/car/reddown.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/car/reddown2.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/car/redleft.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/car/redleft2.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/car/redright.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/car/redright2.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean getHasPizza() {
		return hasPizza;
	}

	public void setHasPizza(boolean hasPizza) {
		this.hasPizza = hasPizza;
	}
	
	public boolean getWrench() {
		return hasWrench;
	}

	public void setHasWrench(boolean hasWrench) {
		this.hasWrench = hasWrench;
	}
	
	
}
