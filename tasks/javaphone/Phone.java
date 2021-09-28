package javaphone;

public class Phone {
	private String model;
	private String number;
	private boolean registration = false;
	private Network net;

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

	public Network getNet() {
		return net;
	}

	public void setNet(Network net) {
		this.net = net;
	}

	public void registration(Network b) {
		net = b;
		b.registrate(this.number, this);
		this.registration = true;
		System.out.println("Registration succesful!");
	}

	public void outCall(String a) {
		if (this.net == null) {
			System.out.println("Your number is not registered in our network!");

		} else {
			for (int i = 0; i < net.numbers.length; i++) {
				if (a == net.numbers[i]) {
					Phone temp = net.phones[i];
					if (this.registration == false) {

					} else {
						temp.inCall(this.number);
						break;
					}
				}
				if (i == net.numbers.length - 1) {
					System.out.println("The number you're trying to call is not registered in our network!");
				}
			}
		}

	}

	public void inCall(String a) {
		System.out.println(this.model + ", you've got incoming call from: " + a + "!");
	}

	public String toString() {
		return "Phone [model=" + model + ", number=" + number + "]";
	}

}
