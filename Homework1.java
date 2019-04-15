package homeworkChapter10;

public class Homework1 {

	public static void main(String[] args) {
		// create subclass objects
		SalariedEmployee salariedEmployee = new SalariedEmployee("John", "Travolta", "111-11-1111", 18, 02, 1954,
				800.00);
		HourlyEmployee hourlyEmployee = new HourlyEmployee("Lena", "Golovach", "222-22-2222", 23, 02, 1983, 16.75, 40);
		CommissionEmployee commissionEmployee = new CommissionEmployee("Akakii", "Kazantip", "333-33-3333", 20, 07,
				1992, 10000, .06);
		BasePlusCommissionEmployee basePlusCommissionEmployee = new BasePlusCommissionEmployee("Mihail", "Graur",
				"444-44-4444", 15, 10, 1993, 5000, .04, 300);

		Employee[] employees = new Employee[4];

		// initialize array with Employees
		employees[0] = salariedEmployee;
		employees[1] = hourlyEmployee;
		employees[2] = commissionEmployee;
		employees[3] = basePlusCommissionEmployee;

		for (int m = 1; m < 13; m++) {
			System.out.println("Today is " + m + " month.");

			for (Employee currentEmployee : employees) {

				if (currentEmployee.getBday() == m)
					System.out.printf("%smonth salary: $%s%n%n", currentEmployee.toString(),
							currentEmployee.earnings() + 100);

				else
					System.out.printf("%smonth salary: $%s%n%n", currentEmployee.toString(),
							currentEmployee.earnings());
			}
		}
	} // end main
} // end class PayrollSystemTest


//10.12 (Payroll System Modification) Modify the payroll system of Figs. 10.4–10.9 to include private
//instance variable birthDate in class Employee. Use class Date of Fig. 8.7 to represent an employee’s 
//birthday. Add get methods to class Date. Assume that payroll is processed once per month.
//Create an array of Employee variables to store references to the various employee objects. In a loop,
//calculate the payroll for each Employee (polymorphically), and add a $100.00 bonus to the person’s
//payroll amount if the current month is the one in which the Employee’s birthday occurs. 
