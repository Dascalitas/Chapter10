package homeworkChapter10;

abstract class Employee {
	private final String firstName;
	private final String lastName;
	private final String socialSecurityNumber;
	private final Date birthDate;

	// constructor
	public Employee(String firstName, String lastName, String socialSecurityNumber, int day, int month, int year) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.socialSecurityNumber = socialSecurityNumber;
		this.birthDate = new Date(day, month, year);
	}

	// return first name
	public String getFirstName() {
		return firstName;
	}

	// return last name
	public String getLastName() {
		return lastName;
	}

	// return social security number
	public String getSocialSecurityNumber() {
		return socialSecurityNumber;
	}

	// return birthday
	public Date getBirthDate() {
		return birthDate;
	}

	// return month
	public int getBday() {
		return birthDate.getMonth();
	}

	// return String representation of Employee object
	@Override
	public String toString() {
		return String.format("%s %s;%nsocial security number: %s;%nbirthday: %s;", getFirstName(), getLastName(),
				getSocialSecurityNumber(), getBirthDate());
	}

	// abstract method must be overridden by concrete subclasses
	public abstract double earnings(); // no implementation here
} // end abstract class Employee

class HourlyEmployee extends Employee {
	private double wage; // wage per hour
	private double hours; // hours worked for week

	// constructor
	public HourlyEmployee(String firstName, String lastName, String socialSecurityNumber, int day, int month, int year,
			double wage, double hours) {
		super(firstName, lastName, socialSecurityNumber, day, month, year);

		if (wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		if ((hours < 0.0) || (hours > 168.0)) // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

		this.wage = wage;
		this.hours = hours;
	}

	// set wage
	public void setWage(double wage) {
		if (wage < 0.0) // validate wage
			throw new IllegalArgumentException("Hourly wage must be >= 0.0");

		this.wage = wage;
	}

	// return wage
	public double getWage() {
		return wage;
	}

	// set hours worked
	public void setHours(double hours) {
		if ((hours < 0.0) || (hours > 168.0)) // validate hours
			throw new IllegalArgumentException("Hours worked must be >= 0.0 and <= 168.0");

		this.hours = hours;
	}

	// return hours worked
	public double getHours() {
		return hours;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		if (getHours() <= 40) // no overtime
			return getWage() * getHours();
		else
			return 40 * getWage() + (getHours() - 40) * getWage() * 1.5;
	}

	// return String representation of HourlyEmployee object
	@Override
	public String toString() {
		return String.format("hourly employee: %s%n%s: $%,.2f;%n%s: %,.2f;%n", super.toString(), "hourly wage",
				getWage(), "hours worked", getHours());
	}
} // end class HourlyEmployee

class SalariedEmployee extends Employee {
	private double weeklySalary;

	// constructor
	public SalariedEmployee(String firstName, String lastName, String socialSecurityNumber, int day, int month,
			int year, double weeklySalary) {
		super(firstName, lastName, socialSecurityNumber, day, month, year);

		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// set salary
	public void setWeeklySalary(double weeklySalary) {
		if (weeklySalary < 0.0)
			throw new IllegalArgumentException("Weekly salary must be >= 0.0");

		this.weeklySalary = weeklySalary;
	}

	// return salary
	public double getWeeklySalary() {
		return weeklySalary;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getWeeklySalary();
	}

	// return String representation of SalariedEmployee object
	@Override
	public String toString() {
		return String.format("salaried employee: %s%n%s: $%,.2f;%n", super.toString(), "weekly salary",
				getWeeklySalary());
	}
} // end class SalariedEmployee

class CommissionEmployee extends Employee {
	private double grossSales; // gross weekly sales
	private double commissionRate; // commission percentage

	// constructor
	public CommissionEmployee(String firstName, String lastName, String socialSecurityNumber, int day, int month,
			int year, double grossSales, double commissionRate) {
		super(firstName, lastName, socialSecurityNumber, day, month, year);

		if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		if (grossSales < 0.0) // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
		this.commissionRate = commissionRate;
	}

	// set gross sales amount
	public void setGrossSales(double grossSales) {
		if (grossSales < 0.0) // validate
			throw new IllegalArgumentException("Gross sales must be >= 0.0");

		this.grossSales = grossSales;
	}

	// return gross sales amount
	public double getGrossSales() {
		return grossSales;
	}

	// set commission rate
	public void setCommissionRate(double commissionRate) {
		if (commissionRate <= 0.0 || commissionRate >= 1.0) // validate
			throw new IllegalArgumentException("Commission rate must be > 0.0 and < 1.0");

		this.commissionRate = commissionRate;
	}

	// return commission rate
	public double getCommissionRate() {
		return commissionRate;
	}

	// calculate earnings; override abstract method earnings in Employee
	@Override
	public double earnings() {
		return getCommissionRate() * getGrossSales();
	}

	// return String representation of CommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s: %s%n%s: $%,.2f;%n%s: %.2f;%n", "commission employee", super.toString(), "gross sales",
				getGrossSales(), "commission rate", getCommissionRate());
	}
} // end class CommissionEmployee

class BasePlusCommissionEmployee extends CommissionEmployee {
	private double baseSalary; // base salary per week

	// constructor
	public BasePlusCommissionEmployee(String firstName, String lastName, String socialSecurityNumber, int day,
			int month, int year, double grossSales, double commissionRate, double baseSalary) {
		super(firstName, lastName, socialSecurityNumber, day, month, year, grossSales, commissionRate);

		if (baseSalary < 0.0) // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// set base salary
	public void setBaseSalary(double baseSalary) {
		if (baseSalary < 0.0) // validate baseSalary
			throw new IllegalArgumentException("Base salary must be >= 0.0");

		this.baseSalary = baseSalary;
	}

	// return base salary
	public double getBaseSalary() {
		return baseSalary;
	}

	// calculate earnings; override method earnings in CommissionEmployee
	@Override
	public double earnings() {
		return getBaseSalary() + super.earnings();
	}

	// return String representation of BasePlusCommissionEmployee object
	@Override
	public String toString() {
		return String.format("%s %s%s: $%,.2f;%n", "base-salaried", super.toString(), "base salary", getBaseSalary());
	}
} // end class BasePlusCommissionEmployee