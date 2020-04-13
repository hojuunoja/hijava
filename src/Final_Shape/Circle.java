package Final_Shape;

public class Circle extends Shape {

	private int radius;
	
	public Circle(int r) {
		super("Circle");
		radius = r;
	}
	
	public double computeArea() {
		return Math.PI * Math.pow(radius,  2);
	}
	
	public double computePerimeter() {
		return 2.0 * Math.PI * radius;
	}
	
	@Override
	public String toString() {
		return "Circle : radius is "  + radius;
	}
}
