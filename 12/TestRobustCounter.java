import java.util.Scanner;
/**This program gets user input to create a counter,
 * and increment or overflow it based on the user's 
 * choice. If the user chooses to overflow it, 
 * they can reset it to it's initial value, to zero,
 * or quit the program entirely.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class TestRobustCounter {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the start value for your counter: ");
		
		int startValue = input.nextInt();
		boolean continuing = true;

		while (true){
			try {
				RobustCounter counter = new RobustCounter(startValue);

				while (continuing){
					System.out.print("Press 'i' to increment counter or 'o' to overflow counter.");
					String s = input.next();
					if (s.equals("i")){
						try {
							int current = counter.getCount();
							if (current < 0 || current >= 2147483647){
								continuing = false; //Stop the loop and throw the exception
								throw new CounterOverflowedException();
							}
							else {
								counter.increment();
								System.out.println("The counter's new value is " + counter.getCount());
								continue; //Prompt the user again
							}
						} 
						catch (CounterOverflowedException e) {
							e.printStackTrace();
						}
					}

					if (s.equals("o")){
						try {
							throw new CounterOverflowedException();
						}
						catch (CounterOverflowedException ex){
							//Prompt the user for what to do next
							System.out.println("The counter has overflowed!");
							System.out.println("Press r to reset to the start value, z to reset to zero, or q to quit: ");
							
							//Get the new input
							Scanner nextinput = new Scanner(System.in);
							s = nextinput.nextLine();
							
							if (s.equals("r")){
								counter.resetToStartValue();
							}
							else if (s.equals("z")){
								counter.resetToZero();								
							}
							else if (s.equals("q")){
								input.close();
								System.out.println("Goodbye!");
								System.exit(0);
							}
						}
					}
				}
			}
			//Catch the NegativeStartValueException and quit the program
			catch (NegativeStartValueException ex){
				System.out.println(ex);
				System.out.println("Aborting program.");
				input.close();
				System.exit(0);
			}
		}
	}
}