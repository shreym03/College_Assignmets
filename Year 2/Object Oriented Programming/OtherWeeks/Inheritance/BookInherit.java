/*
  Write a Java program to demonstrate intheritance with Animal Classes
  @author Shrey Mathur
 */
class Info {
	private String name;
	private String author;
	private int year;

	Info(String n, String a, int y) {
		this.name = n;
		this.author = a;
		this.year = y;
	}

	public void display_name() {
		System.out.println("Title: " + this.name);
	}

	public void display_author() {
		System.out.println("Author: " + this.author);
	}

	public void display_year() {
		System.out.println("Year: " + this.year);
	}
}

class Book extends Info {
	int categorycode;

	Book(String n, String a, int y, int c) {
		super(n, a, y);
		this.categorycode = c;
	}

	public void display_book() {
		display_name();
		display_author();
		display_year();
		System.out.println("Category code:" + this.categorycode);
		switch (categorycode) {
		case 1:
			System.out.println("Category: Philosophy");
			break;
		case 2:
			System.out.println("Category: Novel-Fiction");
			break;
		case 3:
			System.out.println("Category: Autobiography");
		}
		System.out.println();
	}

}

class BookInherit {
	public static void main(String[] args) {
		Book b1 = new Book("The Firm", "John Grisham", 1991, 2);
		Book b2 = new Book("My Experiment with Truth", "M K Gandhi", 1925, 3);
		Book b3 = new Book("By Parallel Reasoning", "Paul Bartha", 2010, 1);
		b1.display_book();
		b2.display_book();
		b3.display_book();
	}
}
