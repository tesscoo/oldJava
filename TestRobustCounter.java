import java.util.Scanner;


public class TestRobustCounter {
	public static void main(String[] args){

		Scanner input = new Scanner(System.in);
		System.out.print("Enter the start value for your counter: ");

		while (true){
			try {
				int startValue = input.nextInt();
				RobustCounter counter = new RobustCounter(startValue);

				System.out.print("Press 'i' to increment counter or 'o' to overflow counter.");
				String s = input.nextLine();

				if (s.equals("i")){
					try {
						counter.increment();
						continue;
					} catch (CounterOverflowedException e) {
						e.printStackTrace();
					}
					System.out.println("The counter's new value is " + counter.getCount());
				}
				
				else if (s.equals("o")){
					try {
						throw new CounterOverflowedException();
					}
					catch (CounterOverflowedException ex){
						System.out.println("ERROR: Overflow.\nDo you want to: ");
						System.out.println("Reset counter to start value, press 'r'");
						System.out.println("Reset counter to zero, press 'z'");
						System.out.println("Quit, press 'q'");
						if (s.equals("r")){
							counter.resetToStartValue();
							continue;
						}
						else if (s.equals("z")){
							counter.resetToZero();
							continue;
						}
						else if (s.equals("q")){
							input.close();
							System.out.println("Goodbye!");
							input.close();
							System.exit(0);
						}
					}
				}
				
				else {
					System.out.println("Please enter a valid letter.");
				}
			}

			catch (NegativeStartValueException ex){
				System.out.println(ex);
				System.out.println("Aborting program.");
				input.close();
				System.exit(0);
			}
		}
	}
}
