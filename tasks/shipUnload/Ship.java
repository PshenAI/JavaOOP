package shipUnload;

public class Ship {

	private String name;
	private int cargo;

	public Ship(String name, int cargo) {
		super();
		this.name = name;
		this.cargo = cargo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCargo() {
		return cargo;
	}

	public void setCargo(int cargo) {
		this.cargo = cargo;
	}

	@Override
	public String toString() {
		return "Ship [cargo=" + cargo + "]";
	}

}