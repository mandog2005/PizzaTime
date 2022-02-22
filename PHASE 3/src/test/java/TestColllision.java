import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Character.*;
import Character.Character;
import main.*;
import rewards.Pizza;
import rewards.Wrench;
import tile.TileChecker;


public class TestColllision {
	GameScreen gs = new GameScreen();
	Controller control = new Controller();
	CollisionChecker collision = new CollisionChecker(gs);
	Car car = new Car(gs,control);
	RewardSetter rewards = new RewardSetter(gs);
	TileChecker tileChecker = new TileChecker(gs);
	
	@Test
	public void test(){
		
	}
	
	@Test
	public void Collision()
	{
		boolean testFalse = false;
		boolean testTrue = true;
		
		//checking collision status of tiles.
		for(int i=0;i<7;i++)
		{
		assertEquals(tileChecker.loadTileImage(i), testFalse);
		}
		
		//checking collision status of tiles.
		for(int i=7;i<15;i++)
		{
		assertEquals(tileChecker.loadTileImage(i), testTrue);
		}
		
	}
	
	
}
