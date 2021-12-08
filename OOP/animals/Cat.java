package com.gmail.antonvoloshyn25;

public class Cat extends Animal {
	private String name;

	public Cat(String ration, String color, int weight, String name) {
		super(ration, color, weight);
		this.name = name;
	}

	public Cat(String ration, String color, int weight) {
		super(ration, color, weight);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getVoice() {
		return "meow.";
	}

	@Override
	public void eat() {
		System.out.println("I eat " + this.getRation() + ".");
	}

	@Override
	public void sleep() {
		System.out.println("Zzz");
	}

	@Override
	public String toString() {
		return "cat " + name + ", " + super.toString();
	}
}
