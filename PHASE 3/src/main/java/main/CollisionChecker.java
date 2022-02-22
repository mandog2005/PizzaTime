package main;

import Character.Car;
import Character.Character;

/**
 * Collision class
 * checks collision between map tiles and stops car class from entering a certain tile.
 * this will also control switch for the TileChecker class.
 * 
 * @see TileChecker
 * @author AA and JT
 *
 */

public class CollisionChecker {

	private GameScreen gs;

	public CollisionChecker(GameScreen gs) {
		// TODO Auto-generated constructor stub
		
		this.gs = gs;
	}
	
	public void checkTile(Character character) //I TRANSFERED JT CODE INTO A SEPERATE FUNCTION -AA
	{
		//i'm just transfering the character solid part here so the code is easier to go back to. -ali
		//we will find col and row number using this coordinate system. 
		int characterLeft = character.x + character.solidPart.x;
		int characterRight = character.x + character.solidPart.x + character.solidPart.width;
		int characterTop = character.y + character.solidPart.y;
		int characterBottom = character.y + character.solidPart.y + character.solidPart.height;
		
		int characterLeftCol = characterLeft/ gs.tileSize;
		int characterRightCol = characterRight/ gs.tileSize;
		int characterTopRow = characterTop/ gs.tileSize;
		int characterBottomRow = characterBottom/ gs.tileSize;
		
		int tileNum1,tileNum2;
		

		
		
		switch(character.direction) //key here is up = 1
		{
		
		case 1:
			characterTopRow = (characterTop - character.speed)/gs.tileSize;
			//THIS CHECK FOR WHERE THE PLAYER IS IN THE MAP AND IS THE SOLIDPART COLLIDING WITH WALL
			//rectangle solidpart should be in character class.
			//this is where player will lose a life -AA
			
		
			tileNum1 = gs.tileManager.mapTileNum[characterLeftCol][characterTopRow];
			tileNum2  = gs.tileManager.mapTileNum[characterRightCol][characterTopRow];
			
				if(gs.tileManager.tile[tileNum1].collision == true || gs.tileManager.tile[tileNum2].collision == true)
				{
					character.collisionOn = true;
				}
				
				
			 break;
		
		case -1: //key here is down = -1
			
			characterBottomRow = (characterBottom + character.speed)/gs.tileSize;
			tileNum1 = gs.tileManager.mapTileNum[characterLeftCol][characterBottomRow];
			tileNum2  = gs.tileManager.mapTileNum[characterRightCol][characterBottomRow];
			
			if(gs.tileManager.tile[tileNum1].collision == true || gs.tileManager.tile[tileNum2].collision == true)
			{
				character.collisionOn = true;
			}
			break;
		
		case 2: //key is left = 2
			characterLeftCol = (characterLeft - character.speed)/gs.tileSize;
			tileNum1 = gs.tileManager.mapTileNum[characterLeftCol][characterTopRow];
			tileNum2  = gs.tileManager.mapTileNum[characterLeftCol][characterBottomRow];
			
			if(gs.tileManager.tile[tileNum1].collision == true || gs.tileManager.tile[tileNum2].collision == true)
			{
				character.collisionOn = true;
			}
			break;
			
		
		case -2: //key is right = -2
			characterRightCol = (characterRight + character.speed)/gs.tileSize;
			tileNum1 = gs.tileManager.mapTileNum[characterRightCol][characterTopRow];
			tileNum2  = gs.tileManager.mapTileNum[characterRightCol][characterBottomRow];
			
			if(gs.tileManager.tile[tileNum1].collision == true || gs.tileManager.tile[tileNum2].collision == true)
			{
				character.collisionOn = true;
			}
			break;
			
			
		}
		
	}
	
	public int checkRewards(Character character, boolean car)
	{
		int index = 999;
		
		for(int i=0;i < gs.obj.length;i++)
		{
			if(gs.obj[i] != null)
			{
				//character.solidPart.y = character.solidPart.y;

				
				switch(character.direction)
				{
				case 1: //key here is up = 1
					//character.solidPart.y -= character.speed;
			//BUG HERE MF.
					
						if(character.x/48 == gs.obj[i].x/48 && character.y/48 == gs.obj[i].y/48);
						{
							//System.out.println("up collision");
							
						}
						break;
				
				case -1: //key here is down = -1
					character.solidPart.y += character.speed;
					
					if(character.solidPart.intersects(gs.obj[i].solidPart));
					{
						//System.out.println("down collision");
					}
					break;
				
				case 2: //key is left = 2
					character.solidPart.x =  - character.speed;
					break;
					
				
				case -2: //key is right = -2
					character.solidPart.x = character.solidPart.x + character.speed;
					break;
				}
				character.solidPart.y = character.solidPart.y; 
				
			}
			
			
			
		}
		
		
			
		return index;
	}


}
