import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
import orbkit.Timer;

/**This class creates the Moving Teleporter Orb.
 * This orb is thrown on the screen, teleports
 * to another position, then continues teleporting every
 * 5 seconds. This orb has a flashing state animation.
 * This class extends the abstract class Teleporter.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class MovingTeleporterOrb extends Teleporter {

		// MovingTeleporterOrb will be green
		public static final int RED 	= 0;
		public static final int GREEN	= 265;
		public static final int BLUE	= 0;
		
		Timer timer; //Initialize timer
			
		//Moving Teleporter Orb constructor
		public MovingTeleporterOrb(ObjectManager manager, OrbBase o, double speedX,
				double speedY) {
			super(manager, o, speedX, speedY);
		}

		@Override
		protected void dynamicOrbUpdate() {
			if (timer == null && !stillInitializing())
				timer = new Timer(); //Initialize the timer ONCE
			
			//Teleport the orb every five seconds
			if ((timer.getElapsedTime() % 5) > 4 && (timer.getElapsedTime() % 5)  < 5)
				Teleport();
		}

		@Override
		protected boolean handleCollisionWith(CollidableOrb o) {
			return true; //This orb will collide with other orbs while it's moving around
		}
		
}
