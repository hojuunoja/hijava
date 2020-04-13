package Finally_Shape2;

public abstract class Shape implements Compareable{
	private String Name;
	protected double Area;
	protected double Perimeter;
	
	public Shape(String Name){
		this.Name = Name;
		Area = 0.0f;
		Perimeter = 0.0f;
	}
	
	public int compareTo(Object Other) {
		double Other_Area = ((Shape)Other).Area;
		if(this.Area > Other_Area)return 1;
		else if(this.Area < Other_Area) return -1;
		else return 0;
	}
	
	public boolean compareTo(String Name) {
		return this.Name.toLowerCase().equals(Name);
	}
	
	public double Area() {
		return Area;
	}
	
	public double Perimeter() {
		return Perimeter;
	}
	
	public abstract void calculateArea();
	public abstract void calculatePerimeter();
	
	public String Name() {
		return "Shape Type : " + Name;
	}
	
	public String toString() {
		return Name() + ", Area : " + Area + ", Perimeter : " + Perimeter;
	}
}
