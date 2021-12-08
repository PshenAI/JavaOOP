package binaryOp;

public class Runner0 {

	public static void main(String[] args) {

		// ** Task1
//		String test1 = "Vortexxx";
//		String test2 = "Climaxx";
//
//		Comparator<String> comp = (a, b) -> a.length() - b.length();
//
//		BinaryOperator<String> binOp = BinaryOperator.maxBy(comp);
//
//		System.out.println(binOp.apply(test1, test2));
	}

	// ** Task3
//	public static <T extends Comparable<T>> List<T> minList(List<T> a, List<T> b) {
//		T minA = a.get(0);
//		T minB = b.get(0);
//		;
//		for (T obj : a) {
//			if (obj.compareTo(minA) < 0) {
//				minA = obj;
//			}
//		}
//		for (T obj : b) {
//			if (obj.compareTo(minB) < 0) {
//				minB = obj;
//			}
//		}
//		if (minA.compareTo(minB) < 0) {
//			return a;
//		} else {
//			return b;
//		}
//	}

	// ** Task2
//	List<Integer> numbers1 = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//	List<Integer> numbers2 = List.of(1, 2, 4, 5, 7, 8);
//
//	BinaryOperator<List<Integer>> binOp = Runner0::sameNum;
//	System.out.println(binOp.apply(numbers1, numbers2));
//	public static List<Integer> sameNum(List<Integer> a, List<Integer> b) {
//		List<Integer> result = new ArrayList<>();
//		for (int i = 0; i < a.size(); i++) {
//			for (int j = 0; j < b.size(); j++) {
//				if (a.get(i) == b.get(j)) {
//					result.add(a.get(i));
//				}
//			}
//		}
//		return result;
//	}
}
