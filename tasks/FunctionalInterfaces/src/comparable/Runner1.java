package comparable;

public class Runner1 {

	public static void main(String[] args) {
//		Rectangle r1 = new Rectangle(4, 5);
//		Rectangle r2 = new Rectangle(5, 4);
//		Rectangle r3 = new Rectangle(2, 7);
//
//		Rectangle[] rArr = { r1, r2, r3 };
//		Arrays.sort(rArr);
//		System.out.println(Arrays.toString(rArr));
//		System.out.println(max(rArr));

		Cat cat1 = new Cat("Acropolis", 7);
		Cat cat2 = new Cat("Bitanga", 12);
		Cat cat3 = new Cat("Bitanga", 8);
		System.out.println(cat3.compareTo(cat2));
	}

	public static <T extends Comparable<T>> T max(T[] array) {
		if (array == null) {
			throw new NullPointerException();
		}
		T max = array[0];
		for (T t : array) {
			if (max.compareTo(t) > 0) {
				max = t;
			}
		}
		return max;
	}

}
