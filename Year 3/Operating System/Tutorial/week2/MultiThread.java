/*
  Write a Java program to show a multiThread process
  
  @author Shrey Mathur
 */
public class MultiThread implements Runnable {
	int numerator, denomintaor, result;
	String ThreadName;

	public MultiThread(String name) {
		ThreadName = name;
	}

	public static void main(String[] args) throws Exception {
		MultiThread object1 = new MultiThread("Bob");
		Thread num = new Thread(object1);
		MultiThread object2 = new MultiThread("Alice");
		Thread den = new Thread(object2);
		num.start();
		den.start();
		int finalresult = (object1.numerator) / (object2.denomintaor);
		System.out.println("Final Result is " + finalresult);
	}

	public void run() {
		if (this.ThreadName.equals("Bob")) {
			this.numerator = 5 * 7 * 8;
			System.out.println(ThreadName + numerator);
		}
		try {
			if (this.ThreadName.equals("Alice")) {
				this.denomintaor = 5 * 8;
				System.out.println(ThreadName + denomintaor);
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			System.out.println("Interupted Excection Occured\n" + e);
		}
	}
}
