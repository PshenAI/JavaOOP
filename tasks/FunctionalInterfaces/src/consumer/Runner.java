package consumer;

public class Runner {

	public static void main(String[] args) {

//		File file = new File("Anko.txt");
//		String test = "ADDED THIS";
//
//		BiConsumer<String, File> bicons = (a, b) -> {
//			try (PrintWriter pw = new PrintWriter(new FileWriter(b.getName(), true))) {
//				pw.println(a);
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		};
//
//		bicons.accept(test, file);

		// ** Task2
//		List<String> text = new ArrayList<>();
//
//		Consumer<String> cons = a -> {
//			if (a.matches(".*[\\d].*")) {
//				text.add(a);
//			}
//		};
//		String[] strings = { "test", "test1" };
//
//		for (String string : strings) {
//			cons.accept(string);
//		}
//		System.out.println(text);

		// ** Task1
//		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//		Consumer<Integer> cons = a -> {
//			if (a % 2 != 0) {
//				System.out.println(a);
//			}
//		};
//
//		numbers.forEach(cons);

	}

}
