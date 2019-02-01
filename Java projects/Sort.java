/*
 * Name: Deyvik Bhan
 * Date: 1/15/19
 * Project Description: The program takes an input file and can sort the numbers into correct order through various methods, and finally print it out to an output file.
 */





import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.Array;
import java.util.Scanner;

public class Sort {
	
	Scanner  consoleInput = new Scanner(System.in);
	String input;
	Scanner fileInput; 
	int [] inputArray;
	long startTime;
	
	public Sort() {
		
		// Set up text for the sort function
		System.out.println("Enter a number for the input number");
		System.out.println("1: input1.text 2: input2.text 3: input3.text 4: input4.text");
		input = consoleInput.nextLine();
		if(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
				&& input.charAt(0) != '3' && input.charAt(0) != '4') {
			// If does not meet conditions re-ask to enter
			System.out.println("Enter 1,2,3 or 4");
			while(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
					&& input.charAt(0) != '3' && input.charAt(0) != '4') {
				input = consoleInput.nextLine();
				// Keep giving scanner until they  meet requirments
			}
			
		}
		// Quits if file is not found
		try {
			fileInput = new Scanner(new File("input" + input.charAt(0) + ".txt"));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
			System.exit(0);
		} 
		String infile = fileInput.nextLine();
		// Gets file input
		String[] inputStringArray = infile.split(",");
		// Splits numbers based on commas and puts it in string array
		inputArray = new int[inputStringArray.length];
		// Makes new int array based on the string arrays length
		for (int i = 0; i < inputStringArray.length; i++) {
			inputArray[i] = Integer.parseInt(inputStringArray[i]);
			// converts string to int and puts it in int array
		}
		System.out.println("Enter a number for the sort you want to use");
		System.out.println("1: Bubble 2: Selection 3: Table 4: Quick");
		input = consoleInput.nextLine();
		// Determines what sort to use
		if(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
				&& input.charAt(0) != '3' && input.charAt(0) != '4') {
			System.out.println("Enter 1,2,3 or 4");
			while(input.length() != 1 && input.charAt(0) != '1' && input.charAt(0) != '2'
					&& input.charAt(0) != '3') {
				input = consoleInput.nextLine();
				// Makes sure requirements are met for the user input
			}
			
		}
		startTime = System.currentTimeMillis();
		// Time starting the programm
		if(input.equals("1")) {
			inputArray = bubbleSort(inputArray);
			
		} 
		if(input.equals("2")) {
			inputArray = selectionSort(inputArray);
		}
		if(input.equals("3")) {
			inputArray = tableSort(inputArray);
		}
		
		if(input.equals("4")) {
			
			 inputArray = quickSort(inputArray, 0, inputArray.length - 1);
		}
		
		// Where the sorting happens based on what the user inputs(above)
		
		
		long totalTime = System.currentTimeMillis() - startTime; // Amount of time it takes to sort
		System.out.println(totalTime);
		try {
			// Try catch in order to write output to output file using print writer
			PrintWriter pw = new PrintWriter(new FileWriter(new File("output.txt")));
			String output = "";
			for (int i = 0; i < inputArray.length; i++) {
				output += inputArray[i] + ",";
			}
			output += "\nTotal time:" + totalTime;
			pw.write(output);
			pw.close();
		
		} catch (IOException ex) {
		
			ex.printStackTrace();
			System.exit(0);
		}
	}
	
	
	
	// bubble sort
	int[] bubbleSort(int[] array) {
		// Goes through array constantly swapping if they are in wrong order and stops when array is in correct order
		for (int j = 0; j < array.length; j++) {			
			for (int i = 0; i < array.length - 1; i++) {
				if (array[i] > array[i+1]) {
					//swap
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					
				}
				
			}
		}
		return array;
	}
	
	
	//tally how often you see each number, print number of times
	
	 	int[] tableSort(int[] array) {
		int[] tally = new int[1001];
		for (int i = 0; i < array.length; i++) {
			tally[array[i]]++;
			
		}
		int count = 0;
		//i keeps track of the actual number
		for (int i = 0; i < tally.length; i++) {
			// j keeps track of how many times we have seen that number
			for (int j = 0; j < tally[i]; j++) {
				array[count] = i;
				count++;
			}
		}
		
		return array;
	}
	
	 	
	 		 /*
	 		  * Quick Sort Code adapted from: https://www.programcreek.com/2012/11/quicksort-array-in-java/
	 		  */
	 
	 	     int[] quickSort(int[] arr, int start, int end){
	 	 
	 	        int partition = partition(arr, start, end);
	 	        // Gets input values for partition function
	 	 
	 	        if(partition-1>start) {
	 	            quickSort(arr, start, partition - 1);
	 	            // Sorts to the left of partiton point
	 	        }
	 	        if(partition+1<end) {
	 	            quickSort(arr, partition + 1, end);
	 	            // Sorts to the right of the partition point
	 	        }
				return arr;
	 	   
	 	    }
	 	 
	 	    public static int partition(int[] arr, int start, int end){
	 	    	
	 	    	// Finds partiotion point and puts it in middle
	 	        int pivot = arr[end];// Puts pivot at end
	 	 
	 	        for(int i=start; i<end; i++){
	 	            if(arr[i]<pivot){
	 	                int temp= arr[start];
	 	                arr[start]=arr[i];
	 	                arr[i]=temp;
	 	                start++;
	 	            }
	 	        }
	 	 
	 	        int temp = arr[start];
	 	        arr[start] = pivot;
	 	        arr[end] = temp;
	 	 // Provides pivot point and returns it
	 	        return start;
	 	    }	


	 	
	 	
	 	
	 	
	  // Selection sort
	int[] selectionSort(int[] array) {
		// Puts smallest number at front
		for (int j = 0; j < array.length; j++) {
			int smallestNumber = array[j];
			int smallestIndex = j;
			for (int i = j; i < array.length; i++) {
				if(array[i] < smallestNumber) {
					smallestNumber = array[i];
					smallestIndex = i;
				}
			}
				int temp = array[smallestIndex];
				array[smallestIndex] = array[j];
				array[j] = temp;
			// Part of code which finds smallest number and puts it at front
		}
		
		return array;
		
	}

	public static void main(String[] args) {
		new Sort();
	}

}
