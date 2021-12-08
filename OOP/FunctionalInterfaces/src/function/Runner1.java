package function;

import java.util.function.Function;
import java.util.function.Predicate;

public class Runner1 {

	public static void main(String[] args) {
		Integer[] array = { 5, 6, 7, 8, 9, 10 };

		Predicate<Integer> check = a -> {
			int temp = 0;
			for (int i = 1; i <= a; i++) {
				if (a % i == 0) {
					temp++;
				}
			}
			if (temp > 2) {
				return true;
			}
			return false;
		};

		Function<Integer[], Integer> f1 = numbers -> {
			int temp = 0;
			for (Integer number : numbers) {
				if (check.test(number) == false) {
					temp++;
				}
			}
			return temp;
		};
		System.out.println(f1.apply(array));

	}

}
