
/*
  Write a Java program to implement a Queue data structure using Linked List
  
  @author Shrey Mathur
 */
class Node {
	private int data;
	private Node next;

	public Node(int d, Node nxt) {
		data = d;
		next = nxt;
	}

	public int getData() {
		return data;
	}

	public void setData(int d) {
		data = d;
	}

	public Node getLink() {
		return next;
	}

	public void setLink(Node n) {
		next = n;
	}
}

class LLQueue {
	Node front, rear;
	int size;
	static final int max = 50;

	LLQueue() {
		front = null;
		rear = null;
		size = 0;
	}

	boolean isEmpty() {
		return (size == 0);
	}

	boolean isFull() {
		return (size == max);
	}

	void getSize() {
		System.out.println("The Size of Queue is " + size);
	}

	void enqueue(int data) {
		Node newnode = new Node(data, null);
		if (isFull())
			System.out.println("Queue is full");
		else if (isEmpty()) {
			front = newnode;
			rear = newnode;
			System.out.println(data + " is enqueued");
			size++;
		} else {
			rear.setLink(newnode);
			rear = rear.getLink();
			System.out.println(data + " is enqueued");
			size++;
		}
		getSize();
	}

	void dequeue() {
		if (isEmpty())
			System.out.println("Queue is empty");
		else {
			Node ptr = front;
			front = ptr.getLink();
			size--;
			System.out.println(ptr.getData() + " is dequeued");
		}
		getSize();
	}

	void display() {
		if (isEmpty())
			System.out.println("The Queue is empty");
		else {
			System.out.println("The queue contains:");
			Node ptr = front;
			while (ptr != null) {
				System.out.print(ptr.getData() + " ");
				ptr = ptr.getLink();
			}
			System.out.println();
		}
		getSize();
	}

	public static void main(String[] args) {
		LLQueue q = new LLQueue();
		q.display();
		q.enqueue(10);
		q.enqueue(20);
		q.enqueue(30);
		q.display();
		q.dequeue();
	}
}
