package shellsSort;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {

		int[] test = new int[200000];
		for (int i = 0; i < test.length; i++) {
			test[i] = (int) (Math.random() * 100);
		}
		int[] copy = Arrays.copyOfRange(test, 0, test.length);
		int cpu = Runtime.getRuntime().availableProcessors();

		long start = System.currentTimeMillis();
		shellSort(test);
		long end = System.currentTimeMillis();
		System.out.println("Simple thread method took: " + (end - start) + " milliseconds.");
		System.out.println("---------------------------------");
		start = System.currentTimeMillis();
		MultiSort.sort(copy, 3);
		end = System.currentTimeMillis();
		System.out.println("Multiple thread method took: " + (end - start) + " milliseconds.");

		System.out.println(test[199999]);
		System.out.println(copy[199999]);
//		System.out.println(Arrays.toString(test));
//		System.out.println("---------------------------------");
//		System.out.println(Arrays.toString(copy));

	}

	public static void shellSort(int[] arr) {
		int h = arr.length / 2;
		for (; h > 0;) {
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
					int temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				}
			}
			h = h / 2;
		}
	}

}
