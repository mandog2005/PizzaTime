package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	
	public boolean upPress, downPress, leftPress, rightPress, titleScreen = true;

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_S)
		{
			
		}
		
		   if (key == KeyEvent.VK_UP) {
			   upPress = true;
			   titleScreen = false;
        } else if (key == KeyEvent.VK_DOWN) {
     	   downPress = true;
     	  titleScreen = false;
        } else if (key == KeyEvent.VK_LEFT) {
     	   leftPress = true;
     	  titleScreen = false;
        } else if (key == KeyEvent.VK_RIGHT) {
     	   rightPress = true;
     	  titleScreen = false;
        }
		
	}

	public void keyReleased(KeyEvent e) {
		int key = e.getKeyCode();
		
		   if (key == KeyEvent.VK_UP) {
			   upPress = false;
        } else if (key == KeyEvent.VK_DOWN) {
     	   downPress = false;
        } else if (key == KeyEvent.VK_LEFT) {
     	   leftPress = false;
        } else if (key == KeyEvent.VK_RIGHT) {
     	   rightPress = false;
        }
	}

}
