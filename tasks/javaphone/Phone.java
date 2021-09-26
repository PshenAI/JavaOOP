package javaphone;

public class Phone {
	private String model;
	private String number;
	private boolean registration = false;

	public Phone(String model, String number) {
		super();
		this.model = model;
		this.number = number;
	}

	public Phone() {
		super();
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public boolean isRegistration() {
		return registration;
	}

	public void setRegistration(boolean registration) {
		this.registration = registration;
	}

	public void registration(Network b) {
		b.registrate(this.number);
		this.registration = true;
		System.out.println("Registration succesful!");
	}

	public void outCall(Phone a) {
		if (this.registration == false) {
			System.out.println("Your number is not registered in our network!");
		}
		if (a.registration == false) {
			System.out.println("The numbew you're trying to call is not registered in out network!");
		}
		if (a.registration == true && this.registration == true) {
			this.inCall(this);
		}
	}

	public void inCall(Phone a) {
		System.out.println("You've got incoming call from: " + a.number + "!");
	}

	public String toString() {
		return "Phone [model=" + model + ", number=" + number + "]";
	}

}
