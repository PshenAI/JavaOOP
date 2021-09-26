package sample;

public class Runner {

	public static void main(String[] args) {

		Cat cat1 = new Cat("White", 5, "Velves'ka");

		Cat cat2 = new Cat();
		cat2.setColor("White");
		cat2.setName("Ves");
		cat2.setWeight(6);

		System.out.println(cat1);
		System.out.println(cat2);
	}

}
