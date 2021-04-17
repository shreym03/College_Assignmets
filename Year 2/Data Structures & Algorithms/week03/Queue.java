
/*
  Write a Java program to create a queue datastructure to add and remoove data
  from it
  
  @author Shrey Mathur
 */
class Queue {
	int front, rear, size;
	static final int max = 50;
	int a[] = new int[max];

	Queue() {
		front = 0;
		rear = max - 1;
		size = 0;
	}

	boolean isFull() {
		return (size == max);
	}

	boolean isEmpty() {
		return (size == 0);
	}

	void enqueue(int x) {
		if (isFull())
			System.out.println("Queue is full");
		else {
			rear = (++rear) % max;
			a[rear] = x;
			size++;
			System.out.println(x + " is enqueued to Queue");
		}
	}

	void dequeue() {
		if (isEmpty())
			System.out.println("Queue is empty");
		else {
			int x = a[front++];
			System.out.println(x + " is dequeued from Queue");
			front %= max;
			size--;
		}
	}

	public static void main(String[] args) {
		Queue q = new Queue();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.dequeue();
	}
}
