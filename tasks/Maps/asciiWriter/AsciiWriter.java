package asciiWriter;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

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
		char[] temp = text.toLowerCase().toCharArray();
		Set<Character> tempSet = dict.keySet();
		for (int i = 0; i < temp.length; i++) {
			if (temp[i] == ' ') {
				System.out.println();
				System.out.println();
				System.out.println();
				continue;
			}
			for (Character character : tempSet) {
				if (temp[i] == character) {
					String buff = dict.get(character);
					System.out.print(buff);
				}
			}
		}
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
