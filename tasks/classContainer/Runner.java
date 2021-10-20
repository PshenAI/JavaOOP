package classContainer;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {

		Object[] test = { 1, 2.5, "Pluto", true };

		ClassContainer cc = new ClassContainer(test);
		System.out.println(Arrays.toString(cc.getContainer()));

		cc.push(35);
		System.out.println(Arrays.toString(cc.getContainer()));

		System.out.println(cc.pop());

		System.out.println(cc.peek());
		System.out.println(Arrays.toString(cc.getContainer()));

	}

}
