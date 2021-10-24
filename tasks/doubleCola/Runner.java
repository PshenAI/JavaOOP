package doubleCola;

import java.util.ArrayDeque;
import java.util.Deque;

public class Runner {

	public static void main(String[] args) {
		Deque<String> dq = new ArrayDeque<>();
		dq.add("Sheldon");
		dq.add("Leonard");
		dq.add("Volovitz");
		dq.add("Koothrappali");
		dq.add("Penny");
		System.out.println(dq);
		DoubleCola dc = new DoubleCola(dq);
		dc.drink();
	}

}
