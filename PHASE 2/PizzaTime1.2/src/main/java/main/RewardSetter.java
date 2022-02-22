package main;

import rewards.*;

/**
 * will handle the rewards on the map.
 * 
 * @author Ali Alden
 *
 */
public class RewardSetter {
	
	GameScreen gs;

	public RewardSetter(GameScreen gs) {
		this.gs = gs;
	}
	
	public void setObject()
	{
		gs.obj[0] = new Pizza();
		gs.obj[0].x = 7 * gs.tileSize;
		gs.obj[0].y = 15 * gs.tileSize;
	
		gs.obj[1] = new Wrench();
		gs.obj[1].x = 12 * gs.tileSize;
		gs.obj[1].y = 15* gs.tileSize;
	}
	
	

}
