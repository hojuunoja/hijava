package Finally_Shape2;

public class Rectangle extends Shape{
	private int height;
	private int width;
	
	public Rectangle(int height, int width) {
		super("Rectangle");
		this.height = height;
		this.width = width;
		calculateArea();
		calculatePerimeter();
	}
	
	public void calculateArea() {
		Area = (int)(width * height); 
	}
	public void calculatePerimeter() {
		Perimeter = (int)2 * ( height + width );
	}
	
	public String toString() {
		return super.toString() + "\n\theight : " + height + ", width : " + width;
	}
}
