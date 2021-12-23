package sample;

import java.io.File;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		File in = new File("src\\sample");
		File out = new File("test1");

		try {
			FileOperation.folderCopy(in, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
