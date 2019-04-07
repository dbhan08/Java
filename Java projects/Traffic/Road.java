package Traffic;

/*
 * The following file contains the drawing of the road, cars, along with the aspects of the simulation
 * By:Deyvik Bhan
 * Date:3/17/19
 */
import java.awt.Color;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class Road extends JPanel {
	
	final int LANE_HEIGHT = 120;
	final int ROAD_WIDTH = 800;
	ArrayList<Vehicle> cars = new ArrayList<Vehicle>(); // Array list for cars
	int carCount = 0;
	
	
	public Road() {
		super();
	}
	
	// Adds cars to array list of cars
	public void addCar(Vehicle v) {
		cars.add(v);
	}
	
	
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.black); // Draws road
		g.fillRect(0, 0, this.getWidth(), this.getHeight()); 
		g.setColor(Color.WHITE);
		for (int a = LANE_HEIGHT; a < LANE_HEIGHT * 4; a = a + LANE_HEIGHT) {// which lane
			for (int b = 0; b < this.getWidth(); b = b+40) {// which line
				g.fillRect(b, a, 30, 5);
				// Draws lanes
			}
			
		}
		// Draw cars
		for (int a = 0; a < cars.size(); a++) {
			cars.get(a).paintMe(g);
			
		}
		
	}
	public void step() {
		for (int a = 0; a < cars.size(); a++) {
			Vehicle v = cars.get(a);
			if(collision(v.getX() + v.getSpeed(),v.getY(),  v ) == false) {// Theres no collision
				v.setX(v.getX() + v.getSpeed()); // Sets car ahead
				if(v.getX() > ROAD_WIDTH) { 
					// If goes past end of road, sets it back to beginning
					if(collision(0,v.getY(),  v ) == false) {
					v.setX(0);
					carCount++;
					}
				}
			}
			else {// Car ahead
				if(v.getY() > 40 && 
					collision(v.getX(),v.getY()- LANE_HEIGHT,  v ) == false) {
						v.setY(v.getY() - LANE_HEIGHT);
						// Switches lane to the left
					}
				else if(v.getY() < 40 + 3 *LANE_HEIGHT && 
						collision(v.getX(),v.getY()+ LANE_HEIGHT,  v ) == false) {
							v.setY(v.getY() + LANE_HEIGHT);
							// Switches lane to the right
					
				}
			}
		}
	}
	
	
	// Function checks if there will be a collision
	public boolean collision(int x, int y, Vehicle v) {
		
		for (int a = 0; a < cars.size(); a++) {
			Vehicle u = cars.get(a);
			if(y == u.getY()) { //if i'm in the same lane
				if(u.equals(v) == false) {// If i'm not checking myself
					if(x < u.getX()+ u.getWidth() // my left side is to the left of his right
					&& x + v.getWidth() > u.getX()) { // my right side is right of his left side
						return true;
					}
				}
			}
		}
		return false;
	}
	
	public int getCarCount() {
		
		
		return carCount;
	}
	
	public void resetCarCount() {
		carCount = 0;
	}

}
