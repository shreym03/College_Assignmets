
/*
  Write a Java program to create a Double linked List
  
  @author Shrey Mathur
 */
class Node {
	int data;
	Node next;
	Node prev;

	Node(int n) {
		data = n;
		next = null;
		prev = null;
	}
}

class DoubleLL {
	Node start, end;
	int size;

	DoubleLL() {
		start = null;
		end = null;
		size = 0;
	}

	boolean isEmpty() {
		return (size == 0);
	}

	void insertFirst(int n) {
		Node newnode = new Node(n);
		if (isEmpty()) {
			start = newnode;
			end = newnode;
		} else {
			newnode.next = start;
			start.prev = newnode;
			start = newnode;
		}
		System.out.println(n + " is inserted in the front");
		size++;
	}

	void insertLast(int n) {
		Node newnode = new Node(n);
		if (isEmpty()) {
			start = newnode;
			end = newnode;
		} else {
			newnode.prev = end;
			end.next = newnode;
			end = newnode;
		}
		System.out.println(n + " is inserted at the end");
		size++;
	}

	void insertAfter(int p, int n) {
		Node newnode = new Node(n);
		Node ptr = start;
		if (p > size || p < 1)
			System.out.println("Position doesn't exist");
		else {
			while (p - 1 > 0) {
				ptr = ptr.next;
				p--;
			}
			newnode.next = ptr.next;
			(ptr.next).prev = newnode;
			ptr.next = newnode;
			newnode.prev = ptr;
			size++;
			System.out.println(n + " is inserted after " + ptr.data);
		}

	}

	void removeAt(int p) {
		Node ptr = start;
		if (isEmpty())
			System.out.println("List is empty");
		else if (p > size || p < 1)
			System.out.println("Position doesn't exist");
		else {
			for (int i = 1; i < p; i++)
				ptr = ptr.next;
			int n = ptr.data;
			(ptr.prev).next = ptr.next;
			(ptr.next).prev = ptr.prev;
			ptr.next = null;
			ptr.prev = null;
			System.out.println(n + " is removed");
			size--;
		}
	}

	void getSize() {
		System.out.println("The size of list is " + size);
	}

	void PrintBckwrd() {
		if (isEmpty())
			System.out.println("List is empty");
		else {
			Node ptr = end;
			System.out.println("List in reverse order is:");
			while (ptr != null) {
				System.out.print(ptr.data + " ");
				ptr = ptr.prev;
			}
			System.out.println();
		}
	}

	void PrintFrwd() {
		if (isEmpty())
			System.out.println("List is empty");
		else {
			Node ptr = start;
			System.out.println("List is:");
			while (ptr != null) {
				System.out.print(ptr.data + " ");
				ptr = ptr.next;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		DoubleLL dll = new DoubleLL();
		dll.insertFirst(20);
		dll.insertFirst(10);
		dll.insertLast(40);
		dll.insertLast(50);
		dll.insertAfter(2, 30);
		dll.insertAfter(3, 60);
		dll.removeAt(4);
		dll.PrintFrwd();
		dll.PrintBckwrd();
		dll.getSize();
	}
}
