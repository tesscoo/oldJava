import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
import orbkit.Timer;
/**This class creates the Exploded Orb and implements
 * the marker interface, ExplosionOrbs.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class ExplodedOrb extends CollidableOrb implements ExplosionOrbs {
	
	// SimpleOrbs will be purple
	public static final int RED 	= 155;
	public static final int GREEN	= 0;
	public static final int BLUE	= 265;
	
	Timer timer; //Initialize the timer
	
	//ExplodedOrb constructor
	public ExplodedOrb(ObjectManager manager, OrbBase o, double speedX,
			double speedY) {
		super(manager, o, speedX, speedY);
	}

	@Override
	protected void dynamicOrbUpdate() {
		if (timer == null && !stillInitializing())
			timer = new Timer();
		//The orb will explode after 5 seconds
		if (timer.getElapsedTime() > 5)
			setToRemove();
			//TODO Add animation here 
	}

	@Override
	protected boolean handleCollisionWith(CollidableOrb o) {
		return false; //This orb does not collide with others
	}

}
