package comparator;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		List<File> anko = new ArrayList<>();
		File fl0 = new File("Anko.txt");
		File fl1 = new File("Madara.txt");
		File fl2 = new File("Love.txt");
		File fl3 = new File("Connan.txt");
		File fl4 = new File("Jass.txt");
		anko.add(fl0);
		anko.add(fl1);
		anko.add(fl2);
		anko.add(fl3);
		anko.add(fl4);

		// ** Task5

//		Comparator<File> comp = (a, b) -> {
//			String[] tempA = txtToString(a).replaceAll("\\w", "").split("");
//			String[] tempB = txtToString(b).replaceAll("\\w", "").split("");
//			int count1 = tempA.length;
//			int count2 = tempB.length;
//
//			if (count1 - count2 > 0) {
//				return 1;
//			}
//			if (count1 - count2 < 0) {
//				return -1;
//			}
//			return 0;
//
//		};
//		Collections.sort(anko, comp);
//		System.out.println(anko);

		// ** Task4

//		Comparator<Integer> comp1 = (a, b) -> a - b;
//
//		Collections.sort(anko, comp1);
//		if (anko.get(anko.size() - 1) == anko.get(anko.size() - 2)) {
//			System.out.println(Collections.max(anko, comp1.reversed()));
//		} else {
//			System.out.println(Collections.max(anko, comp1));
//		}

		// **Task1

//		Cat cat1 = new Cat("Acropolis", 7);
//		Cat cat2 = new Cat("Bitanga", 12);
//		Cat cat3 = new Cat("Bitang", 8);
//
//		Cat[] cats = { cat1, cat2, cat3 };

		// **Task3

//		Comparator<Integer> comp = (a, b) -> {
//			char[] arrA = a.toString().toCharArray();
//			char[] arrB = b.toString().toCharArray();
//			int tempA = Character.getNumericValue(arrA[0]) + Character.getNumericValue(arrA[arrA.length - 1]);
//			int tempB = Character.getNumericValue(arrB[0]) + Character.getNumericValue(arrB[arrB.length - 1]);
//			if (tempA - tempB > 0) {
//				return 1;
//			}
//			if (tempA - tempB < 0) {
//				return -1;
//			}
//			return 0;
//		};
//		Collections.sort(anko, comp);

		// **Task2

//		Comparator<Integer> first = (a, b) -> Math.abs(a) - Math.abs(b);
//		Comparator<Integer> second = (a, b) -> {
//			if (a > 0) {
//				return -1;
//			}
//			if (a < 0) {
//				return 1;
//			}
//			return 0;
//		};
//		Comparator<Integer> result = first.thenComparing(second);
//		System.out.println(Collections.min(anko, result));
	}

	public static String txtToString(File file) {
		String result = "";
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				result += sc.nextLine() + System.lineSeparator();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return result;
	}

}
