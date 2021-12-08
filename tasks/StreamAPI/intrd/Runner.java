package intrd;

import java.io.File;

public class Runner {

	public static void main(String[] args) {

//*******************************************************************************************************************************	
		// ** Task3
//		File fold = new File("C:\\Users\\Velvet X\\Documents\\Java OOP\\StreamAPI\\test0");
//		File[] files = fold.listFiles();
//		Stream<File> fileStream = Arrays.stream(files);
//		Comparator<File> comp = Runner::fileComparator;
//		String result = fileStream.max(comp).get().getAbsolutePath();
//		System.out.println(result);

//*******************************************************************************************************************************		
		// ** Task2
//		List<Integer> nums = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9);
//
//		List<Integer> newNums = nums.stream().filter(a -> a % 2 != 0).collect(Collectors.toList());
//		System.out.println(newNums);
//*******************************************************************************************************************************
		// ** Task1
//		Cat cat1 = new Cat("Acro", 7, "Ginger");
//		Cat cat2 = new Cat("Phil", 2, "White");
//		Cat cat3 = new Cat("Mao", 5, "Black");
//		Cat cat4 = new Cat("Misquise", 12, "Bold");
//		List<Cat> cats = List.of(cat1, cat2, cat3, cat4);
//
//		System.out.println(cats.stream().max((a, b) -> a.getName().length() - b.getName().length()).get().getName());

	}

	public static int fileComparator(File a, File b) {
		if (a.length() > b.length()) {
			return 1;
		}
		if (a.length() < b.length()) {
			return -1;
		}
		return 0;
	}

}
