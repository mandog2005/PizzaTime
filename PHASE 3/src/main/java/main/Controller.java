package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Controller implements KeyListener {
	
	public boolean upPress, downPress, leftPress, rightPress, startPress;

	public void keyTyped(KeyEvent e) {
	}

	public void keyPressed(KeyEvent e) {
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_S)
		{
			startPress = true;
		}
		
		   if (key == KeyEvent.VK_UP) {
			   upPress = true;
	
        } else if (key == KeyEvent.VK_DOWN) {
     	   downPress = true;

        } else if (key == KeyEvent.VK_LEFT) {
     	   leftPress = true;

        } else if (key == KeyEvent.VK_RIGHT) {
     	   rightPress = true;

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
