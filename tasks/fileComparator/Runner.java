package fileComparator;

import java.io.File;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {

		File a = new File(args[0]);
		File b = new File(args[1]);
		FileComparator fc = new FileComparator();
		try {
			fc.fileComparator(a, b);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
