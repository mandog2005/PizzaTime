package Character;


import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import main.*;
import java.util.*;
import java.util.LinkedList;

import Character.Car;
import Character.Character;
/**
 * Police class, will generate police and do a DFS shortest path on the player.
 * 
 * @author:Joel Tai & Ali Alden
 * 
 * 
 * */
public class Police extends Character 
{
	//takes the gamescreen class.
	GameScreen gs;
	Controller control;
	int spriteValue = 1;
	int spriteCounter = 0;
	
	public Police(GameScreen gs, Controller control)
	{
		this.gs = gs;
		this.control = control;
		this.setDefaultValues();
		this.loadCarImage();
		
		this.solidPart = new Rectangle(8,8, 32,32); //easier for collision detection -Ali
		this.solidAreaDefaultX = this.solidPart.x;
		this.solidAreaDefaultY = this.solidPart.y;
	}
	public Police(GameScreen gs, Controller control, int spawnX, int spawnY)
	{
		this.gs = gs;
		this.control = control;
		
		this.x = spawnX*this.gs.tileSize;
		this.y = spawnY*this.gs.tileSize;
		
		this.loadCarImage();
		
		this.speed = 3;
		this.lives = 5;
		this.direction = -2;
		
		
		this.solidPart = new Rectangle(8,8, 32,32); //easier for collision detection -Ali
		this.solidAreaDefaultX = this.solidPart.x;
		this.solidAreaDefaultY = this.solidPart.y;
	}
	
	public void setDefaultValues()  //setting initial value for player where they can be, speed, lives, etc. -AA
	{
		this.x = 16*this.gs.tileSize;
		this.y = 1*this.gs.tileSize;
		
		this.speed = 3;
		this.lives = 5;
		this.direction = -2;
		
	}
	
	
	public void update(Car player) //this gets called in the game loop 60FPS times per second.
	{
		
		direction = movement();	
		//System.out.println("X:" + this.x/48 + " Y:" + this.y/48);
		//CHECK MAP COLLISION
		collisionOn = false; //set it to false first
		gs.checker.checkTile(this);
		
		if(collisionOn == false)
		{
			switch(direction) 
			{//key here is up = 1
				case 1:
					y = y - speed; 
					break;
				//key here is down = -1
				case -1:
					y = y + speed; 
					break;
				 //key is left = 2
				case 2:
					x = x - speed; 
					break;
				 //key is right = -2
				case -2:
					x = x + speed; 
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
	
	
	
	
	private int randomPos()		//gets random position
	{
		Random rand = new Random();
		int temp = 0;
		while(temp==0)
		{
			temp = rand.nextInt(2+3)-2;
		}
		
		return temp;
	}
	private int validDir()
	{
		Random rand = new Random();
		int[] dir = {this.y+1, this.y-1, this.x+1,this.x-1};
		boolean[] valid= {false,false,false,false};
		
		for(int i=0; i<4; i++)
		{
			if(i>1)
			{
				if(this.gs.tileManager.mapTileNum[this.x/32][dir[i]/32] <7)
				{
					valid[i] = true;
				}
			}
			else
			{
				if(this.gs.tileManager.mapTileNum[dir[i]/32][this.y/32] <7)
				{
					valid[i] = true;
				}
			}
		}
		int temp =rand.nextInt(4);
		while(!valid[temp])
		{
			temp =rand.nextInt(4);
		}
		if(temp == 0)
		{
			return 1;
		}
		else if(temp ==1)
		{
			return -1;
		}
		else if(temp ==2)
		{
			return -2;
		}
		else
		{
			return 2;
		}
		
	}
	
	private int movement()
	{
		int dir = this.direction;
		this.collisionOn = false;
		gs.checker.checkTile(this);
		if(this.collisionOn)
		{
			dir = validDir();
			System.out.println("collsion");
		}
		else
		{
			System.out.println("NO collsion");
		}
		
		
		
		return dir;
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
				
		g2d.drawImage(image, this.x, this.y,gs.tileSize,gs.tileSize,null);
	}
	
	public void loadCarImage() 
	{
		try {
			up = ImageIO.read(getClass().getResourceAsStream("/car/PoliceUpBlue.png"));
			up2 = ImageIO.read(getClass().getResourceAsStream("/car/PoliceUpRed.png"));
			down = ImageIO.read(getClass().getResourceAsStream("/car/PoliceDownBlue.png"));
			down2 = ImageIO.read(getClass().getResourceAsStream("/car/PoliceDownRed.png"));
			left = ImageIO.read(getClass().getResourceAsStream("/car/PoliceLeftBlue.png"));
			left2 = ImageIO.read(getClass().getResourceAsStream("/car/PoliceLeftRed.png"));
			right = ImageIO.read(getClass().getResourceAsStream("/car/PoliceRightBlue.png"));
			right2 = ImageIO.read(getClass().getResourceAsStream("/car/PoliceRightRed.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
}
