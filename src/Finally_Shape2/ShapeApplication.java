package Finally_Shape2;

import java.util.Scanner;

public class ShapeApplication {
	private int capacity;
	private Shape[] shapes;
	private int n_shapes;
	private Scanner Input = new Scanner(System.in);
	
	public ShapeApplication() {
		capacity = 10;
		shapes = new Shape[capacity];
		n_shapes = 0;
	}
	
	public void processCommand() {
		
		while(true) {
			System.out.print("$ ");
			String Command = Input.next();
			
			if(Command.toLowerCase().equals(("add").toLowerCase())) {
				add_Shape();
			}
			else if(Command.toLowerCase().equals(("print").toLowerCase())) {
				print_Shape();
			}
			else if(Command.toLowerCase().equals(("sort").toLowerCase())) {
				sort_Shape(shapes, 0,  n_shapes - 1);
			}
			else if(Command.toLowerCase().equals(("find").toLowerCase())) {
				find_Shape();
			}
			else if(Command.toLowerCase().equals(("exit").toLowerCase()))
				break;
		}
		Input.close();
	}
	
	private void find_Shape() {
		String type = Input.next();
		for(int i = 0; i < n_shapes; i++)
			if(shapes[i].compareTo(type.toLowerCase())) {
				System.out.println(shapes[i].toString());
			}
	}

	private void sort_Shape(Compareable[] data,int begin, int end) {
		
		if(end <= begin) return;
		int Pivot = begin;
		int Left = Pivot+1;
		int Right = end;
		
		while(Left <= Right){
			while( (Left <= Right) && (data[Left].compareTo(data[Pivot])<=0))++Left;
			while( ( Right > Pivot ) && ( data[Right].compareTo(data[Pivot]) >0 )) --Right;
			
			if(Left <= Right) {
				Compareable temp = data[Left];
				data[Left] = data[Right];
				data[Right] = temp;
			}
			else {
				Compareable temp = data[Right];
				data[Right] = data[Pivot];
				data[Pivot] = temp;
			}
		}
		
		sort_Shape(data, begin, Right - 1);
		sort_Shape(data, Right + 1, end);
	}

	private void print_Shape() {
		for(int i = 0; i < n_shapes; i++)
			System.out.println((i+1) + ". " + shapes[i].toString());
	}

	private void add_Shape() {
		String type = Input.next();
		
		switch(type.toLowerCase()) {
		
		case "circle":
			Insert_Shape(new Circle(Input.nextInt()));
			break;
			
		case "triangle":
			Insert_Shape(new Triangle(Input.nextInt(), Input.nextInt()));
			break;
			
		case "rectangle":
			Insert_Shape(new Rectangle(Input.nextInt(), Input.nextInt()));
			break;
		}
	}

	private void Insert_Shape(Shape shape) {
		if(n_shapes >= capacity)
			Reallocate();
		
		shapes[n_shapes++] = shape;
	}

	private void Reallocate() {
		capacity *= 2;
		Shape[] temp = new Shape[capacity];
		System.arraycopy(shapes, 0, temp, 0, n_shapes);
		
		shapes = temp;
	}

	public static void main(String[] args) {
		
		ShapeApplication app = new ShapeApplication();
		app.processCommand();
	}
}
