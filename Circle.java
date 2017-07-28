/**This class represents circles.
 * This uses 3 constructors and 7 methods.
 * Circles are immutable.
 * This class reuses the distance() functions from Point2D.
 * 
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class Circle {
	private static double radius;
	private static Point2D center = new Point2D(1,2);
	public static int numberOfCircles = 0;
	
	/** This is a no-argument constructor, meaning it doesn't take
	 * any arguments. It initializes a circle of radius
	 * 1 centered at the origin.
	 */
	public Circle(){
		radius = 1.0;
		center = new Point2D(); //No argument, default center at origin
		numberOfCircles += 1; //Increment count of the number of circles
	}
	
	/**This constructor initializes the circle's center
	 * to the user-given 2D point.
	 * @param center	Center of the circle
	 * @param radius	Radius length of the circle
	 */
	public Circle(Point2D center, double radius){
		Circle.radius = radius;
		
		//If the radius is negative, give it a radius of 0
		if (radius < 0){
			radius = 0.0;
		}
		
		Circle.center = center;
		//Increment count of the number of circles
		numberOfCircles += 1;
	}
	
	/** This is a copy constructor.
	 * It makes a new circle that is identical to c.
	 * @param c	Circle to copy
	 */
	public Circle(Circle c){
		this(c.getCenter(), c.getRadius());
	}
	
	/**This method calculates and returns the area of the circle.
	 * @return Area of the circle
	 */
	
	public double area(){
		double area = (Math.PI) * (radius) * (radius);
		return area;
	}
	
	/**This method calculates and returns the circumference of the circle.
	 * @return	Circumference of the circle
	 */
	
	public double perimeter(){
		double perimeter = 2 * (Math.PI) * (radius);
		return perimeter;
	}
	
	/**This method returns the radius of the circle.
	 * The data is immutable.
	 * @return Radius of the circle
	 */
	
	public double getRadius(){
		return radius;
	}
	
	/**This method returns the center of the circle.
	 * The data is immutable.
	 * @return Center of the circle
	 */
	
	public Point2D getCenter(){
		return center;
	}
	
	/**This method checks if the circle overlaps with the created circle.
	 * @param c	The circle to check
	 * @return	Boolean, tells whether the circle overlaps (true) or not (false)
	 */
	
	public boolean overlaps(Circle c){
		//If the distance between these circles is less than 0,
		//there is space in between them, and thus, they don't
		//overlap.
		if (center.distance(c.getCenter().getX(), c.getCenter().getY()) > 0)
			return true;
		else 
			return false;
	}
	
	/**This method returns the number of Circle objects instantiated so far.
	 * This data is called from the counter we initialized above.
	 * @return Number of Circle objects created
	 */
	
	public static int numberofCircles(){
		return numberOfCircles;
	}
	
	/**This method takes a Point2D object and a variable
	 * length list of Circle type.
	 * @param p	Point2D object
	 * @param circles
	 * @return	Boolean array indicated the circles that 
	 * contain the point.
	 */
	public static boolean[] insideCircles(Point2D p, Circle... circles){
		boolean[] array = new boolean[circles.length];
		for (int i = 0; i < circles.length; i++){
			boolean check = p.distance(p.getX(), p.getY()) < radius;
			array[i] = check;
		}
		return array;
	}
	
	public static void main(String[] args){
		Circle circle = new Circle(); //default circle
		Circle circle1 = new Circle(center, 3.0); //circle with radius 3
		
		//Print out all info about the first circle
		System.out.println("FIRST CIRCLE, NO ARG CONSTRUCTOR");
		System.out.println("Radius: " + circle.getRadius());
		System.out.println("Center: (" + circle.getCenter().getX() + " , " + circle.getCenter().getY() + ")");
		System.out.println("Area: " + String.format("%.2f", circle.area()));
		System.out.println("Circumference: " + String.format("%.2f", circle.perimeter()));
		
		//Print out all info about the second circle
		System.out.println("SECOND CIRCLE, TWO ARG CONSTRUCTOR");
		System.out.println("Radius: " + circle1.getRadius());
		System.out.println("Center: (" + circle1.getCenter().getX() + " , " + circle1.getCenter().getY() + ")");
		System.out.println("Area: " + String.format("%.2f", circle1.area()));
		System.out.println("Circumference: " + String.format("%.2f", circle1.perimeter()));
		
		//Print out if the circles overlap
		//Print out how many circle objects there are
		System.out.println("Does circle1 overlap circle? " + circle.overlaps(circle1));
		System.out.println("There are " + numberOfCircles + " circle objects.");
	}
	
}
