package main;

import javax.swing.*;
import java.awt.*;


public class Main extends JFrame{

	
	public void startGame()
	{
		//add(new Model());
		GameScreen screen = new GameScreen();
		InfoScreen info = new InfoScreen();
		Controller c = new Controller();
		
        setTitle("Pizza Time");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(true);
        
        JSplitPane splitPane = new JSplitPane( JSplitPane.HORIZONTAL_SPLIT );
        
        splitPane.setLeftComponent(screen);
        splitPane.setRightComponent(info);
        add(splitPane);
  
        
        pack();
        

     
        screen.setupGame();
        screen.startGameThread();
      
        
        
        this.setResizable(false);
        setVisible(true);
        
	}

	public static void main(String[] args) {
		
		Main newGame = new Main(); //newgame object.
		
		
		newGame.startGame();
		
	}

}
