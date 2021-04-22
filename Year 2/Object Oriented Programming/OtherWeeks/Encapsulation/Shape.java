/*15/10/17*/
class Shape {
	private String color;
	private boolean filled;

	public Shape() {
		color = "red";
		filled = true;
	}

	public Shape(String clr, boolean fld) {
		color = clr;
		filled = fld;
	}

	public String getColor() {
		return this.color;
	}

	public void setColor(String clr) {
		this.color = clr;
	}

	public boolean isFilled() {
		return this.filled;
	}

	public void setFilled(boolean fld) {
		this.filled = fld;
	}

	public String toString() {
		String result;
		String fld;
		if (this.filled == true)
			fld = "filled";
		else
			fld = "not filled";
		result = "A Shape that is of color " + this.color + " and it is " + fld;
		return result;
	}
}
