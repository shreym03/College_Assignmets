import java.util.Scanner;

class Node {
	private Node parent;
	private Node LeftChild;
	private Node RightChild;
	private int value;

	/**
	 * Constructor to create a parent Node
	 * 
	 * @param v Value stored in Node
	 */
	public Node(int v) {
		this.value = v;
		this.RightChild = null;
		this.LeftChild = null;
	}

	/**
	 * Constructor to create Node with Parent
	 * 
	 * @param v Value stored in Node
	 * @param p Parent of the Node
	 */
	public Node(int v, Node p) {
		this.value = v;
		this.parent = p;
		this.LeftChild = null;
		this.RightChild = null;
	}

	/**
	 * Constructor to create Node with Parent, Left Child and Right Child
	 * 
	 * @param v  Value stored in Node
	 * @param p  Parent of the Node
	 * @param LC Left Child of the Node
	 * @param RC Right Child of the Node
	 */
	public Node(int v, Node p, Node LC, Node RC) {
		this.value = v;
		this.parent = p;
		this.LeftChild = LC;
		this.RightChild = RC;
	}

	void setLC(Node n) {
		this.LeftChild = n;
	}

	void setRC(Node n) {
		this.RightChild = n;
	}

	void setP(Node n) {
		this.parent = n;
	}

	void setValue(int v) {
		this.value = v;
	}

	Node getLC() {
		return this.LeftChild;
	}

	Node getRC() {
		return this.RightChild;
	}

	Node getP() {
		return this.parent;
	}

	int getValue() {
		return this.value;
	}

	/**
	 * Method to check if the Node has any children
	 * 
	 * @return {@code true} if does not, {@code false} if it does
	 */
	boolean isExternal() {
		if ((this.LeftChild == null) && (this.RightChild == null))
			return true;
		return false;
	}
}

class BST {
	Node root;
	int size = 0;

	/**
	 * Recursive method to print values in tree in Preorder mode
	 * 
	 * @param w Node to be traversed
	 */
	void PreOrder(Node w) {
		if (w != null && !w.isExternal()) {
			System.out.print(w.getValue() + " ");
			Node l = w.getLC();
			PreOrder(l);
			Node r = w.getRC();
			PreOrder(r);
		}
	}

	/**
	 * Recursive method to print values in tree in Postorder mode
	 * 
	 * @param w Node to be traversed
	 */
	void PostOrder(Node w) {
		if (w != null && !w.isExternal()) {
			Node l = w.getLC();
			PostOrder(l);
			Node r = w.getRC();
			PostOrder(r);
			System.out.print(w.getValue() + " ");
		}
	}

	/**
	 * Recursive method to print values in tree in Inorder mode
	 * 
	 * @param w Node to be traversed
	 */
	void InOrder(Node w) {
		if (w != null && !w.isExternal()) {
			Node l = w.getLC();
			InOrder(l);

			System.out.print(w.getValue() + " ");
			Node r = w.getRC();
			InOrder(r);
		}
	}

	/**
	 * Method to find the Node's Sibling (Node that has same parent)
	 * 
	 * @param v Node to be checked
	 * @return {@code null} if unavailable. Sibling of the node otherwise
	 */
	Node Sibling(Node v) {
		if (isRoot(v)) {
			System.out.println("Error : Root does not have a sibling");
			return null;
		}
		Node p = v.getP();
		if (p.getLC() == v) {
			if (p.getRC() != null)
				return p.getRC();
			System.out.println("Error : Node does not have a sibling");
			return null;
		}
		if (p.getLC() != null)
			return p.getLC();
		System.out.println("Error : Node does not have a sibling");
		return null;
	}

	/**
	 * Checking if Node is the root of BST or not
	 * 
	 * @param v Node in question
	 * @return {@code true} or {@code false}
	 */
	boolean isRoot(Node v) {
		if (this.root == v)
			return true;
		else
			return false;
	}

	/**
	 * Expand childless Node
	 * 
	 * @param w Node to be expanded
	 * @param k value to be added to it
	 */
	void expandExternal(Node w, int k) {
		if (w == null) {
			w = new Node(k);
			this.root = w;
		}

		w.setLC(new Node(-1, w));
		w.setRC(new Node(-1, w));

		w.setValue(k);
	}

	/**
	 * Recursive method to Search for a node in a BST
	 * 
	 * @param k value to be searched
	 * @param w Node beng searched
	 * @return Node that has the value
	 */
	Node Search(int k, Node w) {
		Node x = new Node(-1);

		if (w.isExternal()) {
			return w;
		}

		if (k < w.getValue()) {
			System.out.println(k + "<" + w.getValue());
			x = Search(k, w.getLC());
		} else if (k == w.getValue()) {
			x = w;
		} else if (k > w.getValue()) {
			System.out.println(k + ">" + w.getValue());
			x = Search(k, w.getRC());
		}
		return x;
	}

	/**
	 * Recursive method tp insert a new node
	 * 
	 * @param k Vakue of Node
	 * @param v Node to start at
	 * @return Next Node to traverse to. {@code null} otherwise
	 */
	Node Insert(int k, Node v) {
		this.size++;
		if (v == null) {
			expandExternal(v, k);
		} else {
			Node w = Search(k, v);
			if (!w.isExternal()) {
				return Insert(k, w.getLC());
			}
			expandExternal(w, k);
		}
		return null;
	}

	/**
	 * Remove the Parent node of the Extenal Node
	 * 
	 * @param c External Node
	 */
	void removeAboveExternal(Node c) {
		Node s = Sibling(c);
		Node x = c.getP();
		Node p = x.getP();
		if (p != null) {
			if (p.getLC() == x)
				p.setLC(s);
			else if (p.getRC() == x)
				p.setRC(s);
		} else {
			this.root = s;
		}
		s.setP(p);
	}

	/**
	 * Delete a Node from the Binary Search Tree
	 * 
	 * @param k value to be deleted
	 */
	void Delete(int k) {
		Node x = Search(k, this.root);
		if (x.getValue() == -1)
			System.out.println("Error : Element does not exist");
		else {
			if (x.getLC().isExternal())
				removeAboveExternal(x.getLC());
			else if (x.getRC().isExternal())
				removeAboveExternal(x.getRC());
			else {
				Node y = x.getRC();
				while (!y.getLC().isExternal())
					y = y.getLC();
				x.setValue(y.getValue());
				if (y.getP() != x) {
					Node p = y.getP();
					p.setLC(new Node(-1, p));
				} else
					x.setRC(new Node(-1, x));
			}
		}
		this.size--;
	}

}

class BSTUser {
	static Scanner sc = new Scanner(System.in);

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void pak() {
		System.out.println("Press any key to continue!");
		sc.nextLine();
	}

	public static void main(String args[]) {
		BST tree = new BST();
		int opt, k;
		do {
			clearScreen();
			System.out.println("Menu:");
			System.out.println("Press 1 to Insert an element");
			System.out.println("Press 2 to Search for an element");
			System.out.println("Press 3 to Delete an element");
			System.out.println("Press 4 for Pre-order Traversal");
			System.out.println("Press 5 for In-order Traversal");
			System.out.println("Press 6 for Post-order Traversal");
			System.out.println("Press 0 to exit");
			System.out.print("Enter option: ");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.print("Enter key to be inserted: ");
				k = sc.nextInt();
				tree.Insert(k, tree.root);
				break;
			case 2:
				System.out.print("Enter key to be search: ");
				k = sc.nextInt();
				Node x = tree.Search(k, tree.root);
				if (x.isExternal())
					System.out.println("Element not found");
				else
					System.out.println("Element found");
				break;
			case 3:
				System.out.print("Enter key to be deleted: ");
				k = sc.nextInt();
				tree.Delete(k);
				break;
			case 4:
				tree.PreOrder(tree.root);
				System.out.println();
				break;
			case 5:
				tree.InOrder(tree.root);
				System.out.println();
				break;
			case 6:
				tree.PostOrder(tree.root);
				System.out.println();
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid option");
				break;
			}
			pak();
		} while (opt != 0);
		sc.close();
	}
}
