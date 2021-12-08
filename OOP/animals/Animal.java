package com.gmail.antonvoloshyn25;

public class Animal {
	private String ration;
	private String color;
	private int weight;

	public Animal(String ration, String color, int weight) {
		super();
		this.ration = ration;
		this.color = color;
		this.weight = weight;
	}

	public Animal() {
		super();
	}

	public String getRation() {
		return ration;
	}

	public void setRation(String ration) {
		this.ration = ration;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public String getVoice() {
		return "One's voice";
	}

	public void eat() {
		System.out.println(this.getRation());
	}

	public void sleep() {
		System.out.println("Sleep sounds.");
	}

	@Override
	public String toString() {
		return "this one eats " + ration + ", is " + color + ", and weights " + weight + "kg.";
	}

}
