package charAt;
import java.util.Scanner;

public class newChar {
	Scanner scanner = new Scanner(System.in);
	String input;

	public static void main(String[] args) {
		new newChar();

	}
	
	public newChar() {
		System.out.println("Enter a string");
		input = scanner.nextLine();
		char [] a = input.toCharArray();
		for (int i = 1; i < a.length+1; i++) {
			if(i%4 == 0) {
				a[i-1] = '#';
			}
			
		}
		
		String output = new String(a);
		System.out.println(output);
		
		
	}

}
