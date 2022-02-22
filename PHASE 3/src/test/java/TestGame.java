import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Character.*;
import Character.Character;
import main.*;
import rewards.Pizza;
import rewards.Wrench;

public class TestGame {
	
	GameScreen gs = new GameScreen();
	Controller control = new Controller();
	CollisionChecker collision = new CollisionChecker(gs);
	Car car = new Car(gs,control);
	RewardSetter rewards = new RewardSetter(gs);
	
	@Test
	public void testGame(){
		
	}
	
	//test if rewards are being dropped at right place. -Ali
	@Test
	public void TestSetter()
	{
		int result = rewards.setObject(0);
		int testval = 7*gs.tileSize + 15*gs.tileSize;
		
		assertEquals(testval,result);
		
		
	}
	
	//checks if player is dropped at the right spot.
	@Test
	public void TestPlayerSetter()
	{
		int result = 14*gs.tileSize + 8*gs.tileSize;
		
		assertEquals(car.getDefaultValue(),result);
	}
}
