import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import javax.imageio.ImageIO;

import tile.*;
import main.*;
import org.junit.jupiter.api.Test;

class TestMap {
	GameScreen gs = new GameScreen();
	TileChecker testTile = new TileChecker(gs);
	
	

	
	@Test
	void collisionBoolean() {
		
		
		assertEquals(testTile.tile[8].collision, true); //testing collision for tiles
	}
	
	@Test
	void collisionBoolean2() {
		assertEquals(testTile.tile[2].collision, false); //testing collision for tiles
	}
	
	@Test
	void tilePlacementlvl1() {
		int test = testTile.loadMap(2,2);
		int res = 3;
		
		assertEquals(test, res); //testing for correct tile placement for level 1
	
	}
	
	@Test
	void tilePlacementlvl1_2() {
		int test = testTile.loadMap(8,10);
		int res = 2;
		assertEquals(test, res); //testing for correct tile placement for level 1

	}
	
	@Test
	void tilePlacementlvl2() {
		int test = testTile.loadMap(2,3);
		int res = 12;
		assertEquals(test, res); //testing for correct tile placement for level 2
	
	}
	
	@Test
	void tilePlacementlvl2_2() {
		int test = testTile.loadMap(12,6);
		int res = 5;
		assertEquals(test, res); //testing for correct tile placement for level 2

	}

}
