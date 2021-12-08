package availableSite;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class CheckSiteService {

	public static void checkSite(File file) throws IOException {
		Set<String> liveLinks = new HashSet<>();
		Set<String> deadLinks = new HashSet<>();
		Set<String> links = txtScanner(file);
		for (String link : links) {
			try {
				URL url = new URL(link);
				HttpURLConnection connection = (HttpURLConnection) url.openConnection();
				if (connection.getResponseCode() != 200) {
					deadLinks.add(link);
					continue;
				}
			} catch (IOException e) {
				deadLinks.add(link);
				continue;
			}
			liveLinks.add(link);
		}
		System.out.println("Live links are:\n" + liveLinks);
		System.out.println("-------------------------------------------");
		System.out.println("Dead links are:\n" + deadLinks);

	}

	private static Set<String> txtScanner(File file) {
		Set<String> temp = new HashSet<>();
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				temp.add(sc.nextLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return temp;
	}

}
