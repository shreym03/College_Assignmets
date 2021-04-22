/*
  Write a Java program to demonstrate intheritance with Animal Classes
  @author Shrey Mathur
 */
class Animal {
	public Animal() {
		System.out.println("A new animal has been added");
	}

	public void sleep() {
		System.out.println("An animal sleeps...");
	}

	public void eat() {
		System.out.println("An Animal eats...");
	}
}

class Bird extends Animal {
	public void sleep() {
		System.out.println("The Bird sleeps in a nest");
	}

	public void eat() {
		System.out.println("The Bird eats worms");
	}

	public Bird() {
		super();
		System.out.println("A new Bird has been added");
	}
}

class AnimalInherit {
	public static void main(String[] args) {
		Animal a = new Animal();
		Bird b = new Bird();
		System.out.println();
		a.sleep();
		a.eat();
		b.sleep();
		b.eat();
	}
}
