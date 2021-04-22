/*
	WAP to store Employee details for n number of Employees 
	with SSN, name, and Age.
  Display Emplyee details
  
  @since 17/6/17
 */
class EncapsulationDemo {
	private int ssn;
	private String empName;
	private int empAge;

	// Getter method
	public int getSSN() {
		return ssn;
	}

	public int getAge() {
		return empAge;
	}

	public String getName() {
		return empName;
	}

	// Setter Method
	public void setAge(int newValue) {
		empAge = newValue;
	}

	public void setName(String newValue) {
		empName = newValue;
	}

	public void setSSN(int newValue) {
		ssn = newValue;
	}
}

public class Employee {
	public static void main(String args[]) {
		EncapsulationDemo obj = new EncapsulationDemo();
		obj.setName("Shrey");
		obj.setAge(20);
		obj.setSSN(262);
		System.out.println("Employee SSN: " + obj.getSSN());
		System.out.println("Employee Name: " + obj.getName());
		System.out.println("Employee Age: " + obj.getAge());
	}
}
