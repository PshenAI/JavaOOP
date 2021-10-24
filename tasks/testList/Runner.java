package testList;

import java.util.ArrayList;
import java.util.List;

public class Runner {

	public static void main(String[] args) {
		Integer[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		List<Integer> list = new ArrayList<>(testListCreator(arr));
	}

	public static <E> List<E> testListCreator(E[] array) {
		List<E> testList = new ArrayList<>(array.length);
		for (int i = 0; i < array.length && i < 9; i++) {
			testList.add(array[i]);
		}
		testList.remove(0);
		testList.remove(0);
		testList.remove(testList.size() - 1);
		System.out.println("--------------------------------");

		System.out.println(testList);
		return testList;
	}

}
