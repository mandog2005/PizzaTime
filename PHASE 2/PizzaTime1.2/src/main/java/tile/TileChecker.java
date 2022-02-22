package tile;

import java.awt.Graphics2D;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.imageio.ImageIO;

import main.*;

public class TileChecker   {
	
	int maxScreenCol = 100;
	int maxScreenRow = 100;

	int TILEVALUE = 20; //how many kinds of tiles there are in the game.
	GameScreen gs;
	public Tile[] tile; // we create an array class for collision detection. -AA
	public int mapTileNum[][] = new int[maxScreenCol][maxScreenRow];
	int tileNum = 0;
	
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
	
	public void loadTileImage() 
	{
		try {
			tile[0] = new Tile();
			tile[0].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadSideways.png"));
			
			tile[1] = new Tile();
			tile[1].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadUp.png"));
			
			tile[2] = new Tile();
			tile[2].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadJunction.png"));
			
			tile[3] = new Tile();
			tile[3].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadUpRight.png"));
			
			tile[4] = new Tile();
			tile[4].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadUpLeft.png"));
			
			tile[5] = new Tile();
			tile[5].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadDownLeft.png"));
			
			tile[6] = new Tile();
			tile[6].image = ImageIO.read(getClass().getResourceAsStream("/map/roads/roadDownRight.png"));
				
			tile[7] = new Tile();
			tile[7].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/wallBottom.png"));
			tile[7].collision = true;
			
			tile[8] = new Tile();
			tile[8].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/wallTop.png"));
			tile[8].collision = true;
			
			tile[9] = new Tile();
			tile[9].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/wallRight.png"));
			tile[9].collision = true;
			
			tile[10] = new Tile();
			tile[10].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/wallLeft.png"));
			tile[10].collision = true;
			
			tile[11] = new Tile();
			tile[11].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/wallCorner.png"));
			tile[11].collision = true;
			
			tile[12] = new Tile();
			tile[12].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/PizzaStore.png"));
			tile[12].collision = true;
			
			tile[13] = new Tile();
			tile[13].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/HouseUp.png"));
			tile[13].collision = true;

			tile[14] = new Tile();
			tile[14].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/HouseDown.png"));
			tile[14].collision = true;
			
			tile[15] = new Tile();
			tile[15].image = ImageIO.read(getClass().getResourceAsStream("/map/walls/Tree.png"));
			tile[15].collision = true;
		}catch(IOException e) {
			e.printStackTrace();
	}
		
	}
	
	public void loadMap()
	{
		try {
			
			InputStream in = getClass().getResourceAsStream("/levels/level2.txt");
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			
			int c = 0;
			int r = 0;
			
			while(c < gs.maxScreenCol && r < gs.maxScreenRow)
			{
				String line = br.readLine();
				
				
				while(c < gs.maxScreenCol)
				{
					
					String numb[] = line.split(" "); //read map line every iteration row
					
					int num = Integer.parseInt(numb[c]); //parses the string value to int
					
					
					mapTileNum[c][r] = num;
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
