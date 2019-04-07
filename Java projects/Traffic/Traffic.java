package Traffic;


/*
 * The following program is a traffic simulation where you can start the simulation,
 *stop it, add different kinds of car, and it displays throughput.
 * By:Deyvik Bhan
 * Date:3/17/19
 * 
 */
import java.awt.BorderLayout;


import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Traffic implements ActionListener, Runnable{
	
	JFrame frame = new JFrame("Traffic Simulation");
	Road road = new  Road();
	// South container
	// In south container we have two JButtons and one Jlabel
	Container south = new Container();
	JButton start = new JButton("Start");
	JButton stop = new JButton("Stop");
	JLabel throughput = new JLabel("Throughput:0");
	// West container
	// In west container we have 3 JButtons
	JButton semi = new JButton("Add Semi");
	JButton suv = new JButton("Add SUV");
	JButton sports = new JButton("Add Sports");
	Container west = new Container();
	
	boolean running = false;
	int carCount = 0;
	long startTime = 0;
	
	
	
	public Traffic() {
		// Following is set up of frame
		frame.setSize(1000, 550);
		frame.setLayout(new BorderLayout());
		frame.add(road, BorderLayout.CENTER);
		
		south.setLayout(new GridLayout(1,3));
		south.add(start);
		start.addActionListener(this);
		south.add(stop);
		stop.addActionListener(this);
		south.add(throughput);
		frame.add(south, BorderLayout.SOUTH);
		
		west.setLayout(new GridLayout(3,1));
		west.add(semi);
		semi.addActionListener(this);
		west.add(suv);
		suv.addActionListener(this);
		west.add(sports);
		sports.addActionListener(this);
		frame.add(west, BorderLayout.WEST);
		// Adds buttons and labels and adds actions listeners to button
		
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.repaint();
	}
	public static void main(String[] args) {
		new Traffic();
	}
	@Override
	public void actionPerformed(ActionEvent event) {
		if(event.getSource().equals(start)) {
			if(running == false) {
				running = true;
				road.resetCarCount();
				startTime = System.currentTimeMillis();
				Thread t = new Thread(this);
				t.start();
			}
			// When the start button is pressed
			
		}
		if(event.getSource().equals(stop)) {
			running = false;
			// Stops simulation when stop button pressed
		}
		if(event.getSource().equals(semi)) {
			//When semi button pressed
			Semi semi = new Semi(0,30);
			// Creates Semi
			road.addCar(semi);
			for (int x = 0; x < road.ROAD_WIDTH; x+=20) {
				for (int y = 40; y < 480; y+=120) {
					semi.setX(x);
					semi.setY(y);
					if(road.collision(x, y, semi) == false) {
						// If there is no collision
						frame.repaint();
						return;
					}
				}
			}
		}
		
		if(event.getSource().equals(suv)) {
			// If suv button is clicked
			SUV suv = new SUV(0,30);
			// New Suv created
			road.addCar(suv);
			for (int x = 0; x < road.ROAD_WIDTH; x+=20) {
				for (int y = 40; y < 480; y+=120) {
					suv.setX(x);
					suv.setY(y);
					if(road.collision(x, y, suv) == false) {
						frame.repaint();
						// If no collision
						return;
					}
				}
			}
		}
		
		if(event.getSource().equals(sports)) {
			// If sports car button pressed
			Sports sports = new Sports(0,30);
			// New sports car
			road.addCar(sports);
			for (int x = 0; x < road.ROAD_WIDTH; x+=20) {
				for (int y = 40; y < 480; y+=120) {
					sports.setX(x);
					sports.setY(y);
					if(road.collision(x, y, sports) == false) {
						// If there is no collision
						frame.repaint();
						return;
					}
				}
			}
		}
		
	}
	@Override
	public void run() {
		while(running == true) {
			road.step();
			carCount = road.getCarCount();
			double throughputCalc = carCount/(1000 *(double)(System.currentTimeMillis()-startTime));
			// Calculates throughput
			throughput.setText("Throughput:" + throughputCalc); // Sets throughput label
			frame.repaint();
			try {
				Thread.sleep(100);
				// Delays a little bit
				
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
	}
	
	

}
