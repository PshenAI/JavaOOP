package serviceExt;

import java.io.File;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		File fl0 = new File("test0");
		File fl1 = new File("test1");
		try {
			copyExtension.folderCopyExtension(fl0, fl1);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
