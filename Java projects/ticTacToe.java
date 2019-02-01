/* This code will execute a game of Tic Tac Toe between 2 players
 By: Deyvik Bhan
 Date: 9/29/18
 */

import java.util.Scanner;


public class ticTacToe {
	
	int board[][] = new int[3][3];
	final int BLANK = 0; // Variable for a Blank
	final int X_MOVE = 1; // Variable that  will put an X down
	final int O_MOVE = 2; // Variable that will put an O down
	// Two variables below will alternate the turns
	final int X_TURN = 0;
	final int O_TURN = 1;
	int turn = X_TURN;
	// Variables that will track amount of times X or O has won
	int X_WINS = 0;
	int O_WINS = 0;
	Scanner scanner;
	String input ="";
	// Scanner for user input
	
	public ticTacToe() {
		
		scanner = new Scanner(System.in);
		//Will check if the user is still playing
		boolean stillPlaying = true;
		while(stillPlaying == true) {
		//While loop that runs the game 	
		while (checkWin(X_MOVE) == false && checkWin(O_MOVE) == false && checkTie() == false) {
		printBoard();
		input = scanner.nextLine();
		// Checks if input is valid
		if( input.length() != 2) {
			System.out.println("Enter a letter follwed by a number");
		} else if (input.charAt(0) != 'a' && 
					input.charAt(0) != 'b' && 
					input.charAt(0) != 'c') {
			System.out.println("Row must be an a,b, or a c");
		} else if (input.charAt(1) != '1' && 
				input.charAt(1) != '2' && 
				input.charAt(1) != '3') {
			System.out.println("Column must be an 1, 2, or a 3");
		} else {
			int row = input.charAt(0) - 'a';
			int column = input.charAt(1) - '1';
			// Puts X's and O's
			if(board[row][column] == BLANK) {
				if(turn == X_TURN ) {
					board[row][column] = X_MOVE;
					turn = O_TURN;
					
					
				} else {
					board[row][column] = O_MOVE;
					turn = X_TURN;
					
				}
			} else {
				System.out.println("There is a piece there");
			}
			
		}
		}
			
		// Tells user who won along with how many wins either X has or O has(or a tie)
		if(checkWin(X_MOVE) == true) {
			X_WINS ++;
			System.out.println("X Wins. X has won " + X_WINS + " time(s).");
			
		} else if (checkWin(O_MOVE) == true) {
			O_WINS ++;
			System.out.println("O Wins. O has won " + O_WINS + " time(s).");
		} else if(checkTie() == true) {
			System.out.println("It is a tie");
		}
		System.out.println("Would you like to keep playing?");
		String checkPlaying = scanner.nextLine();
		//Checks if user still playing
		if(checkPlaying.equals("yes") ) {
			System.out.println("Resetting gameboard!");
			
			
			
			stillPlaying = true;
			clearBoard();
			//Resets board
			
			
		} else if(checkPlaying.equals("no")) {
			System.out.println("Thanks for playing!");
			stillPlaying = false;
			//Ends main wile loop
		}
		
		}
	}
	//Runs tic tac toe
	public static void main(String[] args) {
		new ticTacToe();
		
	}
	// Method that prints the board
	public void printBoard() {
		System.out.println("\t1\t2\t3");
		//Columns of board
		
		//Prints the rows of the board
		for (int row = 0; row < board.length; row++) {
			String output = (char)('a' + row) + "\t";
			 for (int column = 0; column < board[0].length; column++) {
				 //Assigns output to the final int variables
				if(board[row][column] == BLANK) {
					output += "\t";
				} else if(board[row][column] == X_MOVE) {
					output += "X\t";
				} else if(board[row][column] == O_MOVE) {
					output += "O\t";
					
				}
			}
			System.out.println(output);
			
			
			
		
		}
		
		
		
	}
	// Method that checks if someone has won
	public boolean checkWin(int player) {
		// Checks all the possible kinds of wins
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[0][0] == player && board[0][1] == player && board[0][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[1][0] == player && board[1][1] == player && board[1][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[2][0] == player && board[2][1] == player && board[2][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			printBoard();
			return true;
		}
		
		if(board[0][2] == player && board[1][1] == player && board[0][2] == player) {
			printBoard();
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
		// Following code makes all the spots on the board a blank
		for (int row = 0; row < board.length; row++) {
			for (int column = 0; column < board[0].length; column++) {
				board[row][column] = BLANK;
				turn = X_TURN;
				// Resets turn back to X
			
			}
		}
	}
	
	
}
