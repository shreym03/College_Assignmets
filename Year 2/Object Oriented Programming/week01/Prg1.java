/*
  WAP to print the area of a room given lenght and breadth
  27/8/17
  @author Shrey Mathur
*/

class Prg1 {
	double length;
	double breadth;

	Prg1() {
		length = 1.0;
		breadth = 1.0;
	}

	void getdata(double x, double y) {
		length = x;
		breadth = y;
	}

	double getArea() {
		return length * breadth;
	}

	public static void main(String args[]) {
		Prg1 room = new Prg1();
		room.getdata(12.3, 14.2);
		double area = room.getArea();
		System.out.println("\nThe area of the room is " + area);
	}
}
