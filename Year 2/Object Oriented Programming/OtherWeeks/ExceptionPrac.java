/*
  Write a Java program to demonstrate Try Catch syntax
  @author Shrey Mathur
 */
class ExceptionPrac {
	public static void main(String args[]) {
		int num1, num2;
		try {
			num1 = 0;
			num2 = 62 / num1;
			System.out.println(num2 + "\nEnd of try block");
		} catch (ArithmeticException e) {
			// This will execute if any Arithmatic exception in try block
			System.out.println("You should not divide by zero");
		} catch (Exception e) {
			// This is a generic exception handeler
			System.out.println("Exception Occured");
		}
	}
}
