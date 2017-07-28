/** 
 * This program approximates the user's choice of either e or pi.
 * The program will print the computed approximation as well as the
 * relative error in scientific notation.
 * 
 * For a billion terms:
 * 	My pi approximation agrees to ?? terms
 * 	My e approximation agrees to infinitely many terms
 * 
 * The least number of terms to suffice for accuracy:
 * 	For pi: ?? terms
 * 	For e: ~5 terms
 * 
 * 
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

import java.util.Scanner;

public class Series {
	
	public static void main(String[] args) {
		
		Scanner input = new Scanner(System.in);
		System.out.println("Enter 'e' to approximate E, or 'p' to approximate P. Enter 'q' to quit.");
		String userInput = input.nextLine();
		char approx = userInput.toLowerCase().charAt(0);
		
		if (approx == 'q'){
			System.out.println("You have exited this program.");
			System.exit(0);
		}
		
		System.out.println("How many terms should be used to compute the approximation?");
		int n = input.nextInt();
		
		if (approx == 'e'){
			System.out.println("The series approximation for e is " + computeE(n));
			//System.out.println("The relative error is " + relativeError(computeE(n)));
		}
		else if (approx == 'p'){
			System.out.println("The series approximation for pi is " + computePi(n));	
			//System.out.println("The relative error is " + relativeError(computePi(n)));
		}
		input.close();
	}
	
	
	/**
	 * This method will approximate pi based on the number of terms the user input.
	 * @param terms		The terms parameter describes the number of terms the user wants the value to be approximated to.
	 * @return			After this method is run, the approximation for Pi will be returned.
	 */
	
	public static double computePi(int n){
		double pi = 0;
		
		for (int i=1; i <= n; i++){
			pi = 4.0 * ((1 - (Math.pow(-1, i))/((2.0 * i) + 1)));
		}
		
		float error = (float)(Math.abs((Math.PI) - pi)/(Math.PI));
		System.out.printf("Relative Error = %E \n", error);
		return pi;
	}
	
	/**
	 * This method will approximate e based on the number of terms the user input.
	 * 
	 * @param n		The terms parameter describes the number of terms the user wants the value to be approximated to.
	 * @return		After this method is run, the approximation for e will be returned.
	 */
	
	public static double computeE(int n){
		int factorial = 1;
		double e = 0;
		for (int i=1; i <= n; i++){
			e = (1 + (1.0 / (factorial = factorial * i)));
		}
		float error = (float)(Math.abs(Math.E - e)/(Math.E));
		System.out.printf("Relative Error = %E \n", error);
		return e;
	}
	
//	public static double relativeError(double trueValue, double x){
//		float error = (Math.abs((trueValue - x)/(trueValue)));
//		return error;
//	
//	}
}
