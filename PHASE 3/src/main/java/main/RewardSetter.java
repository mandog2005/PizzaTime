package main;

import java.util.concurrent.ThreadLocalRandom;

import rewards.*;

/**
 * will handle the rewards on the map.
 * 
 * @author Ali Alden
 *
 */
public class RewardSetter {
	
	GameScreen gs;
	Pizza pizza  = new Pizza();
	Wrench wrench  = new Wrench();

	public RewardSetter(GameScreen gs) {
		this.gs = gs;
		
	}
	
	
	public int randomGenerator()
	{
		int n = ThreadLocalRandom.current().nextInt(0, 15 + 1);
		
		return n;
	}
	
	public void setObject()
	{
		
		
			
		if(pizza.collected == false)
		{
		gs.obj[0] = new Pizza();
		gs.obj[0].x = 8 * gs.tileSize;
		gs.obj[0].y = 16 * gs.tileSize;
		}
		

		gs.obj[4] = new Clock();
		gs.obj[4].x = 5 * gs.tileSize;
		gs.obj[4].y = 12 * gs.tileSize;
		

		gs.obj[5] = new SpeedBump();
		gs.obj[5].x = 13 * gs.tileSize;
		gs.obj[5].y = 14 * gs.tileSize;
		
		gs.obj[6] = new Clock();
		gs.obj[6].x = 18 * gs.tileSize;
		gs.obj[6].y = 16 * gs.tileSize;
		
		

		
		if(pizza.delivered == true)
		{
		gs.obj[1] = new Pizza();
		gs.obj[1].x = 14 * gs.tileSize;
		gs.obj[1].y = 18 * gs.tileSize;
		}
	
		
		gs.obj[2] = new Wrench();
		gs.obj[2].x = 8 * gs.tileSize;
		gs.obj[2].y = 12 * gs.tileSize;
	
		
		if(wrench.collected == true)
		{
			
			gs.obj[3] = new Wrench();
			gs.obj[3].x = 14 * gs.tileSize;
			gs.obj[3].y = 16 * gs.tileSize;
		
		}
		
	
	}
	

		
	
	
	//testcase
	
	public int setObject(int i)
	{
		gs.obj[0] = new Pizza();
		gs.obj[0].x = 7 * gs.tileSize;
		gs.obj[0].y = 15 * gs.tileSize;
	
		gs.obj[1] = new Wrench();
		gs.obj[1].x = 12 * gs.tileSize;
		gs.obj[1].y = 15* gs.tileSize;
		
		return gs.obj[i].x + gs.obj[i].y;
		
	}
	
	
	
	

}
