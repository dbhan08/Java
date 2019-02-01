package letters;

import java.util.Scanner;
import java.io.File;


public class countingLetters {
	public countingLetters() {
	int aCount = 0;
	int bCount = 0;
	int cCount = 0;
	int dCount = 0;
	int eCount = 0;
	int fCount = 0; 
	int gCount = 0;
	int hCount = 0;
	int iCount = 0;
	int jCount = 0;
	int kCount = 0;
	int lCount = 0;
	int mCount = 0;
	int nCount = 0;
	int oCount = 0;
	int pCount = 0;
	int qCount = 0;
	int rCount = 0;
	int sCount = 0;
	int tCount = 0;
	int uCount = 0;
	int vCount = 0;
	int wCount = 0;
	int xCount = 0;
	int yCount = 0;
	int zCount = 0;
	


		Scanner scanner = new Scanner(System.in);
	
		System.out.println("Print the string you want to breakdown");
		String input = scanner.nextLine();
		if(input.length() < 1) {
			System.out.println("Enter a valid option!");
		} else {
			for (int i = 0; i < input.length(); i++) {
				String temp2 = String.valueOf(input.charAt(i));
				String temp = temp2.toLowerCase();
				if(temp.equals("a")) {
					aCount++;
					
				}
				if(temp.equals("b")) {
					bCount++;
				}
				if(temp.equals("c")) {
					cCount++;
				}
				if(temp.equals("d")) {
					dCount++;
				}
				if(temp.equals("e")) {
					eCount++;
				}
				if(temp.equals("f")) {
					fCount++;
				}
				if(temp.equals("g")) {
					gCount++;
					
				}
				if(temp.equals("h")) {
					hCount++;
				}
				
				if(temp.equals("i")) {
					iCount ++;
				}
				
				if(temp.equals("j")) {
					jCount++;
				}
				if(temp.equals("k")) {
					kCount++;
				}
				if(temp.equals("l")) {
					lCount++;
				}
				if(temp.equals("m")) {
					mCount++;
				}
				if(temp.equals("n")) {
					nCount++;
				}
				if(temp.equals("o")) {
					oCount++;
				}
				if(temp.equals("p")) {
					pCount++;
				}
				if(temp.equals("q")) {
					qCount++;
				}
				if(temp.equals("r")) {
					rCount++;
				}
				if(temp.equals("s")) {
					sCount++;
				}
				if(temp.equals("t")) {
					tCount++;
				}
				if(temp.equals("u")) {
					uCount++;
				}
				if(temp.equals("v")) {
					vCount++;
				}
				if(temp.equals("w")) {
					wCount++;
				}
				if(temp.equals("x")) {
					xCount++;
				}
				if(temp.equals("y")) {
					yCount++;
				}
				if(temp.equals("z")) {
					zCount++;
					
				}
						
								
								
			}
			int [] array = {aCount, bCount, cCount, dCount, eCount, fCount, gCount, hCount, iCount , jCount, kCount, lCount, mCount, nCount, oCount, pCount, qCount, rCount, sCount, tCount, uCount, vCount, wCount, xCount, yCount, zCount};
			char [] letters = {'a', 'b' , 'c' , 'd', 'e' , 'f' , 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
			for (int i = 0; i < array.length; i++) {
				if(array[i] > 0) {
					System.out.println(letters[i] + ": " + array[i]);
				}
			}
			}
				
					
									}
				
			
		
	
	

	public static void main(String[] args) {
		new countingLetters();

	}

}


