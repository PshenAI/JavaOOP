package asciiWriter;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AsciiWriter {
	private Character[] alphabet = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p',
			'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z' };
	private String text;
	private Map<Character, String> dict = new HashMap<>();

	public AsciiWriter(String text) {
		super();
		this.text = text;
		String[] temp = new String[alphabet.length];
		try {
			temp = txtScanner();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for (int i = 0; i < alphabet.length; i++) {
			dict.put(alphabet[i], temp[i]);
		}
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Map<Character, String> getDict() {
		return dict;
	}

	public void setDict(Map<Character, String> dict) {
		this.dict = dict;
	}

	public void outputInAscii() {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < text.length(); j++) {
				String temp = dict.get(text.toLowerCase().charAt(j));
				if (temp == null) {
					sb.append("   ");
					continue;
				}
				String[] arr = temp.split("\r\n");
				sb.append(arr[i]);
			}
			sb.append(System.lineSeparator());
		}
		System.out.println(sb.toString());
	}

	private final String[] txtScanner() throws IOException {
		File in = new File("aafont.txt");
		String[] alphabet = new String[26];
		try (Scanner sc = new Scanner(in)) {
			for (int i = 0; sc.hasNextLine(); i++) {
				String temp = sc.nextLine() + System.lineSeparator() + sc.nextLine() + System.lineSeparator()
						+ sc.nextLine() + System.lineSeparator();
				temp = temp.replaceAll("[$@]", " ");
				alphabet[i] = temp;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return alphabet;
	}
}
