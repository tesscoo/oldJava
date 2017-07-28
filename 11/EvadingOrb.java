import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
import orbkit.Timer;
import orbkit.Utils;
/**This class creates the Evading Orb, and implements
 * the Evade interface. This orb steers away from 
 * the nearest orb once they get within 100 px 
 * of each other.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class EvadingOrb extends CollidableOrb implements Evade {
	
	// SimpleOrbs will be hot pink
	public static final int RED 	= 255;
	public static final int GREEN	= 5;
	public static final int BLUE	= 165;
		
	//Evading orb constructor
	public EvadingOrb(ObjectManager manager, OrbBase o, double speedX,
			double speedY) {
		super(manager, o, speedX, speedY);
	}

	@Override
	protected void dynamicOrbUpdate() {
		
		// If there is a nearby orb of different type, evade it
		CollidableOrb d = getClosestOrbOfDifferentType();
		
		if (d == null)
			return;
		else
			checkDistance(d); //Call the checkDistance() method (interface).
		
		if (checkDistance(d)){	
			evadeClosestOrb(d);
		}
	}

	@Override
	protected boolean handleCollisionWith(CollidableOrb arg0) {
		return true;
	}

	@Override
	public boolean checkDistance(CollidableOrb d) {
		double distance = distanceBetweenCenters(this, d);
		//Check the closest orb
		if (distance < (this.getRadius() + d.getRadius() + 100))
			return true;
		else
			return false;
	}

	@Override
	public void evadeClosestOrb(CollidableOrb d) {
		double orbSpeed =  getTotalSpeed();

		double deltaX = d.getX() - getX();
		double deltaY = d.getY() - getY();
		double speedToOtherOrb = Math.sqrt(Math.pow(deltaX,2) + Math.pow(deltaY,2));

		// Change direction without changing the speed and velocity
		double newSpeedX = (deltaX) * (orbSpeed / speedToOtherOrb);
		double newSpeedY = (deltaY) * (orbSpeed / speedToOtherOrb);

		// Match the new speed to its original speed
		double newSpeed = getTotalSpeed(newSpeedX,newSpeedY);
		newSpeedX *= (orbSpeed / newSpeed);
		newSpeedY *= (orbSpeed / newSpeed);

		// Update the speed (reverse) so that it evades d
		setSpeed(-newSpeedX, -newSpeedY);
		
		
	}

}
