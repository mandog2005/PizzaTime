package rewards;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import main.*;

public class Reward {
	
	public BufferedImage image;
	public String name;
	public boolean collision = false;
	public int x,y;
	
	
	public int solidAreaDefaultX=0,solidAreaDefaultY=0;
	public Rectangle solidPart = new Rectangle(solidAreaDefaultX,solidAreaDefaultY,48,48);
	
	public void draw(Graphics2D g2d, GameScreen gs)
	{
		
		g2d.drawImage(image, x, y, gs.tileSize, gs.tileSize, null);
	}


}
