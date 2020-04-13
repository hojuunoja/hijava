package Finally_Shape2;

public class Circle extends Shape {
	private int radius;
	
	public Circle(int radius) {
		super("Circle");
		this.radius = radius;
		calculateArea();
		calculatePerimeter();
	}
	
	public void calculateArea() {
		Area = Math.PI * Math.pow(radius,  2); 
	}
	public void calculatePerimeter() {
		Perimeter = Math.PI * 2 * radius;
	}
	
	public String toString() {
		return super.toString() + "\n\tradius : " + radius;
	}
}
