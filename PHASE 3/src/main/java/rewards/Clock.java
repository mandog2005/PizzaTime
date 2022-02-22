package rewards;

import java.io.IOException;

import javax.imageio.ImageIO;

public class Clock extends Reward {
	
	public Clock() {// This class is for the clock rewards class for the clock image sprite.
		
		name = "clock";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/rewardTextures/Clock.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
