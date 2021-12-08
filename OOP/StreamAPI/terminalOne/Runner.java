package terminalOne;

import java.util.List;
import java.util.Optional;

public class Runner {

	public static void main(String[] args) {
//*******************************************************************************************************************************	
		// ** Task2
		ProgrammingLanguage lang1 = new ProgrammingLanguage("Haskell", DifficultyLevel.HARD);
		ProgrammingLanguage lang2 = new ProgrammingLanguage("Python", DifficultyLevel.EASY);
		ProgrammingLanguage lang3 = new ProgrammingLanguage("Java", DifficultyLevel.MEDIUM);
		ProgrammingLanguage lang4 = new ProgrammingLanguage("C++", DifficultyLevel.HARD);
		ProgrammingLanguage lang5 = new ProgrammingLanguage("JS", DifficultyLevel.EASY);
		List<ProgrammingLanguage> languages = List.of(lang1, lang2, lang3, lang4, lang5);
		DifficultyLevel df = DifficultyLevel.EASY;
		Optional<ProgrammingLanguage> test = languages.stream().filter(a -> a.getComplexity() == df).findAny();
		System.out.println(test);
	}
//*******************************************************************************************************************************	
	// ** Task1
//	File addresses = new File("Addresses.txt");
//	List<String> folds = txtReader(addresses);
//	String result = folds.stream().filter(Runner::txtContains).findFirst().get();
//	System.out.println(result);
//	public static boolean txtContains(String a) {
//		int count = 0;
//		File fl = new File(a);
//		File[] files = fl.listFiles();
//		for (File file : files) {
//			if (txtChecker(file)) {
//				count++;
//			}
//		}
//		if (count > 3) {
//			return true;
//		}
//		return false;
//	}
//
//	public static boolean txtChecker(File a) {
//		String temp = a.getName();
//		String[] tempArr = temp.split("[.]");
//		if (tempArr.length > 1 && tempArr[1].equals("txt")) {
//			return true;
//		}
//		return false;
//	}
//
//	public static List<String> txtReader(File a) {
//		List<String> addresses = new ArrayList<>();
//		try (Scanner sc = new Scanner(a)) {
//			for (; sc.hasNextLine();) {
//				if (sc.nextLine() != null) {
//					addresses.add(sc.nextLine());
//				}
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return addresses;
//	}

}

enum DifficultyLevel {
	EASY, MEDIUM, HARD;
}

class ProgrammingLanguage {
	private String name;
	private DifficultyLevel complexity;

	public ProgrammingLanguage(String name, DifficultyLevel complexity) {
		super();
		this.name = name;
		this.complexity = complexity;
	}

	public String getName() {
		return name;
	}

	public DifficultyLevel getComplexity() {
		return complexity;
	}

	@Override
	public String toString() {
		return "ProgrammingLanguage [name=" + name + ", complexity=" + complexity + "]";
	}
}
