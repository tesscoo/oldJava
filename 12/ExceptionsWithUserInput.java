/**This class handles exceptions with user input.
 * The program generates a random array of 100 floating
 * point values. The user is able to get the value at 
 * an index of their choice.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
import java.util.InputMismatchException;
import java.util.Scanner;
public class ExceptionsWithUserInput {
	//Initialize constants that can be changed by the programmer
	public static final int NUMBER_VALUES = 100;
	public static final int MIN_VALUE = -10;
	public static final int MAX_VALUE = 10;
	
	public static void main(String[] args){
		float[] array = new float[100]; //Initialize array
		
		//Generate a random float for each array index
		for (int i = 0; i < array.length; i++){
			array[i] = (float) ((Math.random() * (MAX_VALUE - MIN_VALUE)) + MIN_VALUE);
		}
		
		//Get user input
		Scanner input = new Scanner(System.in);
		System.out.print("Please enter an index: ");
		
		//I'll use a while loop so that I can include a continue statement
		while(true){
			try{
				int index = input.nextInt();
				System.out.printf("The value at index " + index + " is %.4f\n", array[index]);
				System.out.print("Please enter an index: ");
				continue; //Prompt the user for another index
			}
			catch(ArrayIndexOutOfBoundsException ex){
				System.out.println("ERROR: User supplied index is out of bounds!");
				System.out.print("Please enter an index: ");
				input.nextLine(); //Prompt the user for another index
			}
			catch(InputMismatchException s){
				//Get the user's input and check if it's a q/Q
				String r = input.nextLine();
				if (r.equals("q") || r.equals("Q")){
					System.out.println("Goodbye!");
					input.close(); //Close the scanner
					System.exit(0); //Exit the program
				}
			}
		}
	}
}