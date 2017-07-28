/**This program tests what I have done in the Rectangle program.
 * @author Tess Iskra, tli207
 * @version 1.0
 */
public class TestRectangle {
	public static void main(String[] args){
		Rectangle first = new Rectangle();
		
		Rectangle second = new Rectangle(2, 2, 5, 5);
		
		Rectangle third = new Rectangle(second);
		
		int identification1 = first.getID();
		int identification2 = second.getID();
		int identification3 = third.getID();
		
		double area1 = first.getArea();
		
		double perimeter2 = second.getPerimeter();
		
		double bottom2 = second.getBottom();
		double top2 = second.getTop();
		double right2 = second.getRight();
		double left2 = second.getLeft();
		
		Point2D p = new Point2D(4, 5);
		boolean containsPoint = second.contains(p);
		
		Circle c = new Circle();
		boolean containsCircle = second.contains(c);
		
		boolean containsRect = second.contains(third);
		
		boolean overlaps = first.overlaps(third);
		
		boolean sameID1 = second.sameID(third);
		
		boolean sameID2 = Rectangle.sameID(first, second);
		
		//Not going to print these, since they're just addresses
		//System.out.println(first); 
		//System.out.println(second);
		//System.out.println(third);
		System.out.println(identification1);
		System.out.println(identification2);
		System.out.println(identification3);
		System.out.println(area1);
		System.out.println(perimeter2);
		System.out.println(bottom2);
		System.out.println(top2);
		System.out.println(right2);
		System.out.println(left2);
		System.out.println(containsPoint);
		System.out.println(containsCircle);
		System.out.println(containsRect);
		System.out.println(overlaps);
		System.out.println(sameID1);
		System.out.println(sameID2);
		
	
	}
}
