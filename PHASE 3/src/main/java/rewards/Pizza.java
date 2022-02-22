package rewards;

import java.io.IOException;

import javax.imageio.*;
// This class is being used for the collection of one of the main purpose which is collecting pizzas
public class Pizza extends Reward{
	public boolean delivered;
	public int delX, delY;
	public Pizza() {
		this.collected =false;
		this.delivered = false;
		name = "pizza";
		//the below function will put the image for the pizza 
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/rewardTextures/Pizza.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		this.delX = 1;
		this.delY = 1;
		collision = true;
	}

	public void update(boolean hasPizza)
	{
		if(hasPizza)// Condition to check if the player has collected pizza
		{
			this.collected = true;
			this.x = this.delX;
			this.y = this.delY;
			try {
				image = ImageIO.read(getClass().getResourceAsStream("/rewardTextures/Sheild.png"));
				
			}catch(IOException e)
			{
				e.printStackTrace();
			}
			
		}
	}
	
	
}
