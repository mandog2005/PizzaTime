package rewards;

import java.io.IOException;

import javax.imageio.*;

public class Pizza extends Reward{

	public Pizza() {
		
		name = "pizza";
		try {
			image = ImageIO.read(getClass().getResourceAsStream("/object/Pizza.png"));
			
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		
		collision = true;
	}

}
