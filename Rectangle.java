/**This program performs various methods on given rectangles.
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class Rectangle {
	
	double x;	//top left corner x-coord
	double y;	//to left corner y-coord
	double width;	//width of rectangle
	double height;	//height of rectangle
	static int idNumber = -1; //initialize unique integer ID for rectangle
								  //count will increment off this so it will start at 0
	Point2D p = new Point2D();
	
		
	/**Makes a square of length 1 with top left corner at (0,0)
	 */
	public Rectangle(){
		width = 1;
		height = 1;
		x = 0;
		y = 0;
	}
	
	/**
	 *  Make a rectangle of width and height with top left corner at (x,y)
	 * @param x		Double value of top left corner x-coord
	 * @param y		Double value of top left corner y-coord
	 * @param width	Double value for rectangle width
	 * @param height	Double value for rectangle height
	 */
	public Rectangle(double x, double y, double width, double height){
		this.width = width;
		this.height = height;
		this.x = x;
		this.y = y;
		idNumber++;
	}
	
	/** Make a new rectangle with same size and position as Rectangle r.
	 * This rectangle will have a different ID.
	 * @param r		Rectangle r
	 */
	public Rectangle(Rectangle r){
		Rectangle r2 = new Rectangle(x, y, width, height);
	}
	
	/** Gets the unique ID for the rectangle.
	 * @return	Integer ID for the rectangle
	 */
	public int getID(){
		return idNumber;//get the unique ID
	}
	
	/**Gets the area of the rectangle
	 * @return	Double for the area of the rectangle
	 */
	public double getArea(){
		double area = width * height;
		return area; //get the area of the rectangle
	}
	
	/**Gets the perimeter of the rectangle
	 * @return Double for the perimeter of the rectangle
	 */
	public double getPerimeter(){
		double perimeter = 2 * height + 2 * width;
		return perimeter;
	}
	
	/**Gets the bottom edge coordinate (y-value)
	 * @return Double for the bottom edge coordinate
	 */
	public double getBottom(){
		double bottomEdge = y - height;
		return bottomEdge;
	}
	
	/**Gets the top edge coordinate (y-value)
	 * @return Double for the top edge coordinate
	 */
	public double getTop(){
		double topEdge = y;
		return topEdge;
	}
	
	/**Gets the right edge coordinate (x-value)
	 * @return Double for the right edge coordinate
	 */
	public double getRight(){
		double rightEdge = x + width;
		return rightEdge;
	}
	
	/**Gets the left edge coordinate (x-value)
	 * @return Double for the left edge coordinate
	 */
	public double getLeft(){
		double leftEdge = x;
		return leftEdge;
	}
	
	
	/**Checks if a point p is contained in the rectangle.
	 * If the point is on the boundary, it is contained.
	 * @param p	Point object that will be checked
	 * @return Boolean if the point is contained in the rectangle
	 */
	public boolean contains(Point2D p){
		double pX = p.getX();
		double pY = p.getY();
		boolean contained = false;
		if ((pY <= getTop()) && (pY >= getBottom()) && (pX >= getLeft()) && (pX <= getRight())){
			contained = true;
		}
		return contained;
	}
	
	/**This method checks if the passed circle is contained 
	 * in the rectangle. A circle c inside that touches the 
	 * boundary is contained.
	 * @param c The circle that will be checked.
	 * @return	Boolean if the circle is contained or not.
	 */
	public boolean contains(Circle c){
		boolean isContained = false;
		//get all pertinent information about the circle
		double radius = c.getRadius();
		Point2D center = c.getCenter();
		double centerX = center.getX();
		double centerY = center.getY();
		
		//get all pertinent information about the rectangle
		double bottomOutside = this.getBottom();
		double topOutside = this.getTop();
		double leftOutside = this.getLeft();
		double rightOutside = this.getRight();
		
		if ((centerX - leftOutside) + (centerY - bottomOutside) >= Math.pow(radius, 2.0))
			if ((centerX - rightOutside) + (centerY - topOutside) >= Math.pow(radius, 2.0))
				isContained = true;
		
		return isContained;
	}
	
	// A rectangle r inside that touches the boundary is contained. 
	public boolean contains(Rectangle r){
		boolean isContained = false;
		
		//Initialize inside coordinates
		double bottomInside = r.getBottom();
		double topInside = r.getTop();
		double leftInside = r.getLeft();
		double rightInside = r.getRight();
		
		//Initialize outside coordinates
		double bottomOutside = this.getBottom();
		double topOutside = this.getTop();
		double leftOutside = this.getLeft();
		double rightOutside = this.getRight();
		
		//First check that they have different IDs
		if (r.getID() != this.getID()){
			//If all coordinates are within the specified range, then the 
			//given rectangle is contained in the initial rectangle.
			if ((bottomInside >= bottomOutside) && (leftInside >= leftOutside) 
					&& (rightInside <= rightOutside) && (topInside <= topOutside))
				isContained = true;
		}
		return isContained;
	}
	
	/**Checks if r overlaps this rectangle.
	 * Touching does not count as overlapping.
	 * @param r	The rectangle to check
	 * @return	Boolean if the two rectangles overlap
	 */
	public boolean overlaps(Rectangle r){
		boolean overlaps = false;
		if (r.getID() != this.getID()){
			if ((x < r.x + r.width) && (x + width > r.x) && (y < r.y + r.height) && (y + height > r.y))
				overlaps = true;
		}
		return overlaps;
	}
	
	/**Checks if r has the same ID as this one
	 * @param r		Rectangle r
	 * @return	Boolean, if they have the same ID or not
	 */
	public boolean sameID(Rectangle r){
		if (this.getID() == r.getID())
			return true;
		else
			return false;
	}
	
	/**Checks if r1 and r2 have the same ID
	 * @param r1 The first rectangle
	 * @param r2 The second rectangle
	 * @return Boolean, if they have the same ID or not
	 */
	public static boolean sameID(Rectangle r1, Rectangle r2){
		int firstId = r1.getID();
		int secondId = r2.getID();
		if (firstId == secondId)
			return true;
		else
			return false;
	}
}
