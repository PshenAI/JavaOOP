package com.gmail.antonvoloshyn25;

public class Runner {

	public static void main(String[] args) {
		Veterinarian vet = new Veterinarian("Velvet");
		Cat catto = new Cat("Cat food, fish", "Black", 6, "Mao");
		Dog doge = new Dog("Dog food, meat", "Brown", 6, "Moby");

		vet.treatment(doge);
		vet.treatment(catto);

	}

}
