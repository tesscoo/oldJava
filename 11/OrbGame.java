import java.util.Random;
import orbkit.CollidableOrb;
import orbkit.OrbBase;
import orbkit.OrbGameBase;
import orbkit.Utils;

/**This is the foundation program that runs the orb game. 
 * The essence of this code was written by Tim Mitchell.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class OrbGame extends OrbGameBase {

	/**This method translates a character code to one of the 
	 * created orb types.  Else it returns null.
	 * If the user presses ESC, the window will close.
	 * 
	 * @param c		Character code
	 * @return		Orb type class
	 */
	protected Class getOrbType(char c){
		if (c == '1' || c == '2')
			return SimpleOrb.class;
		//The following are the rest of the cases for my five orb types
		else if (c == '3')
			return ExplosiveOrb.class;
		else if (c == '4')
			return ExplodedOrb.class;
		else if (c == '5')
			return EvadingOrb.class;
		else if (c == '6')
			return StationaryTeleporterOrb.class;
		else if (c == '7')
			return MovingTeleporterOrb.class;
		else if (c == 'R' || c == 'r'){
			return getRandomOrbType();
		}
		else if (c == ESC){
			System.exit(0);
			return null;
		}
		else 
			return null;
	}
	
	/**This function returns the class of a random orb.
	 * This is implemented by generating a random number between 1 and 7
	 * and selecting the orb based on that number.
	 * 
	 * @return	Class of random orb type
	 */
	protected Class getRandomOrbType(){ 
		Random r = new Random();
		int R = r.nextInt(6) + 1; //Generates a random number between 1 and 7
		if (R == 1 || R == 2)
			return SimpleOrb.class;
		else if (R == 3)
			return ExplosiveOrb.class;
		else if (R == 4)
			return ExplodedOrb.class;
		else if (R == 5)
			return EvadingOrb.class;
		else if (R == 6)
			return StationaryTeleporterOrb.class;
		else if (R == 7)
			return MovingTeleporterOrb.class;
		return Object.class;
	}
	
	/**This function initializes an orb based on what its type is.
	 * Each orb will take the color of its orb type.
	 * 
	 * @param type	Orb type
	 */
	protected void initializeNewOrbSeed(){
		if (orbType.equals(SimpleOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, SimpleOrb.RED, SimpleOrb.GREEN, SimpleOrb.BLUE);  // use SimpleOrb's color
		}
		else if (orbType.equals(ExplosiveOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, ExplosiveOrb.RED, ExplosiveOrb.GREEN, ExplosiveOrb.BLUE);  // use ExplosiveOrb's color
		}
		else if (orbType.equals(ExplodedOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, ExplodedOrb.RED, ExplodedOrb.GREEN, ExplodedOrb.BLUE);  // use ExplodedOrb's color
		}
		else if (orbType.equals(EvadingOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, EvadingOrb.RED, EvadingOrb.GREEN, EvadingOrb.BLUE);  // use EvadingOrb's color
		}
		else if (orbType.equals(StationaryTeleporterOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, StationaryTeleporterOrb.RED, StationaryTeleporterOrb.GREEN, StationaryTeleporterOrb.BLUE);  // use StationaryTeleporterOrb's color
		}
		else if (orbType.equals(MovingTeleporterOrb.class)){
			double radius = Utils.random(4,OrbBase.MAX_RADIUS);
			setOrbSeed(radius, MovingTeleporterOrb.RED, MovingTeleporterOrb.GREEN, MovingTeleporterOrb.BLUE);  // use MovingTeleporterOrb's color
		}
	}
}
