package translator;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TranslatorService {
	private Map<String, String> dict = new HashMap<>();
	private File in;

	public TranslatorService(File in) {
		super();
		this.in = in;
	}

	public TranslatorService(Map<String, String> dict, File in) {
		super();
		this.dict = dict;
		this.in = in;
	}

	public File getIn() {
		return in;
	}

	public void setIn(File in) {
		this.in = in;
	}

	public Map<String, String> getDict() {
		return dict;
	}

	public void setDict(Map<String, String> dict) {
		this.dict = dict;
	}

	public String addTranslation() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter english word + space + translation: ");
		String temp = sc.nextLine();
		String[] strArr = temp.toLowerCase().split(" ");
		String test = dict.get(strArr[0]);
		if (test == null) {
			dict.put(strArr[0], strArr[1]);
			System.out.println("Translation was added.");
			return strArr[1];
		} else {
			System.out.println("Translation already exist.");
			return null;
		}
	}

	public String translate() {
		String temp = txtScanner().toLowerCase();
		String[] wSpace = temp.replaceAll("[,.!\r\n]", "").split(" ");
		for (int i = 0; i < wSpace.length; i++) {
			String test = dict.get(wSpace[i]);
			if (test != null) {
				temp = temp.replace(wSpace[i], test);
			} else {
				System.out.println("There's no match for word '" + wSpace[i] + "' in the dictionary.");
				System.out.println("-------------------------");
			}
		}
		tsWriter(temp, "Ukrainian.out.txt");
		return temp;
	}

	private String txtScanner() {
		StringBuilder sb = new StringBuilder();
		try (Scanner sc = new Scanner(in)) {
			for (; sc.hasNextLine();) {
				sb.append(sc.nextLine()).append(System.lineSeparator());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String b = sb.toString();
		return b;
	}

	private void tsWriter(String transl, String fileName) {
		try (var pw = new PrintWriter(new FileWriter(fileName))) {
			pw.println(transl);
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void saveToCSVDict(File fl) {
		StringBuilder sb = new StringBuilder();
		Set<String> keys = dict.keySet();
		for (String key : keys) {
			sb.append(key + " => " + dict.get(key) + ",");
		}
		tsWriter(sb.toString(), fl.getName());
		System.out.println("Saved successfuly.");
	}

	@Override
	public String toString() {
		return "TranslatorService [dict=" + dict + ", in=" + in + "]";
	}
}
