import java.util.*;

interface movable {
	public void move(String newPos);
}

abstract class ChessPiece implements movable {
	String name;
	String color;
	String curPos;

	public ChessPiece(String n, String c, String pos) {
		this.name = n;
		this.color = c;
		this.curPos = pos;
	}
}

class King extends ChessPiece {
	public King(String n, String c, String pos) {
		super(n, c, pos);
	}

	public void move(String newPos) {
		System.out.println(this.color + " King is moving from " + this.curPos + " to " + newPos);
		this.curPos = newPos;
	}
}

class Queen extends ChessPiece {
	public Queen(String n, String c, String pos) {
		super(n, c, pos);
	}

	public move(String newPos) {
		System.out.println(this.color+" Queen is moving from "+this.curPos+" to "+newPos);
		this.curPos=newPos;
	}
}

class Pawn extends ChessPiece {
	public Pawn(String n, String c, String pos) {
		super(n, c, pos);
	}

	public void move(String newPos) {
		System.out.println(this.color + " Pawn is moving from " + this.curPos + "to " + newPos);
		this.curPos = newPos;
	}
}

class ChessBoard {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<ChessPiece> al = new ArrayList<ChessPiece>();
		King bk = new King("bk", "Black", "f8");
		al.add(bk);
		sc.close();
	}
}
