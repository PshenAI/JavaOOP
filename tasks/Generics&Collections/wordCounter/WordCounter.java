package wordCounter;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class WordCounter {
	private File file;
	private List<String> result = new ArrayList<>();

	public WordCounter(File file) {
		super();
		this.file = file;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public void wordCounter() {
		String text = txtScanner();
		text = text.toLowerCase();
		char[] textArr = text.toCharArray();
		char[] abc = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's',
				't', 'u', 'v', 'w', 'x', 'y', 'z' };

		int temp = 0;
		for (int i = 0; i < abc.length; i++) {
			temp = 0;
			for (int j = 0; j < textArr.length; j++) {
				if (abc[i] == textArr[j]) {
					temp += 1;
				}
			}

			result.add(abc[i] + " => " + temp);
		}
		Collections.sort(result, new Comparator<String>() {
			public int compare(String o1, String o2) {
				return extractInt(o2) - extractInt(o1);
			}

			public int extractInt(String s) {
				String num = s.replaceAll("\\D", "");

				return num.isEmpty() ? 0 : Integer.parseInt(num);
			}
		});
		for (String x : result) {
			System.out.println(x);
		}
	}

	private String txtScanner() {
		StringBuilder sb = new StringBuilder();
		try (Scanner sc = new Scanner(file)) {
			for (; sc.hasNextLine();) {
				sb.append(sc.nextLine()).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String b = sb.toString();
		System.out.println(b);
		return b;
	}

	@Override
	public String toString() {
		return "WordCounter [file=" + file + "]";
	}

}
