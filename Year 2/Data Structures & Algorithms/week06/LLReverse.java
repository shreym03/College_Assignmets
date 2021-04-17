/*
  Write a Java program to write find the reverse of the elements of Linked List using recursive function
  
  @author Shrey Mathur
 */
class Node {
	int data;
	Node next;

	/**
	 * Constructor to initialise the Node with data
	 * 
	 * @param d data of Node
	 */
	Node(int d) {
		data = d;
		next = null;
	}
}

class LLReverse {
	Node start;
	int size;

	LLReverse() {
		start = null;
		size = 0;
	}

	/**
	 * Method to insert data into the linked List
	 * 
	 * @param d Data to be inputted
	 */
	void insert(int d) {
		Node newNode = new Node(d);
		if (size == 0)
			start = newNode;
		else {
			Node ptr = start;
			while (ptr.next != null)
				ptr = ptr.next;
			ptr.next = newNode;
		}
		System.out.println(d + " is inserted");
		size++;
	}

	/** Print the data in the Linked List */
	void printList() {
		/* Starting point */
		Node ptr = start;
		while (ptr != null) {
			System.out.print(ptr.data + " ");
			ptr = ptr.next;
		}
		System.out.println();
	}

	/**
	 * Method to reverse the Linked List
	 * 
	 * @param curr Start Node
	 * @param prev End Node
	 * @return null
	 */
	Node reverse(Node curr, Node prev) {
		// If last node mark it head
		if (curr.next == null) {
			start = curr;
			// Update next to prev node
			curr.next = prev;
			return null;
		}

		/* Save curr->next node for recursive call */
		Node next1 = curr.next;

		/* and update next .. */
		curr.next = prev;

		reverse(next1, curr);
		return start;
	}

	public static void main(String[] args) {
		LLReverse ll = new LLReverse();
		ll.insert(1);
		ll.insert(2);
		ll.insert(3);
		ll.insert(4);
		ll.insert(5);

		System.out.println("The original linked list: ");
		ll.printList();
		ll.start = ll.reverse(ll.start, null);
		System.out.println("\nThe list in reverse order is: ");
		ll.printList();
	}
}
