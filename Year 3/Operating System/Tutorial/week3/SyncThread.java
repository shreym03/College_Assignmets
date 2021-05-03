/*
  Create a class called Demo and create two threads named Bob and Mary.
   Create a class Parenthesis with Display method.
   The Display method should accept name of the thread as parameter and display (Bob) when called from Bob Thread and display (Mary) when called from Mary Thread.
   Lack of synchronization will * be observed.
   Synchronization using semaphore has to be done in the class Parenthesis.
 
	 @author Shrey Mathur
 */
class MyThread implements Runnable {
	String threadStr;
	Parenthesis threadPrnth;
	Thread thread;

	public MyThread(Parenthesis p, String S) {
		threadPrnth = p;
		threadStr = S;
		thread = new Thread(this);
		thread.start();
	}

	public void run() {
		threadPrnth.display(threadStr);
	}
}

class Parenthesis {
	void display(String string) {
		System.out.println("(" + string + ")");
	}
}

class SyncThread {
	public static void main(String[] args) {
		Parenthesis bob = new Parenthesis();
		Parenthesis mary = new Parenthesis();
		MyThread Bob = new MyThread(bob, "Bob");
		MyThread Mary = new MyThread(mary, "Mary");
	}
}