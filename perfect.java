/* 
 * Tess Iskra, tli207
 * This program identifies all four perfect numbers less than 10,000
 * 
 * Possible helper methods:
 * 	public int calculateDivisors(int number){
 * 		for (int divisor = 1; divisor < number; divisor++){
 * 			if ((number % divisor) == 0){
 * 				System.out.println(divisor);
 * 			}
 * 		}
 * 	}
 * 
 * This method would help because it could list out the divisors of the given number
 * You could then use this to check for "perfectness":
 * 	If the sum of the numbers in this list = the number itself,
 * 	then the number is a perfect number.
 */

public class perfect {
	public static void main(String[] args) {
		
		//Initialize constants for the starting value and its limit
		//These can be changed at the user's convenience
		final int MIN = 1;
		final int MAX = 9999;
		
		//Give a title to the user so they know what we are listing
		System.out.println("The perfect numbers less than 10,000 are:");
		
		//Loop through every number in this range
		for (int i = MIN; i <= MAX; i++){
			
			//Initialize sum of divisors at zero
			int sum = 0;
			
			//Loop through numbers to evaluate which are divisors
			for (int divisor = 1; divisor < i; divisor++){
				if ((i % divisor) == 0){
					sum += divisor;
				}
			}	
			
			//Remove the prime case and print the perfect numbers
			if ((i != 1) && (sum == i)){
				System.out.println((i));
			}
			}
		}
	}
	


