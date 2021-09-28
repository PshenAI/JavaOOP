package javaphone;

import java.util.Arrays;

public class Network {
	private String name = "Javafone";
	protected String[] numbers = new String[0];
	protected Phone[] phones = new Phone[0];

	public Network(String name, String[] numbers) {
		super();
		this.name = name;
		this.numbers = numbers;
	}

	public Network() {
		super();
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
