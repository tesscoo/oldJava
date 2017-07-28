import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;
import orbkit.SampleExplosion;
/**This class creates the Explosive Orb, which acts
 * as a stationary mine. This class implements
 * the marker interface, ExplosionOrbs.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 *
 */
public class ExplosiveOrb extends CollidableOrb implements ExplosionOrbs {
		
		// SimpleOrbs will be light blue
		public static final int RED 	= 155;
		public static final int GREEN	= 229;
		public static final int BLUE	= 245;
		
		//Explosive Orb constructor, extended from Collidable Orb
		public ExplosiveOrb(ObjectManager manager, OrbBase o, double speedX, double speedY) {
			super(manager, o, speedX, speedY);
		}

		@Override
		protected void dynamicOrbUpdate() {
			setSpeed(0, 0); //Make the orb stationary 
		}

		@Override
		protected boolean handleCollisionWith(CollidableOrb o) {
			//If o is one of the Explosion Orbs, classified by the marker interface,
			//then remove both orbs from the screen and display the explosion animation.
			//Otherwise, they will bounce off each other.
			if (o instanceof ExplosionOrbs){
				o.setToRemove();
				setToRemove();
				addAnimation(new SampleExplosion(canvas, 1.5, getX(), getY(), getRadius()*20));
				return false;}
			return true; 
		}

}
