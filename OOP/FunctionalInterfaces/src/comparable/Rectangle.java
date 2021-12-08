package comparable;

public class Rectangle implements Comparable<Rectangle> {
	private int length;
	private int height;

	public Rectangle(int length, int height) {
		super();
		this.length = length;
		this.height = height;
	}

	public int getLenght() {
		return length;
	}

	public void setLenght(int length) {
		this.length = length;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public int compareTo(Rectangle o) {
		if (o == null) {
			throw new NullPointerException();
		}
		int sThis = length * height;
		int sO = o.getLenght() * o.getHeight();
		if (sThis > sO) {
			return 1;
		}
		if (sThis < sO) {
			return -1;
		}
		return 0;
	}

	@Override
	public String toString() {
		return "Rectangle [length=" + length + ", height=" + height + "]";
	}

}
