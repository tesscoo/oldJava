/**This program uses methods to perform different functions of arrays.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class NumericArrayUtils {
	
		public static void main(String[] args) {
			//Insert test cases here
		}
		
		/** This method uses a for each loop to print an array.
		 * If it is empty, it prints [].
		 * If it is null, it prints null.
		 * 
		 * @param array		The array that is passed into the method.
		 */
		
		public static void printArray ( double [] array){
			//Loop through each index in the array and print it out
			//I also added a line break just in case
			for (int i = 0; i < array.length; i++){
				System.out.print(array[i] + "\n");
			}
		}
		
		/** This method uses a for each loop to return the average of an array of integer values.	
		 * The array has at least one element (assumed).
		 * 
		 * @param array		The array that is passed into the method.
		 * @return			Returns the average of the integer-valued array.
		 */
		
		public static double average (int [] array){
			//Initialize a total for the indexes
			double total = 0;
			
			//Iterate up to the last index of the array and add the values
			for (int val : array){
				total = total + val;
			}
			
			//Average the total of the integers in the array
			double average = total / array.length;
			return average;
		}
		
		/** This method finds the index of the element with the largest absolute value.
		 * If there are ties, it returns the smallest index.
		 * The array has at least one element (assumed).
		 * 
		 * @param array 	The array that is passed into the method.
		 * @return			Returns the index of the element w/ largest absolute value.
		 */
		
		public static int indexOfLargestMagnitude (double [] array ){
			//Initialize the max and index of the max
			double max = 0;
			int indexMax = 0;
			
			//Loop through the array indices
			for (int i = 0; i < array.length; i++){
				//If the value is greater than the max, make that value the new max
				if (Math.abs(array[i]) > max){
					max = Math.abs(array[i]);
					indexMax = 1;
				}	
			}
			return indexMax;
		}
		
		/** This method reverses the array in-place.
		 * It modifies whatever array that is inputted. 
		 * 
		 * @param array		The array that is passed into the method.
		 */
		
		public static void reverse ( double [] array ){
			//Loop through the array from the last index
			//Print each index, going backwards
			for (int i = array.length - 1; i > 0; i--){
				System.out.println(array[i]);
			}
		}
		
		/** This method returns a second array that is the reverse of the input array.
		 * The input array is not changed
		 * 
		 * @param array		The array that is passed into the method.
		 * @return			A second array that is the reverse of the input array.
		 */
		
		public static double [] reverseCopy ( double [] array ){
			//Initialize a new array with the same length
			double[] reverseCopy = new double [array.length];
			
			//Loop through the two arrays
			//Assign the last index to the first, etc. in order to reverse the arrays
			for (int i = 0, j = reverseCopy.length - 1; i < array.length; i++, j--){
				reverseCopy[j] = array[i];
			}
			return reverseCopy;
		}
		
		/** This method checks whether the elements in array are in non-decreasing order.
		 * An array is sorted if the elements are increasing.
		 * Repeat values are allowed.
		 * 
		 * @param array		The array that is passed into the method.
		 * @return			A boolean value to identify if the elements are in the wanted order.
		 */
		
		public static boolean isSorted ( double [] array ){
			//Loop through the array
			for (int i = 0; i < array.length - 1; i++){
				//Check if the array is in non-decreasing order
				//If an index is greater than the one following,
				//the array is not sorted.
				if (array[i] > array[i+1]){
					return false;
				}
				else
					return true;
			}
			return true;
		}
		
		/** This method checks if two arrays are equal.
		 * The arrays are equal if they have the same elements in the same order.
		 * @param list1		The first array.
		 * @param list2		The second array.
		 * @return			A boolean that identifies if the two arrays are equal.
		 */

		public static boolean equal (int [] list1 , int [] list2 ){
			//If the arrays are not of the same length, they're obviously not equal
			if (list1.length != list2.length){
				return false;
			}
			
			//Check each index against each other
			for (int x: list1){
				for (int y: list2){
					//If the values of the indices are not equal, return false
					if (x != y)
						return false;
					else
						return true;
				}
			}
			return false;
		}
		
		/**This method makes a new array with the same elements in the same order.
		 * Each element only occurs once.
		 * 
		 * @param array		The array that is passed into the method.
		 * @return			New array with the same elements in the same order.
		 */
		
		public static int [] removeDuplicates (int [] array ){
			//Initialize a new array that is equal to passed array
			int [] newArray = new int[array.length];
			
			//Initialize the current index value
			int current = newArray[0];
			
			//Initialize boolean for identifying a duplicate
			boolean duplicate = false;
			
			//Loop through the array to check the value of each index
			for (int i = 0; i < array.length; i++){
				//If the value of the current index is equal to the old, 
				//identify the duplicate with the boolean.
				if (current == newArray[i] && !duplicate){
					duplicate = true;
					//Not sure how to remove from the array
				}
				
				//If the value of the current index is not equal to the old,
				//keep them the same and keep the duplicate boolean false.
				else if (current != newArray[i]){
					current = newArray[i];
					duplicate = false;
				}
			}
			return newArray;
		}
}
