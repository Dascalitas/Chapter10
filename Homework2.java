package homeworkChapter10;

abstract class shape {

	public abstract double area();

	public abstract String toString();
}

abstract class TwoDimensional extends shape {

	private final double side;

	public TwoDimensional(double side) {

		if (side < 0) // validate size
			throw new IllegalArgumentException("side must be more than zero");

		this.side = side;
	}

	public double getSide() {
		return side;
	}

	public abstract double area();

	public String toString() {
		return String.format("side %.2f millimeters have area %.2f square millimeters;", side, area());
	}
}

abstract class ThreeDimensional extends shape {

	private final double side;

	public ThreeDimensional(double side) {
		this.side = side;
	}

	public abstract double area();

	public abstract double volume();

	public double getSide() {
		return side;
	}

	public String toString() {
		return String.format(
				"side %.2f millimeters have area %.2f square millimeters%nand volume %.2f cube millimeters;", side,
				area(), volume());
	}
}

class circle extends TwoDimensional {

	public circle(double side) {
		super(side);
	}

	public double area() {
		return Math.PI * Math.pow(getSide(), 2);
	}

	@Override
	public String toString() {
		return String.format("Circle with %s%n", super.toString());
	}
}

class square extends TwoDimensional {

	public square(double side) {
		super(side);
	}

	public double area() {
		return Math.pow(getSide(), 2);
	}

	@Override
	public String toString() {
		return String.format("Square with %s%n", super.toString());
	}
}

class triangle extends TwoDimensional {

	private double side2;
	private double side3;

	public triangle(double side, double side2, double side3) {
		super(side);

		this.side2 = side2;
		this.side3 = side3;
	}

	public double area() {
		double p = (getSide() + side2 + side3) / 2;
		return Math.sqrt(p * (p - getSide()) * (p - side2) * (p - side3));
	}

	@Override
	public String toString() {
		return String.format("Triangle with side %.2f, second %.2f and third %s%n", side2, side3, super.toString());
	}
}

class sphere extends ThreeDimensional {

	public sphere(double side) {
		super(side);
	}

	public double area() {
		return 4 * (Math.PI * Math.pow(getSide(), 2));
	}

	public double volume() {
		return 4 / 3 * Math.PI * Math.pow(getSide(), 3);
	}

	@Override
	public String toString() {
		return String.format("Sphere with %s%n", super.toString());
	}
}

class cube extends ThreeDimensional {

	public cube(double side) {
		super(side);
	}

	public double area() {
		return 6 * Math.pow(getSide(), 2);
	}

	public double volume() {
		return Math.pow(getSide(), 3);
	}

	@Override
	public String toString() {
		return String.format("Cube with %s%n", super.toString());
	}
}

class tetraedron extends ThreeDimensional {

	public tetraedron(double side) {
		super(side);
	}

	public double area() {
		return Math.sqrt(3) * (Math.pow(getSide(), 2));
	}

	public double volume() {
		return Math.pow(getSide(), 3) / (6 * Math.sqrt(2));
	}

	@Override
	public String toString() {
		return String.format("Tetraedron with %s%n", super.toString());
	}
}

public class Homework2 {

	public static void main(String[] args) {
		circle test = new circle(10);
		System.out.println(test.toString());

		square test2 = new square(10);
		System.out.println(test2.toString());

		triangle test3 = new triangle(4, 5, 6);
		System.out.println(test3.toString());

		System.out.println("And now ThreeDimensional");

		sphere test4 = new sphere(10);
		System.out.println(test4.toString());

		cube test5 = new cube(10);
		System.out.println(test5.toString());

		tetraedron test6 = new tetraedron(10);
		System.out.println(test6.toString());

	}

}


//10.13 (Project: Shape Hierarchy) Implement the Shape hierarchy shown in Fig. 9.3. 
//Each TwoDimensionalShape should contain method getArea to calculate the area of the two-dimensional shape. 
//Each ThreeDimensionalShape should have methods getArea and getVolume to calculate the surface area and volume, 
//respectively, of the three-dimensional shape. 
//Create a program that uses an array of Shape references to objects of each concrete class in the hierarchy. 
//The program should print a text description of the object to which each array element refers.
//Also, in the loop that processes all the shapes in the array, determine whether each shape is a TwoDimensionalShape or a
//ThreeDimensionalShape. If it’s a TwoDimensionalShape, display its area. If it’s a ThreeDimensionalShape, display its area and volume. 