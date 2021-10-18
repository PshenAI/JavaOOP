package multithreadFileSearcher;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File soughtDir = new File("C:\\Users\\Velvet X\\Documents\\Java OOP\\MultithreadingDz\\test1");
		String soughtName = "The Doors – Riders In The Storm.mp3";

		MultiFileSearcher mfs = new MultiFileSearcher();
		SearchTask st = new SearchTask(mfs, soughtDir, soughtName);
		try {
			st.getThr().join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
