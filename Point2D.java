/**This program stores the x and y coordinates for a 2D point.
 * The program uses 3 constructors and 5 methods.
 * The Point2D object is immutable (unchangeable).
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 *
 */
public class Point2D {
	
	public static void main(String[] args){
		//Initialize a new point object
		Point2D points = new Point2D();
		
		//Print the distance to the console
		System.out.println(String.format("%.2f", points.distance(2,4)));
	}
	
	//Initialize the coordinates
	private double x;
	private double y;
	
	/**This is a default no-argument constructor.
	 * It initializes a point to the origin.
	 */
	public Point2D(){
		x = 0;
		y = 0;
	}
	
	/**This constructor initializes the new point
	 * to the user-specified x and y coordinates.
	 * @param x	X-coordinate
	 * @param y	Y-coordinate
	 */
	public Point2D(double x, double y){
		//Gets coordinates from object
		this.x = x;
		this.y = y;
	}
	
	/** This is a copy constructor.
	 * It makes a new point that is identical to p.
	 * @param p	Point
	 */
	public Point2D(Point2D p){
		//Gets coordinates from other object
		this(p.getX(), p.getY());
	}
	
	/**This method gives the value of x.
	 * @return Returns the value of x
	 */
	public double getX(){
		return x;
	}
	
	/**This method gives the value of y.
	 * @return Returns the value of y
	 */
	public double getY(){
		return y;
	}
	
	/**This method returns the distance between the 
	 * entered point and the set point.
	 * @param x		Value inserted for x
	 * @param y		Value inserted for y
	 * @return		Returns distance between these points
	 */
	public double distance(double x, double y){
		double distance = Math.sqrt((Math.pow((this.x-x), 2)) + (Math.pow((this.y-y), 2)));
		return distance;
	}
	
	/**This method uses a Point2D object as the parameter to return distance.
	 * 
	 * @param p	Point2D object
	 * @return	Returns distance between set point and Point2D object
	 */
	public double distance (Point2D p){
		return p.distance(x, y);
	}
	
	/**This method is a static function that computes the
	 * distance between two points.
	 * @param p1 Point one
	 * @param p2 Point two
	 * @return	Distance between the two points
	 */
	public static double distance(Point2D p1, Point2D p2){
		//Get two sets of coordinates and calculate the distance between them
		double x1 = p1.getX();
		double y1 = p1.getY();
		double x2 = p2.getX();
		double y2 = p2.getY();
		double distance = Math.sqrt((Math.pow((x2 - x1), 2)) + (Math.pow((y2 - y1), 2)));
		return distance;
	}
}
