package reduce;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
//*******************************************************************************************************************************	
		// ** Task3
		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

		Integer num = nums.stream().reduce((a, b) -> a > b ? a : b).get();

		System.out.println(num);
	}
//*******************************************************************************************************************************	
	// ** Task2
//	List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//	Integer product = nums.stream().reduce((a, b) -> a * b).get();
//	System.out.println(product);
//*******************************************************************************************************************************	
	// ** Task1
//	String text = "Forever doesn't mean it, for real";
//	String[] textArr = text.split(" ");
//
//	Optional<Integer> opt = Arrays.stream(textArr).filter(a -> a.length() > 4).map(a -> a.length())
//			.reduce((a, b) -> a + b);

}
