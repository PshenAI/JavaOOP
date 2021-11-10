package sorting;

import java.util.Comparator;
import java.util.List;

public class Runner {

	public static void main(String[] args) {

// *******************************************************************************************************************************
		// ** Task3
		List<Integer> nums = List.of(123, 432, 5895, 456, 254648, 8, 729);

		Comparator<Integer> byLastDigit = (a, b) -> {
			String temp1 = String.valueOf(a);
			String temp2 = String.valueOf(b);

			temp1 = temp1.substring(temp1.length() - 1, temp1.length());
			temp2 = temp2.substring(temp2.length() - 1, temp2.length());

			return Integer.parseInt(temp1) - Integer.parseInt(temp2);
		};

		nums.stream().filter(a -> a > 10).sorted(byLastDigit).forEach(a -> System.out.println(a));

	}

//*******************************************************************************************************************************
	// ** Task2
//	Student ast = new Student(11111, null, "Aaron", "Velvetov", 20, Gender.Male);
//	Student bst = new Student(33333, null, "David", "Kottov", 21, Gender.Male);
//	Student cst = new Student(22222, null, "Boris", "Kotletov", 18, Gender.Male);
//	Student dst = new Student(44444, null, "Kotto", "Velvetova", 19, Gender.Female);
//	Student est = new Student(55555, null, "Katto", "Kottova", 22, Gender.Female);
//
//	Student[] students = { ast, cst, dst, bst, est };
//
//	Comparator<Student> byLastName = (a, b) -> a.getSurname().compareTo(b.getSurname());
//	Comparator<Student> byFirstName = (a, b) -> a.getName().compareTo(b.getName());
//
//	List<Student> studentList = Arrays.stream(students).filter(a -> a.getAge() > 20)
//			.sorted(Comparator.nullsLast(byLastName.thenComparing(byFirstName))).collect(Collectors.toList());
//*******************************************************************************************************************************
	// ** Task1
//	String text = "aaa io a aeoea i Onna krt";
//	String[] textArr = text.split(" ");
//	Arrays.stream(textArr).filter(Runner::vowelCheck).sorted(Runner::vowelComp).forEach(n -> System.out.println(n));
//	public static boolean vowelCheck(String a) {
//		char[] tempA = a.toCharArray();
//		int countA = vowelCounter(tempA);
//		if (countA == 0) {
//			return false;
//		}
//		return true;
//	}
//
//	public static int vowelComp(String a, String b) {
//		char[] tempA = a.toCharArray();
//		int countA = vowelCounter(tempA);
//		char[] tempB = b.toCharArray();
//		int countB = vowelCounter(tempB);
//
//		return countA - countB;
//	}
//
//	public static int vowelCounter(char[] a) {
//		char[] vowels = { 'a', 'e', 'i', 'o', 'u' };
//		int temp = 0;
//		for (char c : a) {
//			for (char d : vowels) {
//				if (c == d) {
//					temp++;
//				}
//			}
//		}
//		return temp;
//	}

}
