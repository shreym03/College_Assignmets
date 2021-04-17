
/*
  Write a Java program to create a Stack data structure that pushes and pops
  data
  
  @author Shrey Mathur
 */
class Stack {
	static final int max = 50;
	int top;
	int a[] = new int[max];

	Stack() {
		top = -1;
	}

	boolean isEmpty() {
		return (top < 0);
	}

	void push(int x) {
		if (top == max) {
			System.out.println("The stack is full");
		} else {
			top++;
			a[top] = x;
			System.out.println(x + " is Pushed");
		}
	}

	void pop() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
		} else {
			int x = a[top];
			System.out.println(x + " is popped from the Stack");
		}
	}

	public static void main(String[] args) {
		Stack st = new Stack();
		st.push(10);
		st.push(20);
		st.push(30);
		st.pop();
	}

}
