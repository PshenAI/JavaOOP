package javaphone;

import java.util.Arrays;

public class Network {
	private String name = "Javafone";
	private String[] numbers = new String[0];
	private Phone[] phones = new Phone[0];

	public Network(String name, String[] numbers, Phone[] phones) {
		super();
		this.name = name;
		this.numbers = numbers;
		this.phones = phones;
	}

	public Network() {
		super();
	}

	public Phone[] getPhones() {
		return phones;
	}

	public void setPhones(Phone[] phones) {
		this.phones = phones;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String[] getNumbers() {
		return numbers;
	}

	public void setNumbers(String[] numbers) {
		this.numbers = numbers;
	}

	public void registrate(String a, Phone b) {
		numbers = Arrays.copyOf(numbers, numbers.length + 1);
		numbers[numbers.length - 1] = a;
		phones = Arrays.copyOf(phones, phones.length + 1);
		phones[phones.length - 1] = b;
	}

	public String toString() {
		return "Our network is called " + name + ", we got such numbers registered: " + Arrays.toString(numbers) + ".";
	}

}
