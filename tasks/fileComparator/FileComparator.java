package fileComparator;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class FileComparator {

	public void fileComparator(File a, File b) throws IOException {
		try (InputStream is = new FileInputStream(a); InputStream isa = new FileInputStream(b)) {

			int temp0 = is.available();
			byte[] isArr = new byte[temp0];
			int temp1 = isa.available();
			byte[] isaArr = new byte[temp1];

			if (Arrays.equals(isArr, isaArr)) {
				System.out.println("Files are identical!");
			} else {
				System.out.println("Files are NOT identical!");
			}

		} catch (IOException e) {

			throw e;
		}
	}
}
