package shellsSort;

import java.util.Arrays;

public class cherno {

	public static void main(String[] args) {

		int[] test = new int[20];
		for (int i = 0; i < test.length; i++) {
			test[i] = (int) (Math.random() * 100);
		}

		int[] test1 = Arrays.copyOfRange(test, 0, test.length);
		System.out.println(Arrays.toString(test));
		int begin = 10;
		int end = 20;
		shellSort(test, begin, end);
		System.out.println(Arrays.toString(test));
		System.out.println("---------------------------------");
		shell1Sort(test1);
		System.out.println(Arrays.toString(test1));

	}

	public static void shellSort(int[] array, int begin, int end) {
		int size = end - begin;
		int h = size / 2;
		int startPoint = begin + h;
		for (; startPoint > begin;) {
			for (int i = h; i < end; i++) {
				for (int j = i; j >= startPoint && array[j] < array[j - h]; j -= h) {
					int temp = array[j];
					array[j] = array[j - h];
					array[j - h] = temp;
				}
			}
			h = h / 2;
			startPoint = begin + h;
		}

	}

	public static void shell1Sort(int[] arr) {
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
