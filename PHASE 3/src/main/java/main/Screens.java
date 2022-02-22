package main;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Screens {
	
	public BufferedImage img,img2,img3;
	public boolean endGame  = false;

	public Screens() {
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage startScreen()
	{
		 try {
				img2 =  ImageIO.read(getClass().getResourceAsStream("/screens/intro.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return img2;
	}
	
	public BufferedImage endScreen()
	{
		 try {
				img3 =  ImageIO.read(getClass().getResourceAsStream("/screens/end.jpg"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
		return img3;
	}


	
	 public void draw(Graphics g)
	    {
		 if(endGame)
		 {
			 img = this.endScreen();
		 }
		 else
		 {
		 img = this.startScreen();
		 }
	        // Draws the img to the BackgroundPanel.
	        g.drawImage(img, 0, 0, null);
	        
	    }

}
