/* 
 * Tess Iskra, tli207
 * This program counts positive and negative numbers and computes the average of the numbers
 * NOTE: Having an error somewhere...
 */

//Import the scanner so I can get user input
import java.util.Scanner;

public class Numbers {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		//Get number from the user
		System.out.print("Enter a series of integers, the input ends if it is 0: ");
		int number = input.nextInt();
		
		//Initialize variables
		int sum = 0;
		double average = 0;
		int pos = 0;
		int neg = 0;
		int count = 0;
		
		//Do-while loop to check each number entered
		do {
			if (number > 0){
				pos++; //Increment number of positive integers
				sum += number; //Adjust the sum
			}
			else if (number < 0) {
				neg++; //Increment number of negative integers
				sum -= number; //Adjust the sum
			}
			number = input.nextInt(); //Next number to evaluate will be the next int in the input
			count++; //Increment number of integers
		} while (number != 0); //Do all this if the integer is not equal to 0
		
		
		average = ((double)sum) / count; //Evaluate the average
		
		//Print results to the screen
		System.out.println("There are " + pos + " positive integers.");
		System.out.println("There are " + neg + " negative integers.");
		System.out.println("The total is " + sum);
		System.out.println("The average is " + average);
		
		input.close(); // Close the scanner
		
	}

}
