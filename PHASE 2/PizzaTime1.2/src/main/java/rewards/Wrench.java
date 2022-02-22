package rewards;

import java.io.IOException;

import javax.imageio.*;

public class Wrench extends Reward{

	public Wrench() {
		
		name = "pizza";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/Wrench.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
	}

}
