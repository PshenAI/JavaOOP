package wordCounter;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File fl = new File("Velvet.txt");

		WordCounter wc = new WordCounter(fl);
		wc.wordCounter();

	}

}
