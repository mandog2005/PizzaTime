package Character;


import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.*;

public class Character {
	
	public int x,y;
	public int speed,lives;
	public int spriteVal = 1;
	public Rectangle solidPart;
	public int solidAreaDefaultX;
	public int solidAreaDefaultY;
	
	
	public BufferedImage up,down,left,right;
	public BufferedImage up2,down2,left2,right2;
	public int direction; // 1 is up -1 is down       2 is left -2 is right
	public boolean collisionOn = false;
}
