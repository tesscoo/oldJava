/*Tess Iskra 
 * tli207
 * 
 * This program assesses how much a user has to pay when they pass through a toll booth, 
 * depending on the type of car, number of passengers, weight, and trailer additions.
 */

import java.util.Scanner;

public class TollOperator {
	public static void main(String[] args) {
		
		//Open scanner to get user input
		Scanner input = new Scanner(System.in);
		double passengers = 0;
		String trailer;
		int weight = 0;
		boolean detain = false;
		double tollFare = 0;
		
		//Normal toll constant
		final double REGULAR_TOLL = 2.25;
		
		//Weight constants
		final double V_WEIGHT_LOWER = 5000;
		final double V_WEIGHT_UPPER = 7000;
		final double P_WEIGHT_LOWER = 7500;
		final double P_WEIGHT_UPPER = 9500;
		final double T_WEIGHT_LOWER = 10000;
		final double T_WEIGHT_UPPER = 12000;
		
		double surchargeNEco = 0;
		double surchargeTrailer = 0;
		double carpoolDiscount = 0;
		double totalFines = 0;
		String warning = "No warnings at this time.";
		double unsafePass = 0;
		double illegalTrailer = 0;
		double overweightFine = 0;
		double extraWeight = 0;
		double maxPass = 0;
		double tooManyPass = 0;
		
		//Get user's input for type of car
		System.out.print("Enter the character that corresponds to your vehicle type: ");
		String letter = (input.next()); 
		String strippedLetter = letter.trim();
		String lowerLetter = strippedLetter.toLowerCase();

		//Go through different cases by vehicle type
		switch (lowerLetter){
		case "m":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextDouble());
			if (passengers == 0){
				System.out.println("0 passengers. ERROR.");
				System.exit(1);
			}
			else if (passengers == 1){
				passengers = 1;
			}
			else if (passengers > 2){
				System.out.println("A motorcycle cannot hold more than two passengers.");
				System.exit(1);
			}
			else {
				System.out.println("This is an invalid number of passengers.");
				System.exit(1);
			}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
				illegalTrailer = 30;
			}
			tollFare = REGULAR_TOLL;
			break;
		case "c":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextDouble());
			if ((passengers % 1) == 0){
				if ((passengers == 4) || (passengers == 5)){
				carpoolDiscount = -1.15;
					}
				else if ((passengers > 5) && (passengers < 20)){
						carpoolDiscount = 0;
						unsafePass = 50;
					}
				else if (passengers == 0){
					System.out.println("In CS101, car drives you!");
					System.exit(0);
					}
				else if (passengers >= 20){
					System.out.println("You may pass.");
					System.exit(0);
					}
				}
			else {
					System.out.println("This is an invalid number of passengers.");
					System.exit(1);
				}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer == "yes"){
				surchargeTrailer = 1.65;
				illegalTrailer = 30;
			}
			tollFare = REGULAR_TOLL;
			maxPass = 5;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			break;
		case "s":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextInt());
			if ((passengers % 1) == 0){
				if (passengers == 0){
					System.out.println("In CS101, car drives you!");
					System.exit(0);
				}
				else if (passengers == 1){
					carpoolDiscount = 0;
					unsafePass = 50;
					}
				}
			else {
				System.out.println("This is an invalid number of passengers.");
				System.exit(1);
			}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
				illegalTrailer = 30;
			}
			tollFare = REGULAR_TOLL;
			surchargeNEco = 0.60;
			maxPass = 2;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			break;
		case "v":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextInt());
			if ((passengers % 1) == 0){
				if ((passengers > 3) && (passengers <= 7)){
					carpoolDiscount = -1.15;
				}
				else if (passengers > 7){
					carpoolDiscount = 0;
					unsafePass = 50;
				}
				else if (passengers == 0){
					System.out.println("In CS101, car drives you!");
					System.exit(0);
				}
			}
			else {
					System.out.println("This is an invalid number of passengers.");
					System.exit(1);
			}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
			}
			System.out.print("What is the vehicle's weight? ");
			weight = (input.nextInt());
			if ((weight > V_WEIGHT_LOWER) && (weight < V_WEIGHT_UPPER)){
				extraWeight = weight - 5000;
				overweightFine = (((extraWeight / 100) + 99) / 100) * 100;
				overweightFine = Math.round(overweightFine / 100);
				overweightFine = overweightFine * 75;
				detain = false;
			}
			else if (weight > V_WEIGHT_UPPER){
				detain = true;
			}
			else if (weight < 0){
				System.out.println("This is an invalid weight.");
				System.exit(1);
			}
			maxPass = 7;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			tollFare = REGULAR_TOLL;
			break;
		case "p":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextInt());
			if ((passengers % 1) == 0){
				if (passengers == 3){
					carpoolDiscount = -1.15;
				}
				else if (passengers > 3){
					carpoolDiscount = 0;
					unsafePass = 50;
				}
				else if (passengers == 0){
					System.out.println("In CS101, car drives you!");
					System.exit(0);
				}
			}
			else {
					System.out.println("This is an invalid number of passengers.");
					System.exit(1);
				}
			
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
			}
			System.out.print("What is the vehicle's weight? ");
			weight = (input.nextInt());
			if ((weight > P_WEIGHT_LOWER) && (weight < P_WEIGHT_UPPER)){
				extraWeight = weight - 7500;
				overweightFine = (((extraWeight / 100) + 99) / 100) * 100;
				detain = false;
			}
			else if (weight > P_WEIGHT_UPPER){
				detain = true;
			}
			else if (weight < 0){
				System.out.println("This is an invalid weight.");
				System.exit(1);
			}
			maxPass = 3;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			tollFare = REGULAR_TOLL;
			surchargeNEco = 0.60;
			break;
		case "t":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextInt());
			if ((passengers % 1) == 0){
				if (passengers == 0){
					System.out.println("0 passengers. ERROR.");
					System.exit(1);
				}
			}
			else {
				System.out.println("This is an invalid number of passengers.");
				System.exit(1);
			}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
				warning = "You will be approaching a steep decline.";
			}
			System.out.print("What is the vehicle's weight? ");
			weight = (input.nextInt());
			if ((weight > T_WEIGHT_LOWER) && (weight < T_WEIGHT_UPPER)){
				extraWeight = weight - 10000;
				overweightFine = (((extraWeight / 100) + 99) / 100) * 100;
				overweightFine = Math.round(overweightFine / 100);
				overweightFine = overweightFine * 75;
				detain = false;
			}
			else if (weight > T_WEIGHT_UPPER){
				detain = true;
			}
			else if (weight < 0){
				System.out.println("This is an invalid weight.");
				System.exit(1);
			}
			maxPass = 2;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			tollFare = 5.10;
			break;
		case "b":
			System.out.print("How many passengers do you have? ");
			passengers = (input.nextInt());
			if ((passengers % 1) == 0){
				if (passengers > 30){
					warning = "Warning: You have more than 30 passengers.";
				}
				else if (passengers == 0){
					System.out.println("0 passengers. ERROR.");
					System.exit(1);
				}
			}
			else {
				System.out.println("This is an invalid number of passengers.");
				System.exit(1);
			}
			System.out.print("Do you have a trailer? ");
			trailer = (input.next());
			if (trailer.equals("yes")){
				surchargeTrailer = 1.65;
				illegalTrailer = 30;
			}
			maxPass = 30;
			if (passengers >= ((1.5 * maxPass) + 1)){
				detain = true;
			}
			tollFare = 4.35;
			break;
		case "e":
			System.out.println("You may pass. Have a good day.");
			System.exit(0);
			break;
		default:
			System.out.println("This is not a valid vehicle type.");
			System.exit(1);
		}
		input.close();
		if (detain == true){
			System.out.println("Your vehicle is going to be detained. Please pull over.");
		}
		else if (detain == false){
			System.out.println("Your toll is $" + tollFare + ".");
			System.out.println(warning);
			totalFines = (surchargeNEco + surchargeTrailer + carpoolDiscount + unsafePass + illegalTrailer + overweightFine + tooManyPass);
			if (totalFines <= 0){
				System.out.println("You have accrued no fines.");
			}
			else if (totalFines > 0){
				System.out.printf("Your extra fines total $" + totalFines + "." );
			}
			else {
				System.out.println("I'm sorry, I could not calculate your fines.");
			}
		}
	}
}
