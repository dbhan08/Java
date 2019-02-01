package changeChar;

import java.util.Scanner;

public class changeChar {
	Scanner scanner = new Scanner(System.in);
	String str;
	public changeChar()
    { 
		str = scanner.nextLine();
        // Create an equivalent char array 
        // of given string 
        char[] ch = str.toCharArray(); 
        for (int i = 0; i < ch.length; i++) { 
  
            // k stores index of first character 
            // and i is going to store index of last  
            // character.  
            int k = i; 
            while (i < ch.length && ch[i] != ' ')  
            
                i++; 
              
            // Swapping 
            char temp = ch[k]; 
            ch[k] = ch[i - 1]; 
            ch[i - 1] = temp; 
            }
            // We assume that there is only one space 
            // between two words. 
        
        String output = new String(ch);
        System.out.println(output);
        
        
    } 
	
	
	
	public static void main(String[] args) {
		new changeChar();
		

	}


}
