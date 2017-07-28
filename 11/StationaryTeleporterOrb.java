import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
import orbkit.Timer;

/**This class creates the Stationary Teleporter Orb.
 * This orb is positioned on the screen, teleports
 * to another position, then continues teleporting every
 * 5 seconds. This orb has a flashing state animation.
 * This class extends the abstract class Teleporter.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public class StationaryTeleporterOrb extends Teleporter {
	
	// StationaryTeleporterOrbs will be blue
	public static final int RED 	= 0;
	public static final int GREEN	= 0;
	public static final int BLUE	= 265;
	
	//Initialize a timer
	Timer timer;
		
	//Stationary Teleporter Orb constructor
	public StationaryTeleporterOrb(ObjectManager manager, OrbBase o, double speedX,
			double speedY) {
		super(manager, o, 0, 0);
	}

	@Override
	protected void dynamicOrbUpdate() {
		if (timer == null && !stillInitializing())
			timer = new Timer(); //only initialize the timer once
		
		//Every 5 seconds, call the teleporter function
		if ((timer.getElapsedTime() % 5) > 4 && (timer.getElapsedTime() % 5)  < 5)
			Teleport();
	}

	@Override
	protected boolean handleCollisionWith(CollidableOrb o) {
		return false; //The stationary teleporter orb will not collide with other orbs
	}
}
