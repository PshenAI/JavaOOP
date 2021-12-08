package function;

import java.util.function.Function;

public class Runner2 {

	public static void main(String[] args) {
		String test = "CoronaViolet";
		char[] consonants = { 'b', 'c', 'd', 'f', 'g', 'h', 'j', 'k', 'l', 'm', 'n', 'p', 'q', 'r', 's', 't', 'v', 'w',
				'x', 'y', 'z' };
		Function<String, Integer> f1 = word -> {
			char[] letters = word.toLowerCase().toCharArray();
			int temp = 0;
			for (char letter : letters) {
				for (int i = 0; i < consonants.length; i++) {
					if (letter == consonants[i]) {
						temp++;
					}
				}
			}
			return temp;
		};
		System.out.println(f1.apply(test));

	}

}
