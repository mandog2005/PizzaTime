package rewards;

import java.io.IOException;

import javax.imageio.ImageIO;

public class SpeedBump extends Reward {// This class is being used for the speedbump sprite that included in one of the rewards

	public SpeedBump() {
		
		name = "SpeedBump";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/rewardTextures/SpeedBump.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}

	}

}
