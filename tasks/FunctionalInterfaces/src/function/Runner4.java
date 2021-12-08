package function;

import java.util.Arrays;
import java.util.function.BiFunction;

public class Runner4 {

	public static void main(String[] args) {
		String test1 = "Corona Violet Prappa";
		String test2 = "Prappa Violet Based";
		BiFunction<String, String, String[]> uniWord = (s1, s2) -> {
			String temp = test1 + " " + test2;
			String[] arr = temp.split(" ");
			String resulto = "";
			for (int j = 0; j < arr.length; j++) {
				for (int i = 0; i < arr.length; i++) {
					if (i == j) {
						continue;
					}
					if (arr[j].equals(arr[i]) && resulto.contains(arr[i]) == false) {
						resulto += arr[j] + " ";
					}
				}
			}
			String[] result = resulto.split(" ");
			return result;
		};
		System.out.println(Arrays.toString(uniWord.apply(test1, test2)));

	}

}
