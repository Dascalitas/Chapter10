package homeworkChapter10;

class PieceWorker extends Employee {

	private double wage;
	private int pieces;

	PieceWorker(String firstName, String lastName, String socialSecurityNumber, int day, int month, int year,
			double wage, int pieces) {

		super(firstName, lastName, socialSecurityNumber, day, month, year);

		if (wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage can't be less than zero. We are not in Russia.");

		if (pieces < 0.0) // validate wage
			throw new IllegalArgumentException("pieces can't be less than zero");

		this.wage = wage;
		this.pieces = pieces;
	}

	public double getWage() {
		return wage;
	}

	public void setWage(double wage) {

		if (wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage can't be less than zero. We are not in Russia.");

		this.wage = wage;
	}

	public int getPieces() {
		return pieces;
	}

	public void setPieces(int pieces) {

		if (pieces < 0) // validate wage
			throw new IllegalArgumentException("pieces can't be less than zero");

		this.pieces = pieces;
	}

	@Override
	public double earnings() {
		return getWage() * getPieces();
	}

	@Override
	public String toString() {
		return String.format("Piece Worker employee: %s%n%s: $%,.2f;%n%s: %d;%n", super.toString(), "hourly wage",
				getWage(), "pieces produced", getPieces());
	}
}

public class Homework3 {

	public static void main(String[] args) {
		PieceWorker pieceWorker = new PieceWorker("Alexei", "Popovich", "777-777-777-7777", 23, 07, 1991, 200, 30);
		System.out.printf("%s%nhave in that month $%.2f;", pieceWorker.toString(), pieceWorker.earnings());

	}

}


//10.14 (Payroll System Modification) Modify the payroll system of Figs. 10.4–10.9 to include an
//additional Employee subclass PieceWorker that represents an employee whose pay is based on the
//number of pieces of merchandise produced. Class PieceWorker should contain private instance
//variables wage (to store the employee’s wage per piece) and pieces (to store the number of pieces
//produced). Provide a concrete implementation of method earnings in class PieceWorker that calculates
//the employee’s earnings by multiplying the number of pieces produced by the wage per piece. 
//Create an array of Employee variables to store references to objects of each concrete class in
//the new Employee hierarchy. For each Employee, display its String representation and earnings.