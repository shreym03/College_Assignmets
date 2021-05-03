/*
  Write a Java program to demonstrate Threads
  @author Shrey Mathur
 */
class MyThread implements Runnable {
	Thread t;
	String disp;

	public MyThread(String display) {
		disp = display;
		t = new Thread(this);
		t.start();
	}

	public void run() {
		int i = 0;
		for (i = 0; i < 5; i++) {
			try {
				String temp = this.disp;
				if (temp.equals("Bob"))
					Thread.sleep(40);
				else
					Thread.sleep(20);
			} catch (InterruptedException e) {
				System.out.println("Interrupted");
			}
			System.out.println(this.disp);
		}
	}
}

public class ThreadDemo {
	public static void main(String[] args) {
		MyThread n1 = new MyThread("Bob");
		MyThread n2 = new MyThread("Alice");
	}
}