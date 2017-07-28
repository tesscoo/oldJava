/* 
 * Tess Iskra, tli207
 * This program prints out an eight card hand from a single deck of 52 cards
 */

public class dealhand {
	
	//Initialize method to evaluate random card number/face
	public static String value (int value){
		if (value == 1){
			return "Ace";
		}
		else if (value == 11){
			return "Jack";
		}
		else if (value == 12){
			return "Queen";
		}
		else if (value == 13){
			return "King";
		}
		else {
			return value + "";
		}	
	}
	
	//Initialize method to evaluate random card suit
	public static String suit (int suit){
		if (suit == 1){
			return "Clubs";
		}
		else if (suit == 2){
			return "Diamonds";
		}
		else if (suit == 3){
			return "Hearts";
		}
		else if (suit == 4){
			return "Spades";
		}
		else {
			return null;
		}
	}
	
	//The main program generates 8 random cards
	public static void main(String[] args) {
		
		//Print a title for the user to know what we are listing
		System.out.println("Your cards are:");
		
		//Initialize hand count
		int x = 0;
		
		//Loop eight times (0-7) to generate random cards
		while (x < 8){
			
			//Generate a random value and suit for the card
			int value = (int)((Math.random() * 13) + 1);
			int suit = (int)((Math.random() * 4) + 1);
			
			//Generate a string with this data
			String i = value(value) + " of " + suit(suit);
			
			//Print out cards on their own lines
			System.out.println(i);
			
			//Increment dealt card count
			x++;
		}
	}
}
