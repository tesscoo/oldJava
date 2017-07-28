import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
/**This class provides methods and functionality
 * for creating a Simple Orb. This class was written 
 * by Tim Mitchell. I am keeping it here for more 
 * options with regards to selecting an orb type.
 * 
 * @author Tim Mitchell
 */

public class SimpleOrb extends CollidableOrb {

	// SimpleOrbs will be white
	public static final int RED 	= 255;
	public static final int GREEN	= 255;
	public static final int BLUE	= 255;
	
	/**Initializes the orb from orbSeed and gives it a speed.
	 * 
	 * @param allOrbs 
	 * @param orbSeed 
	 * @param speedX
	 * @param speedY
	 */
	public SimpleOrb(ObjectManager allOrbs, OrbBase orbSeed, double speedX, double speedY){
		super(allOrbs,orbSeed,speedX,speedY);
	}	
	
	/**
	 * This method gets called every update to the screen.
	 * This orb will not do anything new.
	 */
	public void dynamicOrbUpdate() {
		
	}
	
	/**If the classes are the same of the orbs, they will collide.
	 * If not, they will pass through each other.
	 * @return Boolean for ellastic collision decision
	 */
	@Override
	public boolean handleCollisionWith(CollidableOrb o){
		
		if (getClass().equals(o.getClass()))
			return true;
		
		return false; 
	}	
}
