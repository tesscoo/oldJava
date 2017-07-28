/**This program uses two methods to return a string. It is a 
 * new string where every non-underscore character of the
 * original string s is separated by underscore characters.
 * The number of consecutive underscore characters separating 
 * any two consecutive characters of string s increases
 * by one each time.
 * 
 * Questions:
 * 1) My first method is about 2,000 times faster than the naive method, while the pre
 * 	allocated method is about 3,200 times faster than the naive method.
 * 
 * 2) The pre-allocated method is about 2 times faster than the method that sets the 
 * 		capacity to 1.
 * 
 * 3) As the string gets longer, the pre-allocated method is faster. When the capacity
 * is not pre-allocated, time is spent allocating more room to the StringBuilder. This
 * is why the pre-allocated method runs faster.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class DynamicStrings {
	public static void main(String[] args){
		
		//Initialize strings that we will pass through these methods (given examples)
		final String s = "abcdeflkwenwelkfjwelnr"; //insertUnderscores(s); -> "a_b__c___d"
		//final String s = "_1__2_3___"; //insertUnderscores(s); -> "1_2__3"
		//final String s = "________"; //insertUnderscores(s); -> ""
		
		//Pass the string through the two methods
		System.out.println(insertUnderscores(s));
		System.out.println(insertUnderscoresPreAllocate(s));
		String underscoredString = TestDynamicStrings.insertUnderscores(s);
	}
	
	/**This method removes any underscores from the string and
	 * adds the necessary underscores in between letters.
	 * It sets the initial capacity of the StringBuilder to 1.
	 * @param s	The string that gets passed into the method.
	 * @return	The string with the correct amount of underscores
	 * between each letter.
	 */
	public static String insertUnderscores(String s){
		//Initialize a new string builder that we can use for the 
		//intermediary process
		StringBuilder withoutUnders = new StringBuilder(1);
		return remainingOperations(withoutUnders, s);	
	}
	
	/**This method removes any underscores from the string and
	 * adds the necessary underscores in between letters.
	 * It sets the initial capacity of the StringBuilder to k*(k+1)/2.
	 * @param s	The string that gets passed into the method.
	 * @return	The string with the correct amount of underscores
	 * between each letter.
	 */
	public static String insertUnderscoresPreAllocate(String s){
		int k = s.length();
		int capacity = k * (k + 1) / 2;
		//Initialize a new string builder that we can use for the 
		//intermediary process
		StringBuilder withoutUnders = new StringBuilder(capacity);
		return remainingOperations(withoutUnders, s);
	}
	
	/**This method takes the initialized StringBuilder with the 
	 * specified capacity and performs the intended operation
	 * of adding underscores at specific spots.
	 * 
	 * @param withoutUnders The StringBuilder without underscores
	 * @param s		The initial string that we're working with
	 * @return		The final outputted string with the correct underscores
	 */
	public static String remainingOperations(StringBuilder withoutUnders, String s){
		//Loop through the StringBuilder to remove any initial underscores
			for (int i = 0; i < s.length(); i++){
				if (s.charAt(i) != '_'){
					//If the character is not an underscore,
					//add it to the intermediary StringBuilder
					withoutUnders.append(s.charAt(i));
				}
			}
					
			//Initialize the StringBuilder that will hold the final output
			StringBuilder withNewUnders = new StringBuilder();
					
			//Loop through the intermediary StringBuilder to get its characters
			for (int i = 0; i < withoutUnders.length(); i++){
				//j will keep track of how many underscores we need to add at a time
				int j = i + 1;
						
				//add the character at index i to the final string
				withNewUnders.append(withoutUnders.charAt(i));
						
				//then add the corresponding underscores
				//this will not add underscores after the last character
				if (i != withoutUnders.length() - 1){
					for (int m = 0; m < j; m++){
						withNewUnders.append('_');
					}
				}
			}		
			return withNewUnders.toString();
	}

}