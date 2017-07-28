import orbkit.CollidableOrb;

/**This interface provides a blueprint of methods
 * that can and will be used for orbs that have
 * evasion functionality.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */

public interface Evade {
	
	public boolean checkDistance(CollidableOrb d);
	
	public void evadeClosestOrb(CollidableOrb d);
}
