/**This program implements  the connect four game as described in the book.
 * It is configurable so that can easily be changed for different board sizes.
 * This program uses three helper functions.
 * At the end of the game, the winner will be printed and the game
 * will end.
 * If the column requested by the player is invalid
 * (either full or not one of 1...MAX_COLUMNS) then
 * the input will be ignored.
 * The game ends when either player has achieved k-in-a-row or the board
 * is full. Keep track of the board with the total number
 * of pieces played.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 *
 */

import java.util.Scanner; 

public class ConnectK {
	
	//Initialize number of rows and columns
	static final int ROWS = 4; 
	static final int COLUMNS = 4; 
	
	//Initialize how many you need in a row to win
	//for the diagonal, row, or column
	static final int TOWINDIAGONAL = Math.min(ROWS, COLUMNS);
	static final int TOWINROW = COLUMNS;
	static final int TOWINCOLUMN = ROWS;
	
	public static void main(String[] args){
		char[][] board = new char[ROWS][COLUMNS];
		char player1 = 'X';
		char player2 = 'O';
		String turn = "Turn: Player 1";
		String turn2 = "Turn: Player 2";
		
		printBoard(board);
		
		Scanner input = new Scanner(System.in);
		
		boolean next = true;
		
		while (next){
			kInARow(board, ROWS, player1);
			System.out.println("Which column? ");
			int col = input.nextInt();
			
			if (col < 1 || col > ROWS)
				continue;
			if (isColumnFull(board, col))
				continue;
			for (int row = ROWS - 1; row >= 0; row--){
				if (board[row][col - 1] == ' '){
					board[row][col - 1] = player1;
					break;
				}
			}
			
			printBoard(board);
			
			//Switch the player
			if (turn == "Turn: Player 1")
				turn = turn2;
			else
				turn = "Turn: Player 1";	
		}
		//Close the scanner
		input.close();
	}
	
	/**This method returns true if there exists k consecutive
	 * entries of char c (horizontally/vertically/diagonally)
	 * in the board.
	 * 
	 * @param board
	 * @param k	Number of entries you need in a row to win
	 * @param c Player character
	 * @return
	 */
	
	public static boolean kInARow(char[][] board, int k, char c){
		//Initialize a boolean for if there is a winner
		boolean win = false;
		
		//Loop through the rows to check if there is a connect-k
		for (int i = 0; i < board.length; i++){
			int count = 0;
			for (int j = 0; j < board[i].length; j++){
				if (board[i][j] == c){
					count += 1;
					if (count == k){
						System.out.println("Winner!");
						win = true;
						return win;
					}
				}
				else
					count = 0;
			}
		}
		
		//Loop through to check if there is connect-k in the column
		for (int i = 0; i < board[i].length - 1; i++){
			int count = 0;
			//Loop through each row
			for (int j = 0; j < board.length; j++){
				if (board[i][j] == c){
					count += 1;
					if (count == k){
						System.out.println("Winner!");
						win = true;
						return win;
						
					}
				}
				else
					count = 0;
			}
		}
		
		//Loop through the diagonals to check if there is a connect-k
		
		return win;
	}
	
	
	/**This method returns true if the column of the board
	 * (index starting from 0) is full. This would mean that
	 * the column can't accept any more pieces.
	 * 
	 * @param board
	 * @param column
	 * @return
	 */
	
	public static boolean isColumnFull(char[][] board, int column){
		//Initialize the board as being full
		boolean full = true;
		
		//Loop through each row
		for (int row = 0; row < board.length; row++){
			//If there is a blank space, deem the board not full
			if (board[row][column - 1] == ' '){
				full = false;
			}
		}
		return full;
	}
	
	
	/**This method prints the board to the console.
	 * The output is shown as it is in the book.
	 * 
	 * @param board
	 */
	
	public static void printBoard(char[][] board){
		//Loop through each row
		for (int i = board.length - 1; i >= 0; i--){
			//Print a delimiter
			System.out.print("|");
			//Loop through each column
			for (int j = 0; j < board[i].length; j++){
				//Print the contents of each entry
				System.out.print(board[i][j] != '\u0000' ? board[i][j] + "|": " |");
			System.out.println();	
			}
		//Print the bottom of the board	
		System.out.println("----------------------");	
		}
	}
	
}
