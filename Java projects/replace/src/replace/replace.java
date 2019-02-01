package replace;

import java.util.Scanner;

public class replace {
	Scanner scanner = new Scanner(System.in);
	String input;
	String space;
	String index;
	String output;
	
	public replace() {
		space = "";
		index = "";
		input = scanner.nextLine();
		StringBuilder str = new StringBuilder();
		str.append(input);
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == ' ') 
			{	
				
				space += i + ",";
			}
		}
		
			
			String[] array = space.split(",");
			for (int j = 0; j < array.length; j++) {
				int k = Integer.parseInt(array[j]);
				
				
				int l = k+(-1 * j);
				str.deleteCharAt(l);
			
			}
			
		
		for (int i = 0 ; i < str.length(); i++) {
			int j = (i+1) %4;
			if(j == 0) {
				
				str.setCharAt(i, '#');
				
			}
			
		}
		
		String[] stringArray = space.split(",");
		for (int i = 0; i < stringArray.length; i++) {
			 int newInt = Integer.parseInt(stringArray[i]);
			 int n = newInt - (i * -1);
		
			
			 str.insert(newInt , " ");
			
		
		}
		  System.out.println(str);
		
		
	}

	public static void main(String[] args) {
		new replace();

	}

}
