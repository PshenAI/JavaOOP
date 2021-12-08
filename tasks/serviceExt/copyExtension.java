package serviceExt;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class copyExtension {

	public static void copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			long copyByte = is.transferTo(os);
			System.out.println(copyByte);
		} catch (IOException e) {
			throw e;
		}
	}

	public static void folderCopyExtension(File folderIn, File folderOut) throws IOException {
		Scanner sc = new Scanner(System.in);
		System.out.println("What type of extension would you like to copy?");
		String ext = sc.nextLine();
		int count = 0;
		if (folderIn.isDirectory() == true) {
			File[] fileArr = folderIn.listFiles();
			for (File file : fileArr) {
				String name = file.getName();
				String[] splitter = name.split("[.]");
				if (splitter[1].equals(ext)) {
					File fl = new File(folderOut, file.getName());
					copyFile(file, fl);
					count += 1;
				}

			}
		} else {
			System.out.println("Entered file is not a directory.");
		}
		if (count == 0) {
			System.out.println("No files with such extension in directory.");
		}
	}

}
