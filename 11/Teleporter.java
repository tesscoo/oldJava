import orbkit.CollidableOrb;
import orbkit.ObjectManager;
import orbkit.OrbBase;

/** This abstract class provides functionality
 * to orbs that will be teleporting.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public abstract class Teleporter extends CollidableOrb {
	
	//Teleporter constructor
	public Teleporter(ObjectManager manager, OrbBase o, double speedX,
			double speedY) {
		super(manager, o, speedX, speedY);
	}
	
	//Teleport functionality
	public final void Teleport(){
		final int canvasWidth = 1000;
		final int canvasHeight = 600;
						
		int newX = (int) (Math.random()*canvasWidth); //Choose a random number between 0 and the canvas width
		int newY = (int) (Math.random()*canvasHeight); //Choose a random number between 0 and the canvas height

		//Remove the current orb
		setToRemove();
		
		//Make a new orb that is entered the screen at the new, random position
		addOrb(this.getClass(), newX, newY, this.getRadius(), this.getSpeedX(), this.getSpeedY(), 
				this.getRed(), this.getGreen(), this.getBlue());
	}
	
}
