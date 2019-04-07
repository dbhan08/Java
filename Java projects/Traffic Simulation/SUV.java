package Traffic;
/*
 * The following file is the class for a SUV car
 * By:Deyvik Bhan
 * Date:3/17/19
 */

import java.awt.Color;
import java.awt.Graphics;

public class SUV extends Vehicle {
	
	public SUV(int newx, int newy) {
		super(newx, newy);
		width  = 60;
		height = 30;
		speed = 8;
		// Sets width, height, and speed
		
	}
	
	
	public void paintMe(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(x, y, width, height);
		// What the SUV looks like
	}


}
