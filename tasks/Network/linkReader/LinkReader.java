package linkReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashSet;
import java.util.Set;

public class LinkReader {
	private String address;

	public LinkReader(String address) {
		super();
		this.address = address;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void linksFromHtml() {
		String html = "";
		try {
			html = htmlGetter();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String[] links = html.split("http");
		Set<String> linkset = new HashSet<>();
		for (int i = 1; i < links.length; i++) {
			links[i] = "http" + links[i];
			int temp = links[i].indexOf("\"");
			links[i] = links[i].substring(0, temp);
			linkset.add(links[i]);
		}
		try {
			filePrinter(linkset);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void filePrinter(Set<String> links) throws IOException {
		File file = new File("LinksFromURL.txt");
		int temp = 1;
		try (PrintWriter pw = new PrintWriter(new FileWriter(file))) {
			pw.println("Here are links from your URL: ");
			for (String link : links) {
				pw.println(temp + " <=> " + link);
				temp++;
			}
		} catch (IOException e) {
			throw e;
		}
	}

	private String htmlGetter() throws IOException {
		URL url = new URL(address);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		String result = "";
		try (InputStream is = connection.getInputStream()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is, "UTF-8"));
			String temp = "";
			for (;;) {
				temp = br.readLine();
				if (temp == null) {
					break;
				}
				result += temp + System.lineSeparator();
			}
		} catch (IOException e) {
			throw e;
		}
		return result;
	}
}
