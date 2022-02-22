package main;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InfoScreen extends JPanel {

	public InfoScreen() {
		  
        setBackground(Color.black);
        this.setPreferredSize(new Dimension(500,200));
        
        
	}
	

public void draw(Graphics2D g2d)
{
	Image intro = new ImageIcon("src/images/introscreen.jpg").getImage();
	
	g2d.drawImage(intro, 0,0, null);
}


}
