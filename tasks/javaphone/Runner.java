package javaphone;

public class Runner {

	public static void main(String[] args) {
		Network nw = new Network();

		Phone ph1 = new Phone("Nokia-3310", "+38-099-101-11-22");
		ph1.registration(nw);

		Phone ph2 = new Phone("Samsung S8", "+81-077-444-33-22");
		ph2.registration(nw);
		System.out.println(nw.toString());

		Phone ph3 = new Phone("Iphone X", "+811-035-211-77-93");

		ph2.outCall(ph1);
		ph3.outCall(ph1);
		ph1.outCall(ph3);
	}

}
