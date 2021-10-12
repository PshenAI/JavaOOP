package fileComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileComparator {

	public void fileComparator(File a, File b) throws IOException {
		try (InputStream is = new FileInputStream(a); InputStream isa = new FileInputStream(b)) {

			int count = 0;
			int check = 0;
			int gen = 0;
			for (; gen != -1;) {
				byte[] isArr = new byte[1000000];
				gen = is.read(isArr);

				byte[] isaArr = new byte[1000000];
				gen = isa.read(isaArr);

				count += 1;
				if (Arrays.equals(isArr, isaArr)) {
					check += 1;
				}
			}

			if (count == check) {
				System.out.println("Files are identical!");
			} else {
				System.out.println("Files are NOT identical!");
			}

		} catch (IOException e) {

			throw e;
		}
	}
}
