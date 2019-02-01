 /* This is a game of tic tac toe between two players on a graphical interface.
  	By: Deyvik Bhan
  	10/01/18
  */




import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.concurrent.TimeUnit;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
// Imports swing along with awt components for use in programm



public class guiTicTacToe implements ActionListener {
	
	//Creates JFrame
	JFrame frame = new JFrame();
	JButton[][] button = new JButton[3][3];
	// Creates 3 by 3 Jbutton
	int[][] board = new int[3][3];
	//Integer Board
	final int BLANK = 0;
	final int X_MOVE = 1;
	final int O_MOVE = 2;
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN;
	// Variables that put down an O and X also determines which turn it is
	Container center = new Container();
	JLabel xLabel = new JLabel("X wins:0");
	JLabel oLabel = new JLabel("O wins: 0");
	// Adds Label at the top that includes name and how many wins that person has
	JButton xChangeName = new JButton("Change X's name.");
	JButton oChangeName = new JButton("Change O's name.");
	JTextField xChangeField = new JTextField();
	JTextField oChangeField = new JTextField();
	// Textfield where a player may change their name
	Container north = new Container();
	String xPlayerName = "X";
	String oPlayerName = "O";
	// Starting names of players
	int xwins = 0;
	int owins = 0;
	//Keeps track of how many wins each player has
	public guiTicTacToe() {
		frame.setSize(400,400);
		// Sets size of inteface
		//Center grid container
		frame.setLayout(new BorderLayout());
		// Sets layout of interface
		center.setLayout(new GridLayout(3,3));
		// In center sets layout as a 3 by 3 grid
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button.length; j++) {
				button[j][i] = new JButton(j + "," + i);
				center.add(button[j][i]);
				// adds button to each part of the 3 by 3 grid
				button[j][i].addActionListener(this);
				// adds actionlistener
				
			}
		}
		frame.add(center, BorderLayout.CENTER);
		// Adds 3 by 3 button grid to the center of the interface
		//North Container
		north.setLayout(new GridLayout(3,2));
		north.add(xLabel);
		north.add(oLabel);
		north.add(xChangeName);
		xChangeName.addActionListener(this);
		north.add(oChangeName);
		oChangeName.addActionListener(this);
		north.add(xChangeField);
		north.add(oChangeField);
		
		
		frame.add(north, BorderLayout.NORTH);
		// Adds Labels and the textfield that can change name of users
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true); // Allows you to see the interface
	}

	public static void main(String[] args) {
		new guiTicTacToe();

	}

	@Override
	public void actionPerformed(ActionEvent event) {
		JButton current;
		boolean gridButton = false;
		for (int i = 0; i < button.length; i++) {
			for (int j = 0; j < button[0].length; j++) {
				// These two loops go through all the grid
				if(board[j][i] == BLANK) {
					// If there is a blank in that spot
					if(event.getSource().equals(button[j][i])) {
						gridButton = true;
						// It is part of the 3 by  3 gird
						current = button[j][i];
						if(turn == X_TURN) {
							current.setText("X");
							// Puts X
							current.setEnabled(false);
							// Darkens out the button
							board[j][i] = X_MOVE;
							// Adds X
							turn = O_TURN;
							// Changes turn
						} else {
							current.setText("O");
							// Puts O
							current.setEnabled(false);
							// Darkens out the button clicked
							board[j][i] = O_MOVE;
							turn = X_TURN;
							// Changes turn
							
						}
						//Check for wins and ties
						if(checkWin(X_MOVE) == true) {
							
							xwins ++;
							// Increases amount of x wins by 1
							xLabel.setText(xPlayerName + " wins: " + xwins);
							// Changes label to player name and wins

							clearBoard();
							// Clears board
							
						} else if(checkWin(O_MOVE) == true) {
							
							owins ++;
							// Increases amount of O wins
							oLabel.setText(oPlayerName + " wins: " + owins);
							// Changes label to represent new info
							
							

							clearBoard();
							// Clears board
							
						} else if(checkTie() == true) {
							
							

							clearBoard();
							
							
						}
						
						
					}
				}
				
			}
		}
		if(gridButton == false) {
if(xChangeField.getText().equals("") || oChangeField.getText().equals("")) {
				
			} else {
			// IF the button clicked is not part of the grid
			if(event.getSource().equals(xChangeName) == true) {
				xPlayerName = xChangeField.getText();
				// Changes player name
				xLabel.setText(xPlayerName + " wins: " + xwins);
				// Prints it out on interface
				
			} else if(event.getSource().equals(oChangeName) == true) {
				oPlayerName = oChangeField.getText();
				// Changes players name
				oLabel.setText(oPlayerName + " wins: " + owins);
				// Prints new name on interface
		}
	}
		}
	}
	public boolean checkWin(int player) {
		// Checks all the possible kinds of wins
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			
			return true;
		}
		
		if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			
			return true;
		}
		
		if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			
			return true;
		}
		
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			
			return true;
		}
		
		if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			
			return true;
		}
		
		if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			
			return true;
		}
		
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			
			return true;
		}
		
		if(board[0][2] == player && board[1][1] == player && board[0][2] == player) {
			
			return true;
		}
		return false;
	}
	
	public boolean checkTie() {
		//Checks if all the possible spots are taken then  declares it a tie
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				if(board[row][column] == BLANK) {
					return false;
				}
			}
		}
		return true;
		
	}

	public void clearBoard() {
		for (int a = 0; a < board.length; a++) {
			for (int b = 0; b < board[0].length; b++) {
				
				board[a][b] = BLANK;
				
				button[a][b].setText("");
				button[a][b].setEnabled(true);
				
			}
			
		}
		turn = X_TURN;
	}
	
}
