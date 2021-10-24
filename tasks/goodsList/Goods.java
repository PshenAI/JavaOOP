package goodsList;

public class Goods {
	private double price;
	private String description;
	private double size;

	public Goods(double price, String description, double size) {
		super();
		this.price = price;
		this.description = description;
		this.size = size;
	}

	public Goods() {
		super();
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getMass() {
		return size;
	}

	public void setMass(double size) {
		this.size = size;
	}

	public void sellNotif() {
		System.out.println(
				"You've just bought " + this.description + " for " + this.price + " $. Thank you for choosing us!");
	}

	public String toString() {
		return "Chosen good is: " + description + ", size: " + size + "MB, price: " + price + "$.";
	}
}
