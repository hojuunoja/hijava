package Final_Shape;

import java.util.Scanner;

public class ShapeAplication {
	private int capacity = 10;
	private Shape[] shapes = new Shape[capacity];
	private int n_shapes = 0;
	private Scanner Input = new Scanner(System.in);

	public void processCommand() {

		while(true) {
			System.out.print("$ ");
			String Command = Input.next();
			if(Command.equals("add")) {
				handleAdd();
			}
			else if(Command.equals("show")||Command.equals("showdetail")) {
				handleShow(Command.equals("showdetail"));
			}
			else if(Command.equals("sort")) {
				bubbleSort(shapes, n_shapes);
			}
			else if(Command.equals("exit"))
				return;
		}
		//Input.close();
	}

//	private void bubbleSort() {
//		for(int i = n_shapes -1; i> 0; i--)
//			for(int j = 0; j < i; j++)
//				if( shapes[j].computeArea() > shapes[j+1].computeArea()) {
//					Shape temp = shapes[j];
//					shapes[j] = shapes[j+1];
//					shapes[j+1] = temp;
//				}
//	}
	
	private void bubbleSort(MyCompareable [] data, int size) {
		for(int i = size -1; i> 0; i--)
			for(int j = 0; j < i; j++)
				if( data[j].compareTo(data[j+1]) > 0) {
					MyCompareable temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
	}
	

	private void handleShow(boolean detailed) {
		for(int i = 0; i < n_shapes; i++) {
			System.out.println( (i + 1) + ". " + shapes[i].toString());
			if(detailed) {
				System.out.println("\tThe area is " + shapes[i].computeArea());
				System.out.println("\tThe perimeter is " + shapes[i].computePerimeter());
			}
		}
	}

	private void handleAdd() {
		char type = Input.next().charAt(0);
		switch(type) {

		case 'R':
			int width = Input.nextInt();
			int height = Input.nextInt();
			Rectangle rec = new Rectangle(width, height);
			addShape(rec);
			break;

		case 'C':
			addShape( new Circle( Input.nextInt()));
			break;

		case 'T':
			//addShape( new Triangle(Input.hasNextInt(), Input.nextInt()));
			break;

		default:
			break;
		}
	}

	private void addShape(Shape shape) {
		if(n_shapes >= capacity)
			reallocate();
		
		shapes[n_shapes++] = shape;
	}

	private void reallocate() {
		capacity *= 2;
		Shape[] temp = new Shape[capacity];
		System.arraycopy(shapes,  0,  temp,  0,  shapes.length);
		shapes = temp;
	}

	public static void main(String[] args) {
		ShapeAplication app = new ShapeAplication();
		app.processCommand();
	}
}
