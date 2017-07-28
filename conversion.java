/* 
 * Tess Iskra, tli207
 * This program prints two tables, side by side, that show conversions between mi and km
 */

public class conversion {
	
		
		//Initialize constant for miles to calculate & conversion factor
		final static int MILES = 10;
		final static double CONVERT = 1.609;

		//Establish method for the table headers
		public static String tableHeaders (String firstTitle, String secondTitle){
			String fullTitle = firstTitle + " " + secondTitle + " | " + secondTitle + "   " + firstTitle;
			return fullTitle;
			}

		//Establish method for converting miles to kilometers
		public static float miToKm (float mi){
			float kilo = (float)(mi * CONVERT); 
			return kilo;
			}
		
		//Establish method for converting kilometers to miles
		public static float kmToMi (float km){
			float mil = (float)(km / CONVERT);
			return mil;
			}
		
		public static void main(String[] args) {
			//Input arguments to fill in the table headers
			String title = tableHeaders("Miles", "Kilometers");
			System.out.println(title);
		
			//Loop through to calculate conversions for each unit
			for (int mi = 1, km = (5 * mi + 15); mi < (MILES + 1); mi+=1, km+=5){
				int miles = (int)(miToKm(mi) * 10);
				float m = (float)(miles / 10.000);
				int kilometers = (int) (kmToMi(km) * 10);
				float k = (float)(kilometers / 10.000);
				
				//Adjust so that floats display with 3 decimal places
				//I'm not quite sure 
				String newm = String.format("%.3f", m);
				String newk = String.format("%.3f", k);
				System.out.printf(mi + "\t" + newm + "\t | \t" + km + "\t" + newk + "\n");
		}
	}
}
