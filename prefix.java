/* 
 * Tess Iskra, tli207
 * This program identifies the longest common prefix between two strings
 */

//Import the scanner to get user input
import java.util.Scanner;

public class prefix {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		
		//Get the first string
		System.out.println("Enter the first string: ");
		String one = input.nextLine();
		
		//Get the second string
		System.out.println("Enter the second string: ");
		String two = input.nextLine();
		
		//Initialize a string to print if there is no commonality
		String prefix = "These strings do not have a common prefix.";
		
		//Get the minimum length between the two strings
		int min = Math.min(one.length(), two.length());
		
		//Parse every letter of the strings to find their common characters
		for (int i = 0; i < min; i++){
			if (one.charAt(i) != two.charAt(i)){
				//Print a statement if no characters are the same
				if (i == 0){
					System.out.println(prefix);
					break;
				}
				//Print a statement for the common characters
				else{
				System.out.println("The common prefix is '" + one.substring(0, i) + "'.");
				break;
				}
			}	
		}
		//Close the scanner
		input.close();
	}

}
