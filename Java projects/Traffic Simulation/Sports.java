package Traffic;
/*
 * The following file is the class for a Sports car
 * By:Deyvik Bhan
 * Date:3/17/19
 */

import java.awt.Color;
import java.awt.Graphics;

public class Sports extends Vehicle {
	
	public Sports(int newx, int newy) {
		super(newx, newy);
		width  = 40;
		height = 20;
		speed = 12;
		// Sets width height and speed
		
	}
	
	
	public void paintMe(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(x, y, width, height);
		// What the Sports car looks like
	}

}
