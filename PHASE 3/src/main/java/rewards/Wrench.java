package rewards;

import java.io.IOException;

import javax.imageio.*;

public class Wrench extends Reward{// This class is for the wrench
	
	public Wrench() {
		this.collected = false;
		name = "wrench";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/rewardTextures/Wrench.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}
	
	public void update(boolean hasWrench)
	{
		if(hasWrench)// Still not sure might need updations
		{
			//this.collected = true;
			//this.x = 0;
			//this.y = 0;
			
			
		}
	}
	
}
