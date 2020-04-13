package Final_Shape;

public abstract class Shape implements MyCompareable{
	private String shapeName;
	public Shape(String Name) {
		this.shapeName = Name;
	}
	
	public abstract double computeArea();
	public abstract double computePerimeter();
	
	public int compareTo(Object Other) {
		double myArea = computeArea();
		double yourArea = ((Shape)Other).computeArea();
		if(myArea < yourArea) return -1;
		else if(myArea == yourArea) return 0;
		return 1;
	}
}
