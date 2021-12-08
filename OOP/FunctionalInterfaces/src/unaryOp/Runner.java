package unaryOp;

import java.util.List;

public class Runner {

	public static void main(String[] args) {
		List<String> text = List.of("Acran2", "Conquistadores", "ABBA", "BBNG", "Crona", "T-1021");

	}

	// ** Task3
//	UnaryOperator<List<String>> unOp = Runner::moreThan5;
//	public static List<String> moreThan5(List<String> a) {
//		List<String> temp = new ArrayList<>();
//		for (String string : a) {
//			if (string.length() > 5) {
//				temp.add(string);
//			}
//		}
//		return temp;
//	}
	// ** Task2
//	UnaryOperator unOp = Runner::justDig;
//	public static String justDig(String a) {
//		String result = a.replaceAll("\\D", "");
//		return result;
//	}

	// ** Task1
//	UnaryOperator unOp = Runner::oddUnOp;
//	public static Integer oddUnOp(Integer a) {
//		if (a % 2 != 0) {
//			a = 0;
//		}
//		return a;
//	}
}
