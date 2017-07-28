/**This class throws exceptions when either:
 * -a RobustCounter instance is initialized with a negative start value
 * -a RobustCounter instance is incremented so much so that its 
 * internal counter variable overflows
 * Otherwise, this method provides basic functionality
 * of a counter that may overflow or be incremented
 * by the user.
 * 
 * @author Tess Iskra, tli207
 *
 */
public class RobustCounter {
	int count; //Initialize the counter
	int startValue; //Initialize start value
	
	/**Sets the counter's starting value to 0.
	 */
	public RobustCounter(){
		startValue = 0;
	}
	
	/** Initializes the counter at startValue.
	 * If startValue < 0, a checked exception is thrown.
	 * @param startValue	Integer for start value of counter
	 */
	public RobustCounter(int startValue) throws NegativeStartValueException{
		this.startValue = startValue;
		if (startValue < 0)
			throw new NegativeStartValueException(startValue);
		else
			count = startValue;	
	}
	
	/** Increment the current counter instance by 1.
	 *  A checked exception will be thrown if overflow occurs.
	 */
	public void increment() throws CounterOverflowedException{
		if (count > 2147483647)
			throw new CounterOverflowedException();
		else
			count++;
	}
	
	/** Returns the current count of the counter */
	public int getCount(){
		return count;
	}
	
	/** Returns the specified start value of the counter */
	public int getStartValue(){
		return startValue;
	}
	
	/** Resets the counter to zero */
	public void resetToZero(){
		count = 0;
	}
	
	/** Resets the counter to the start value given to the constructor.*/
	public void resetToStartValue(){
		count = getStartValue();
	}
}
