import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;

/**This class was created by Tim Mitchell, and provides
 * functionality for an influenced orb. This class provides a
 * helper function influencedLevelOf() that determines how much the 
 * given orb should affect this particular orb. The closer the 
 * given orb is to the this orb, the more influencing power it has. 
 * 
 * @author Tim Mitchell
 */
public abstract class InfluencedOrb extends CollidableOrb {
	
	double radiusScalar = 15;
	protected double radiusOfInfluence;
	
	/** InfluencedOrb constructor.
	 * Params get passed to the superclass constructor.
	 * @param allOrbs	All Orb objects
	 * @param orbSeed   Seed of the orb
	 * @param speedX	X speed
	 * @param speedY	Y speed
	 */
	protected InfluencedOrb(ObjectManager allOrbs, OrbBase orbSeed, double speedX, double speedY){
		super(allOrbs, orbSeed, speedX, speedY);
		radiusOfInfluence = radiusScalar * getRadius();
	}
	
	/**Calculates how much influence OrbBase o has on this orb, from 
	 * 0 (none) to 1 (100%).  
	 * 
	 * @param o orb that may influence this one
	 * @return between 0 (no influence) and 1 (strongest influence)
	 */
	public final double influenceLevelOf(OrbBase o){
		double distance = distanceBetweenCenters(this, o);
		if (distance > radiusOfInfluence)
			return 0;

		return (radiusOfInfluence - distance) / radiusOfInfluence;
	}
}
