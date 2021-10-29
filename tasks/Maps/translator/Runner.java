package translator;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Runner {

	public static void main(String[] args) {
		Map<String, String> boof = new HashMap<>();
		boof.put("hello", "Привіт");
		boof.put("world", "світ");
		File fl0 = new File("English.in.txt");
		File fl1 = new File("CSVDictionary.csv");
		TranslatorService ts = new TranslatorService(boof, fl0);
		ts.addTranslation();
		System.out.println(ts.translate());
		ts.saveToCSVDict(fl1);
	}

}
