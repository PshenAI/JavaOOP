package filters;

public class Runner {
	public static void main(String[] args) {

// **************************************************************************************************
//		 ** Task4
//		String[] xml = { "<dependency>", "<groupId>junit</groupId>", "<artifactId>junit</artifactId>",
//				"<version>4.4</version>", "<scope>test</scope>", "</dependency>", "<dependency>",
//				"<groupId>org.powermock</groupId>", "<artifactId>powermock-reflect</artifactId>",
//				"<version>3.2</version>", "</dependency>" };
//
//		Function<String, String> func = x -> {
//			String[] temp = x.split(">");
//			String result = temp[1];
//			temp = result.split("<");
//			result = temp[0];
//			return result;
//		};
//		List<String> transform = Arrays.stream(xml).filter(x -> x.startsWith("<groupId>")).map(func)
//				.collect(Collectors.toList());
//		System.out.println(transform);

// **************************************************************************************************
		// ** Task3
//		Cat cat1 = new Cat("Acropolis", 1);
//		Cat cat2 = new Cat("Majima", 3);
//		Cat cat3 = new Cat("Kuzo", 8);
//		Cat cat4 = new Cat("Bitanga", 6);
//		List<Cat> cats = List.of(cat1, cat2, cat3, cat4);
//		List<Cat> optiCats = cats.stream().filter(a -> a.getWeight() >= 3)
//				.sorted((a, b) -> a.getName().compareTo(b.getName())).collect(Collectors.toList());
//		System.out.println(optiCats);

//**************************************************************************************************
		// ** Task2
//		String text = "Jappo, pinta tomka ni lobsi! && Ratak.";
//		char[] chara = text.toCharArray();
//		List<Character> list = new ArrayList<>();
//		for (char character : chara) {
//			list.add(character);
//		}
//		list.stream().filter(x -> x.toString().matches("\\w")).forEach(x -> System.out.print(x.toString()));

//**************************************************************************************************
		// ** Task1
//		String text = "Velvet to Vortex tapta Finskajappo tan";
//		String[] arrText = text.split(" ");
//		Arrays.stream(arrText).filter(n -> n.length() <= 5).forEach(n -> System.out.println(n));
	}
}
