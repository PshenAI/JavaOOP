package fileComparator;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {

		if (args.length != 0) {
			File a = new File(args[0]);
			File b = new File(args[1]);
			FileComparator fc = new FileComparator();
			try {
				fc.fileComparator(a, b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} else {
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter 1st address (with 2 slashes!!): ");
			String add1 = sc.nextLine();

			System.out.println("Enter 2nd address (with 2 slashes!!): ");
			String add2 = sc.nextLine();

			File a = new File(add1);
			File b = new File(add2);
			FileComparator fc = new FileComparator();
			try {
				fc.fileComparator(a, b);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
}
