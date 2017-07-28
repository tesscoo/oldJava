/**This exception gets thrown by RobustCounter's constructor
 * if a negative counter start value is specified.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class NegativeStartValueException extends Exception {
	private int startValue;
	public String error = "ERROR: Invalid start value.";
	
	public NegativeStartValueException(int startValue){
		super("Invalid start value: " + startValue);
		this.startValue = startValue;
	}
	
	public int getStartValue(){
		return startValue;
	}

}
