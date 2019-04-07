package Traffic;
/*
 * The following file is the class for a Semi car
 * By:Deyvik Bhan
 * Date:3/17/19
 */

import java.awt.Color;
import java.awt.Graphics;

public class Semi extends Vehicle {
	
	public Semi(int newx, int newy) {
		super(newx, newy);
		width  = 100;
		height = 40;
		speed = 5;
		// Sets width height and speed
		
	}
	
	
	public void paintMe(Graphics g) {
		g.setColor(Color.blue);
		g.fillRect(x, y, width, height);
		// What the Semi looks like
	}

}
