package Final_Shape;

public class Rectangle extends Shape {
	private int width;
	private int height;
	
	public Rectangle(int width, int height) {
		super("Rectangle");
		this.width = width;
		this.height = height;
	}
	
	public double computeArea() {
		return (double)width*height;
	}
	
	public double computePerimeter() {
		return 2.0*(width + height);
	}
	
	@Override
	public String toString() {
		return "Rectangle : width is " + width + ", height is " + height;
	}
}
