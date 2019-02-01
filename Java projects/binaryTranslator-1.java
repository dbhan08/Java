import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class binaryTranslator {

	private static final String Null = null;
	public binaryTranslator() {
		System.out.println("Please enter \"file\" to enter a file or \"input\" to enter an input to the console");
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		String num = "";
		if(input.equals("file")) {
			try {
				System.out.println("Enter your file name");
				input = scanner.nextLine();
				Scanner file = new Scanner(new File(input));
				num = file.nextLine();
			} catch (IOException ex) {
				System.out.println("File not found");
				scanner.close();
				System.exit(1);
			}
				
			
		} else if(input.equals("input")) {
			System.out.println("Input a binary or decimal.");
			num = scanner.nextLine();
		} else {
			System.out.println("Please type a valid option");
			
		}
		System.out.println("If you are trying to convert from decimal to binary type\"dtb\".");
		System.out.println("If you are trying to convert from binary to decimal type\"btd\".");
		input = scanner.nextLine();
		int number = 0;
		
		if(input.equals("dtb")) {
			// code for converting decimal to binary
			 number = Integer.parseInt(num);
			 int num2 = number;
			 String ans = "";
			 while(number > 0) {
				
				 if(number % 2 == 1) {
					 ans = "1" + ans;
				 } else {
					 ans = "0" + ans;
					 
				 }
				 
				 number = number/2;
				 
			 }
			 System.out.println(ans);
			 	
		} else if(input.equals("btd")) {
			// code for converting binary to decimal
			int answer = 0;
			int exp = 0;
			for(int a = num.length() -1; a >= 0; a--) {
				
				if(num.charAt(a) == '1') {	
					
					 answer = (int)  (answer + Math.pow(2, exp));
					
					
					
				}
				 exp ++;
				 
				
			}
			System.out.println(num + " in binary" + " is equivalent to " + answer + " in decimal");
		
		} else {
			System.out.println("Enter a valid option");
		}
		
		scanner.close();
	}
	public static void main(String[] args) {
		new binaryTranslator();

	}

}
