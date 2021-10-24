package testList;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter desired size for your list:");
		int size = sc.nextInt();

		List<Integer> testList = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			testList.add((int) (Math.random() * size));
		}

		System.out.println(testList);

		testList.remove(0);
		testList.remove(0);
		testList.remove(testList.size() - 1);

		System.out.println("--------------------------------");

		System.out.println(testList);
	}

}
