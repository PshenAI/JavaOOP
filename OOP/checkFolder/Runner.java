package checkFolder;

import java.io.File;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) throws IOException {
		File fl = new File("test1");

		CheckFolderTask chk = new CheckFolderTask(fl);

	}
}
