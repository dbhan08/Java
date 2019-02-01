import java.util.Scanner;
public class GuessingGame {	
	public GuessingGame() throws InterruptedException {
		boolean playing = true;
		
		while(playing == true) {
			// Rules of the game
			System.out.println("Welcome to the guessing game. In this game you will be trying to guess a random number chosen between 1 and 50. After each guess you will be notified whether or not your guess was too high or too low and once you finally guess the number you will also know how many guesses it took for you to complete the game.");
			// Random number generator
			int rand = (int) (Math.random() * 51); // Random number generator between 1 and 50
			Thread.sleep(1250); // Makes the game slower(Same for all the other Thread.sleep(s)
			System.out.println("A number has been chosen.");
			Thread.sleep(1250);
			System.out.println("Guess a number between 0 and 50 below");
			Scanner scanner = new Scanner(System.in); 
			int guess = -1;
			int amount = 0; // Variable to record the amount of guesses taken to complete game
			while(guess != rand) {
				String input = scanner.nextLine();	// Stores user input as a variable(string)
				guess = Integer.parseInt(input); // Converts the contents of variable 'input' from string to integer and saves it as variable guess
				System.out.println("You have guessed " + guess);
				Thread.sleep(1500);
				if(guess == rand) {
					//if the guess is equal to the random number
					amount++; // changes the amounts of guess
					System.out.println("You are correct! It took you " + amount + " guesses.");
				} else if(guess > rand) {
					// if the guess is more then the random number
					System.out.println("Your guess is higher then the correct number.");
					Thread.sleep(1250);
					System.out.println("Guess a new number below.");
					amount++;
				} else if(guess < rand) {
					// if the guess is smaller then the random number
					System.out.println("Your guess is lower then the correct number.");
					Thread.sleep(1250);
					System.out.println("Guess a new number below.");
					amount ++;
				}
				
			}
			System.out.println("Would you like to play again?");
			String playAgain = scanner.nextLine();
			if(playAgain.equals("yes") || playAgain.equals("YES")  || playAgain.equals("Yes")) {
				playing = true;
				System.out.println("Staring game over...");
				Thread.sleep(2000);
			} else {
				playing = false;
				System.out.println("Thanks for playing!");
			}
			
		
		}
			
	}
	
	
	public static void main(String[] args) throws InterruptedException {
		new GuessingGame();
		 
	}
}
