package triangle;

import java.util.Scanner;

public class Runner {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter length of the 1st side of the triangle:");
		Triangle tr1 = new Triangle();
		tr1.setSideA(sc.nextDouble());
		System.out.println("Enter length of the 2nd side of the triangle:");
		tr1.setSideB(sc.nextDouble());
		System.out.println("Enter length of the 3rd side of the triangle:");
		tr1.setSideC(sc.nextDouble());
		String temp1 = String.format("%." + 2 + "f", tr1.getArea());
		System.out.println(temp1);

		Triangle tr2 = new Triangle(2.3, 5.2, 3.1);
		System.out.println(tr2.getArea());
	}

}
