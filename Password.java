/**This program uses Java overload methods to test whether a password is considered secure or not.
 * The default rules for a secure password are that it must have at least 8 characters, 
 * contain nothing by alphanumeric characters,
 * and contain at least two digits. 
 *  
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class Password {
	
	//This main program will be used to run test cases.
	 
	public static void main(String[] args) {
		
		// To grader: Please input your testing password where it says "loveJava"
		// Test cases may include "ab" , "1010ti", "password", "Password", etc.
		
		String password = "loveJava";
		
		//If the password is not secure, this will notify the user.
		if (isSecure(password) == false){
			System.out.println("Your password is not secure!!");
		}
		
		//If the password is secure, this will notify the user.
		else if (isSecure(password) == true){
			System.out.println("Your password is secure.");
		}
	}
	
	/**This method takes one string parameter to identify if the password is secure.
	 * It will run the string through an overload method, using default parameters.
	 * 
	 * @param password		This parameter is the string for the password.
	 * @return				This method returns a boolean value for whether the password is secure or not.
	 */
	
	public static boolean isSecure(String password){
		
		//Pass this through the next method
		//If it passes for security, return true
		//If not, return false
		if (isSecure(password,8))
			return true;
		
		else
			return false;
	}
	
	/**This method takes a string parameter and integer parameter to assess if the password is secure.
	 * It will run the string and integer through an overload method, using default parameters.
	 * 
	 * @param password		This parameter is the string for the password.
	 * @param minLength		This integer identifies the minimum length required for the password string.
	 * @return				This method returns a boolean value for whether the password is secure or not.
	 */
	
	public static boolean isSecure(String password, int minLength){
		
		//Pass this through the next method
		//If it passes for security, return true
		//If not, return false
		if (isSecure(password, minLength, 2))
			return true;
		
		else
			return false;
		
	}
	
	/**This method takes a string parameter and two integer parameters to assess if the password is secure.
	 * The method uses a for loop to count each index of the password string.
	 * If the password attains the minimum number of digits AND is greater than the minimum length, 
	 * the password will be secure.
	 * 
	 * @param password		This parameter is the string for the password.
	 * @param minLength		This integer identifies the minimum length required for the password string.
	 * @param minNumDigits	This integer identifies this minimum number of digits the password has to have.
	 * @return				This method returns a boolean value for whether the password is secure or not.
	 */

	public static boolean isSecure(String password, int minLength, int minNumDigits){
		
		//Initialize the number of digits in the string
		int numDigits = 0;
		
		//Initialize the length of the string
		int length = password.length();
		
		//Loop through the string and count how many digits it has
		for (int i = 0; i < length; i++){
			
			if (Character.isDigit(password.charAt(i))){
				numDigits++;
			}
		}
		
		//If the password meets the minimum requirement for digits and length,
		// return true.
		if ((numDigits >= minNumDigits) && (password.length() >= minLength))
			return true;
		else
			return false;
	}
	
	/**This method takes a string parameter and a boolean to assess if the password is secure.
	 * The method uses default parameters.
	 * A for loop is used to check each index of the password string for upper/lower case letters.
	 * If it has both, AND if it passes the test from our first method, then the password 
	 * will be deemed secure.
	 * 
	 * @param password			This parameter is the string for the password.
	 * @param requireBothCases	This boolean identifies if the password string has upper/lower case letters.
	 * @return					This method returns a boolean value for whether the password is secure or not.
	 */
	
	public static boolean isSecure(String password, boolean requireBothCases){
		
		//Initialize the length of the string
		int length = password.length();
		
		//Initialize booleans for upper and lower case letters in the string
		boolean upperC = false;
		boolean lowerC = false;
		
		//Loop through the password string and identify if there are upper/lower case letters
		for (int i = 0; i < length; i++){
			if (Character.isUpperCase(password.charAt(i))){
				upperC = true;
			}
			if (Character.isLowerCase(password.charAt(i))){
				upperC = true;
			}
		}
		
		//If the string has upper and lower case letters,
		//and passes through our first method, then deem it secure.
		if (upperC && lowerC & isSecure(password))
			return true;
		else
			return false;
	}
	
	/**This method takes a string parameter and two boolean values to assess if the password is secure.
	 * A for loop is used to iterate through each index of the password string in order to check if there exists
	 * special characters or white space.
	 * If there exists a special character with no white space, the password will be deemed secure as long as it passes
	 * our second method test.
	 * 	
	 * @param password				This parameter is the string for the password.
	 * @param requireBothCases		This boolean identifies if the password string has upper/lower case letters.
	 * @param requireSpecial		This boolean identifies if the password string has white space or special characters.
	 * @return						This method returns a boolean value for whether the password is secure or not.
	 */
	
	public static boolean isSecure(String password, boolean requireBothCases, boolean requireSpecial){
		
		//Initialize length of the password string
		int length = password.length();
		
		//Initialize count for special characters/ white space
		int specialChar = 0;
		int whiteSpace = 0;
		
		//Loop through the string and count the number of special characters/white space
		for (int i = 0; i < length; i++){
			if (!(Character.isLetterOrDigit(password.charAt(i)))){
				specialChar++;
			}
			if ((password.charAt(i) == ' ')){
				whiteSpace++;
			}
		}
		
		//If there are special characters with no white space,
		//and if the string passes through our previous method,
		//then deem the password secure.
		if ((specialChar > 0) && (whiteSpace == 0) && isSecure(password, requireBothCases))
			return true;
		else
			return false;
	}

	
	/**	This method takes a string parameter, two integers, and two booleans to assess if the password is secure.
	 * The method will run the test using two separate methods that we previously defined. 
	 * If the password passes both tests, then it will be deemed secure.
	 * 
	 * @param password				This parameter is the string for the password.
	 * @param minLength				This integer identifies the minimum length required for the password string.
	 * @param minNumDigits			This integer identifies this minimum number of digits the password has to have.
	 * @param requireBothCases		This boolean identifies if the password string has upper/lower case letters.
	 * @param requireSpecial		This boolean identifies if the password string has white space or special characters.
	 * @return						This method returns a boolean value for whether the password is secure or not.
	 */
	
	public static boolean isSecure(String password, int minLength, int minNumDigits, boolean requireBothCases, boolean requireSpecial){
		
		//Pass the string through two of our previous methods
		//If the string passes both of these tests,
		//deem the password secure.
		if (isSecure(password, minLength, minNumDigits) && isSecure(password, requireBothCases, requireSpecial))
			return true;
		else
			return false;		
	}

}
