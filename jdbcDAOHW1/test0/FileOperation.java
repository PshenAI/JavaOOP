package sample;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileOperation {

	public static void copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			long copyByte = is.transferTo(os);
			System.out.println(copyByte);

		} catch (IOException e) {

			throw e;
		}
	}

	public static void folderCopy(File folderIn, File folderOut) throws IOException {
		if (folderIn.isDirectory() == true) {
			File[] fileArr = folderIn.listFiles();
			for (File file : fileArr) {
				File fl = new File(folderOut, file.getName());
				copyFile(file, fl);
			}
		} else {
			System.out.println("Entered file is not a directory.");
		}
	}

}
