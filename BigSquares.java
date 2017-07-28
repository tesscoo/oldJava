/**This program is the solution to problem 10.17
 * in the book. The program finds the first ten square 
 * numbers that are greater than Long.MAX_VALUE.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

import java.math.BigInteger;

public class BigSquares {
	
	public static void main(String[] args){
		
		//Initialize x as the value for Long.MAX_VALUE
		long x = Long.MAX_VALUE;
		
		//Initialize m as x's square root, rounded down
		long m = (long)(Math.floor(Math.sqrt(x)));
		
		//Initialize BigInteger y 
		//This is just the value for m as a BigInteger
		BigInteger y = new BigInteger("" + m);
		
		//Tell the user what the value is for Long.MAX_VALUE
		System.out.println("Long.MAX_VALUE = " + x + "\n");
		
		System.out.println("The first ten squares larger than this are: ");
		//Loop from 1 to 11 to get ten values
		for (int i = 1; i < 11; i++){
			//Increment the value of y
			BigInteger add = (y.add(new BigInteger(i + "")));
			
			//Square the incremented value of y
			BigInteger squared = add.multiply(add);
			
			//Return the new value
			System.out.println(squared);
		}
	}
}
