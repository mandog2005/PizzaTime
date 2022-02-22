package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.*;

public class TileChecker   {
	public static int MaxScreenValues = 100; //this helps with the max value of the array for tile placement
	
	int maxScreenCol = MaxScreenValues;
	int maxScreenRow = MaxScreenValues;

	int TILEVALUE = 16; //how many kinds of tiles there are in the game.
	GameScreen gs;
	public Tile[] tile; // we create an array class for collision detection. -AA
	public int mapTileNum[][] = new int[maxScreenCol][maxScreenRow];
	int tileNum = 0;
	
	
	//for testing purposes
	public static int checker;
	
	public TileChecker(GameScreen gs)
	{
		this.gs = gs; //run own method links to gamescreen data.
		
		tile = new Tile[TILEVALUE];
		this.loadTileImage(); //same as car class.
		this.loadMap();
	}
	
	/* KEY
	 * tile[0] = roadSideways
	 * tile[1] = roadUp
	 * tile[2] = roadJunction
	 * tile[3] = roadUpRight
	 * tile[4] = roadUpLeft
	 * tile[5] = roadDownLeft
	 * tile[6] = roadDownRight
	 * tile[7] = wallBottom
	 * tile[8] = wallTop
	 * tile[9] = wallRight
	 * tile[10] = wallLeft
	 * tile[11] = wallCorner
	 * tile[12] = PizzaStore
	 * tile[13] = HouseUp
	 * tile[14] = HouseDown
	 * tile[15] = Tree
	 */
	
	public void loadTileImage() //method will load all texture tiles into tile class. Each index is their reference 
	{
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadSideways.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUp.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadJunction.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUpRight.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUpLeft.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadDownLeft.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadDownRight.png"));
				
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallBottom.png"));
			tile[7].collision = true; // for non road tiles set collision to true (default collision is false)
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallTop.png"));
			tile[8].collision = true;
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallRight.png"));
			tile[9].collision = true;
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallLeft.png"));
			tile[10].collision = true;
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallCorner.png"));
			tile[11].collision = true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/PizzaStore.png"));
			tile[12].collision = true;
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/HouseUp.png"));
			tile[13].collision = true;

			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/HouseDown.png"));
			tile[14].collision = true;
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/Tree.png"));
			tile[15].collision = true;
		}catch(IOException e) {
			e.printStackTrace();
	}
		
		
		
	}
	
	public boolean loadTileImage(int i) //method will load all texture tiles into tile class. Each index is their reference 
	{
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadSideways.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUp.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadJunction.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUpRight.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadUpLeft.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadDownLeft.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/roads/roadDownRight.png"));
				
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallBottom.png"));
			tile[7].collision = true; // for non road tiles set collision to true (default collision is false)
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallTop.png"));
			tile[8].collision = true;
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallRight.png"));
			tile[9].collision = true;
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallLeft.png"));
			tile[10].collision = true;
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/wallCorner.png"));
			tile[11].collision = true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/PizzaStore.png"));
			tile[12].collision = true;
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/HouseUp.png"));
			tile[13].collision = true;

			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/HouseDown.png"));
			tile[14].collision = true;
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/mapTextures/walls/Tree.png"));
			tile[15].collision = true;
		}catch(IOException e) {
			e.printStackTrace();
	}
		
		return tile[i].collision;
		
	}
	
	public void loadMap()
	{
		try {
			
			InputStream in = getClass().getResourceAsStream("/levels/level2.txt"); //gets the specified level file for reading to map the tiles
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			int c = 0;
			int r = 0;
			
			while(c < gs.maxScreenCol && r < gs.maxScreenRow) //within size of screen
			{
				String line = br.readLine(); //read the whole line and store it in string for parsing
				
				
				while(c < gs.maxScreenCol) // less than the x axis
				{
					
					String numb[] = line.split(" "); //read map line every iteration row
					
					int num = Integer.parseInt(numb[c]); //parses the string value to int
					checker = num; //checker for testing
					
					
					mapTileNum[c][r] = num; //set tile from level file onto the mapTileNum array for loading
					c++;
				}
				if(c == gs.maxScreenCol) //reset data
				{
					c =0;
					r++;
				}
			}
			br.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public int loadMap(int col, int row) //test class for checking if tiles have been iputted correctly according to levelx.txt
	{
				
			mapTileNum[col][row] = checker; //returns specified tile from col and row
					
		return mapTileNum[col][row];

	}
	
	
	public void draw(Graphics2D g2d) //N * 48 by tiles
	{
		int col =0;
		int row =0;
		int x =0;
		int y = 0;
		
		while(col < gs.maxScreenCol && row < gs.maxScreenRow)
		{
			
			tileNum = mapTileNum[col][row];
			
			
			g2d.drawImage(tile[tileNum].image, x, y, gs.tileSize, gs.tileSize, null);
			col++; //draw the next tile.
			x += gs.tileSize;
			
			if(col == gs.maxScreenCol) //if reaches max which in this case 16
			{
				col =0; //reset call
				x=0;
				row++;
				y += gs.tileSize;
			}
		}
	}	
}
