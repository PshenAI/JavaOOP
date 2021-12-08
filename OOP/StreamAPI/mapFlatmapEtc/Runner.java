package mapFlatmapEtc;

import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Runner {

//*******************************************************************************************************************************	
	// ** Task3
	public static void main(String[] args) {
		String address = "C:\\Users\\Velvet X\\Documents\\Java OOP\\StreamAPI\\test0";
		String[] arr = { address };
		List<File> txt = Arrays.stream(arr).map(Runner::fileCreator).flatMap(x -> Arrays.stream(x.listFiles()))
				.filter(Runner::txtChecker).collect(Collectors.toList());
		System.out.println(txt);
	}

	public static File fileCreator(String a) {
		File temp = new File(a);
		return temp;
	}

	public static boolean txtChecker(File a) {
		String temp = a.getName();
		String[] tempArr = temp.split("[.]");
		if (tempArr[1].equals("txt")) {
			return true;
		}
		return false;
	}

//*******************************************************************************************************************************	
	// ** Task2
//	Singer singer1 = new Singer("Jefferson Airplane", new String[] { "White Rabbit", "Somebody to Love" });
//	Singer singer2 = new Singer("David Bowie",
//			new String[] { "Space Oddity", "Let Me Sleep Beside You", "Suffragette City" });
//	Singer singer3 = new Singer("Connan Mockasin",
//			new String[] { "I'm the man, that will find You", "Do I make You feel shy?" });
//
//	Singer[] singers = { singer1, singer2, singer3 };
//	List<String> songs = Arrays.stream(singers).flatMap(x -> Arrays.stream(x.getSongs()))
//			.sorted((a, b) -> a.compareTo(b)).limit(3).collect(Collectors.toList());
//	System.out.println(songs);
//*******************************************************************************************************************************	
	// ** Task1
//	File file = new File("Links.txt");
//	List<String> links = new ArrayList<>();
//	try {
//		links = linkReader(file);
//	} catch (IOException e) {
//		// TODO Auto-generated catch block
//		e.printStackTrace();
//	}
//	links.stream().filter(Runner::filter).forEach(x -> System.out.println(x));
//	public static boolean filter(String link) {
//		try {
//			URL url = new URL(link);
//			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//			if (connection.getResponseCode() != 200) {
//				return false;
//			}
//		} catch (IOException e) {
//			return false;
//		}
//		return true;
//	}
//
//	public static List<String> linkReader(File a) throws IOException {
//		List<String> links = new ArrayList<>();
//		try (Scanner sc = new Scanner(a)) {
//			for (; sc.hasNextLine();) {
//				links.add(sc.nextLine());
//			}
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//		return links;
//	}
}
