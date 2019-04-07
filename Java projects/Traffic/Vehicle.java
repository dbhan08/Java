package Traffic;
import java.awt.Graphics;

/*
 * The following file is the parent class for different kinds of cars
 * By:Deyvik Bhan
 * Date:3/17/19
 */

public class Vehicle {
	int x;
	int y;
	int width = 0;
	int height = 0;
	int speed = 0;
	// class has attributes of x, y, width, height and speed
	
	public Vehicle(int newx, int newy) {
		x = newx;
		y = newy;
		
	}
	
	

		public void paintMe(Graphics g) {
			
			
		}
		
		// Getters and setters for above atrributes
		
		public int getX() {
			return x;
			
		}
		public void setX(int newx) {
			x = newx;
			
		}
		public int getSpeed() {
			return speed;
		}
		
		public int getY() {
			return y;
		}
		
		public int getWidth() {
			return width;
		}
		public void setY(int newY) {
			y = newY;
		}
}
