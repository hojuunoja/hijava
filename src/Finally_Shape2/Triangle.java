package Finally_Shape2;

public class Triangle extends Shape{
	private int height;
	private int bottom;
	
	public Triangle(int height, int bottom) {
		super("Triangle");
		this.height= height;
		this.bottom = bottom;
		calculateArea();
		calculatePerimeter();
	}
	
	public void calculateArea() {
		Area = height * bottom * 0.5f;
	}
	public void calculatePerimeter() {
		Perimeter = (int)2 * ( height + bottom );
	}
	
	public String toString() {
		return super.toString() + "\n\theight : " + height + ", bottom : " + bottom;
	}
}
