import java.util.LinkedList;

class LinkList {
	public static void main(String args[]) {
		LinkedList<String> ll = new LinkedList<String>();
		ll.add("Teddy");
		ll.add("Chocolate");
		ll.add("Dentist");
		ll.addFirst("Sachin");
		for (String name : ll)
			System.out.println(name);
	}
}
