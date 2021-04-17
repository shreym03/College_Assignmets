
/* Write a Java program to produce an AVL tree programme
  @author Shrey Mathur
 */
import java.util.Scanner;

class Node {
	int key, height;
	Node left, right;

	Node(int d) {
		key = d;
		height = 1;
		left = null;
		right = null;
	}
}

class AVLTree {
	Node root;

	/** Find the max of two values */
	int max(int a, int b) {
		return (a > b) ? a : b;
	}

	/**
	 * Re-adjust heiight of Node
	 * 
	 * @param n selected Node
	 */
	int setHeight(Node n) {
		if (n == null)
			return 0;
		return 1 + max(setHeight(n.left), setHeight(n.right));
	}

	/**
	 * @return the height of the tree from the Node
	 * @param N Selected Node
	 */
	int getHeight(Node N) {
		if (N == null)
			return 0;
		return N.height;
	}

	/**
	 * 
	 * Method to right Rotate a subtree
	 * 
	 * @param y root of Subtree
	 */
	Node rightRotate(Node y) {
		Node x = y.left;
		Node T2 = x.right;

		x.right = y;
		y.left = T2;

		y.height = setHeight(y);
		x.height = setHeight(x);

		return x;
	}

	/**
	 * Method to left rotate a subtree
	 * 
	 * @param x Root of Subtree
	 */
	Node leftRotate(Node x) {
		Node y = x.right;
		Node T2 = y.left;

		y.left = x;
		x.right = T2;

		x.height = max(getHeight(x.left), getHeight(x.right)) + 1;
		y.height = max(getHeight(y.left), getHeight(y.right)) + 1;

		return y;
	}

	int getBalance(Node N) {
		if (N == null)
			return 0;
		return getHeight(N.left) - getHeight(N.right);
	}

	/**
	 * Insert new element to a Node
	 * 
	 * @param node Node to attatch element
	 * @param ele  wlwmwnt tp be added
	 * @return
	 */
	Node insert(Node node, int ele) {
		if (node == null)
			return (new Node(ele));

		if (ele < node.key)
			node.left = insert(node.left, ele);
		else if (ele > node.key)
			node.right = insert(node.right, ele);
		else
			return node;

		node.height = 1 + max(getHeight(node.left), getHeight(node.right));

		int balance = getBalance(node);

		if (balance > 1) {
			if (ele > node.left.key)
				node.left = leftRotate(node.left);
			if (ele != node.left.key)
				return rightRotate(node);
		}
		if (balance < -1) {
			if (ele < node.right.key)
				node.right = rightRotate(node.right);
			if (ele != node.right.key)
				return leftRotate(node);
		}
		return node;
	}

	/**
	 * Method too print the pre-order traversal of the tree
	 * 
	 * @param node Starting Node
	 */
	void PreOrder(Node node) {
		if (node != null) {
			System.out.print(node.key + " ");
			PreOrder(node.left);
			PreOrder(node.right);
		}
	}
}

class AVLUser {
	static Scanner sc = new Scanner(System.in);

	public static void clearScreen() {
		System.out.print("\033[H\033[2J");
		System.out.flush();
	}

	public static void pak() {
		sc.nextLine();
		System.out.println("Press any key to continue!");
		sc.nextLine();
	}

	public static void main(String[] args) {
		AVLTree tree = new AVLTree();
		int opt;
		do {
			clearScreen();
			System.out.println("Menu: ");
			System.out.println("1. Insert into AVL tree");
			System.out.println("2. Preorder traversal");
			System.out.println("0. Exit");
			System.out.println("Enter your choice: ");
			opt = sc.nextInt();

			switch (opt) {
			case 1:
				System.out.println("\nEnter value to be inserted in AVL tree ");
				tree.root = tree.insert(tree.root, sc.nextInt());
				break;
			case 2:
				System.out.println("\nThe preorder traversal of the avl tree is: ");
				tree.PreOrder(tree.root);
				break;
			case 0:
				break;
			default:
				System.out.println("Invalid Option ");
				break;
			}
			pak();
		} while (opt != 0);
		System.out.println("Programme Terminated");
	}
}
