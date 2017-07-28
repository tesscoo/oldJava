import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.StringTokenizer;

/**This program reads the user's file from the command line,
 * and counts the number of lines, whitespaces, and words in
 * the file. If the file is not found, a FileNotFoundException
 * will be thrown.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class FileStats {
	public static void main(String[] args){
		File file = new File(args[0]); //Get the user's file
		
		int lineCount = 0; 
		int whiteCount = 0;
		int wordCount = 0;		
		
		Scanner input = null;
		
		try {
			input = new Scanner(new FileInputStream(file));
			
			while(input.hasNextLine())  {
		        lineCount++; //Increment the line count if there exists another line
		        String line = input.nextLine();
		        wordCount += new StringTokenizer(line, " ").countTokens(); //Count the number of words separated by a space
		        for (int i = 0; i < line.length(); i++){
		        	if (line.charAt(i) == ' '){
		        		whiteCount++; //Check all characters for whitespace
		        	}
		        }
		    }
		} 
		catch (FileNotFoundException e) {
			System.out.println("ERROR: " + file + " cannot be found!"); //Display an error if the file isn't found
			input.close();
			System.exit(0);
		}
		
		//Display the results
		System.out.println(file + " has the following statistics:");
		System.out.printf("Number of whitespaces: %7d%n" , whiteCount);
		System.out.printf("Number of words: %13d%n" , wordCount);
		System.out.printf("Number of lines: %13d%n" , lineCount);
		input.close();
	}
}