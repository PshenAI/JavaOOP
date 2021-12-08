package collectors;

import java.util.List;
import java.util.Map;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Runner {

	public static void main(String[] args) {
//
//		*******************************************************************************************************************************	
//		** Task1
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Function<Integer, String> keyMapper = a -> a % 2 == 0 ? "even" : "odd";
		Function<Integer, String> valueMapper = a -> String.valueOf(a);

		BinaryOperator<String> merger = (a, b) -> a + "; " + b;

		Map<String, String> result = nums.stream().collect(Collectors.toMap(keyMapper, valueMapper, merger));

		System.out.println("Even: " + result.get("even") + " ::: Odd: " + result.get("odd"));

//*******************************************************************************************************************************	
		// ** Task2
//		File fold = new File("F:\\Samsung S8\\DCIM");
//		File[] foldArr = fold.listFiles();
//
//		Function<File, String> classifier = a -> {
//			long size = a.length();
//			if (size > 100_000_000) {
//				return "Big";
//			} else if (size > 10_000_000) {
//				return "Medium";
//			} else {
//				return "Small";
//			}
//		};
//
//		Map<String, List<File>> result = Arrays.stream(foldArr).collect(Collectors.groupingBy(classifier));
//
//		System.out.println(result);

	}

}
