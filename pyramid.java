/* 
 * Tess Iskra, tli207
 * This program prints a pyramid  using powers of two
 * (This program is incomplete. I'm out of town for work.) 
 */

import java.util.Scanner;

public class pyramid {
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Pyramid Printer -- Choose one of the following: \n - right side (u)p pyramid \n - upside (d)own pyramid \n - (q)uit");
		
		
		String choice = input.nextLine();
		String strippedChoice = choice.trim();
		String userChoice = strippedChoice.toUpperCase();
		
		if (userChoice.equals("U")){
			System.out.println("Please enter the height of the pyramid:");
			int height = input.nextInt();
			if (height <= 0){
				System.out.println("Error: only positive integers may be entered for the height of the pyramid! Please reenter the height:");
				height = input.nextInt();
			}
		}
		else if (userChoice.equals("D")){
			System.out.println("Please enter the height of the pyramid:");
			int height = input.nextInt();
			if (height <= 0){
				System.out.println("Error: only positive integers may be entered for the height of the pyramid! Please reenter the height:");
				height = input.nextInt();
			}
		}
		else if (userChoice.equals("Q")){
			System.out.println("Goodbye.");
			System.exit(0);
		}
		else {
			System.out.println("Please enter a valid input");
			main(args);
		}

		
	}

}
