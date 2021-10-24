package uni;

import java.io.File;
import java.io.IOException;

public class Cherno {

	public static void main(String[] args) throws IOException {
		File fl = new File("8806.csv");

		GroupFileStorage gfs = new GroupFileStorage();
		Group test = new Group();
		test = gfs.loadGroupFromCSV(fl);

		System.out.println(test.toString());

	}

}
