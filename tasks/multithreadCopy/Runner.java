package multithreadCopy;

import java.io.File;

public class Runner {

	public static void main(String[] args) {
		File fileA = new File("F:\\505\\The Doors – Riders In The Storm.mp3");
		File fileB = new File(
				"C:\\Users\\Velvet X\\Documents\\Java OOP\\MultithreadingDz\\test1\\The Doors – Riders In The Storm.mp3");
		ByteController bc = new ByteController();
		ByteSender bs = new ByteSender(fileA, bc);
		ByteReceiver br = new ByteReceiver(fileB, bc);
		bc.setBs(bs);
		bc.setBr(br);

		Thread thr1 = new Thread(bs);
		Thread thr2 = new Thread(br);
		thr1.start();
		thr2.start();

	}

}
