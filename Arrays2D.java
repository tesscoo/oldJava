/** This program tests each method by printing the results to the console.
 * Various examples are tested within the main method, 
 * and without getting input from the user.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 *
 */

public class Arrays2D {
	
	public static void main(String[] args) {
		//Initialize test array one
		double[][] array = {
				{},
				{1,2,3},
				{1,2,3,4},
		};
		
		//Initialize test array two
		double[][] array1 = {
				{1},
				{1,2,3},
				{1,2,3,4},
		};
		
		//Loop through array and use method to get number of columns for each row
		for (int row = 0; row < array.length; row++){
			System.out.println("Row " + row + " has " + getNumberOfColumns(array)[row] + " columns.");
		}

		//Loop through array and use method to find location of smallest element
		System.out.println("The minimum value is located at:");
		for (int row = 0; row < locateMinimum(array1).length; row++){
			System.out.println(locateMinimum(array1)[row]);
		}
	}
	
	/**This method determines the number of columns in a 2D array.
	 * If a row is null, length -1 is returned for that row.
	 * If array is empty, return {-1,-1}.
	 * (That is, if array is null, length 0, or all its rows are null or length 0) 
	 * 
	 * @param array	The 2D array whose columns are counted.
	 * @return	An array that gives the number of columns per row.
	 */
	
	public static int [] getNumberOfColumns(double[][] array){
		//Initialize array with the same length
		int[] columnArray = new int [array.length];
		
		//Loop through the array and count how many columns there are
		for(int row = 0; row < array.length; row++){
			//Return -1 if the length is 0 or null
			if (array.length == 0 || array == null)
				columnArray[row] = -1;
			else
				columnArray[row] = array[row].length;
		}
		return columnArray;
	}
	
	/**This method finds the 2D indices of the minimum element of the array.
	 * If there is a tie for the minimum, the indices for the first one
	 * are returned. If the array is empty, {-1,-1} is returned.
	 * 
	 * @param array	2D array which will be search
	 * @return Array with the location of the minimum element in the array
	 */
	
	public static int [] locateMinimum (double[][] array){
		//Initialize the minimum as the first value in the array
		double minimum = array[0][0];
		
		//Initialize the location as a 2 value array
		//This will serve as the "coordinates" of the minimum
		int location[] = new int [2];
		
		//Loop through the array to find the minimum
		for (int row = 0; row < array.length; row++){
			for (int column = 0; column < array.length; column++){
				if (array[row][column] < minimum){
					minimum = array[row][column];
					location[0] = row;
					location[1] = column;
				}
			}
		}
		return location;
	}

}
