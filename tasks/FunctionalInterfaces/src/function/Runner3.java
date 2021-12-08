package function;

import java.util.function.Function;

public class Runner3 {

	public static void main(String[] args) {
		String test = "CoronaViolet";
		Function<String, Integer[]> f1 = word -> {
			char[] chars = word.toCharArray();
			int codes[] = new int[chars.length];
			for (int i = 0; i < chars.length; i++) {
				codes[i] = chars[i];
			}
			Integer[] temp = new Integer[codes.length];
			for (int i = 0; i < codes.length; i++) {
				temp[i] = codes[i];
			}
			return temp;
		};
		Function<Integer[], Integer> f2 = arr -> {
			Integer sum = 0;
			for (Integer num : arr) {
				sum += num;
			}
			return sum;
		};
		Function<String, Integer> f3 = f1.andThen(f2);
		System.out.println(f3.apply(test));

	}

}
