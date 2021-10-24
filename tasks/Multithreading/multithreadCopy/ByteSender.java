package multithreadCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ByteSender implements Runnable {

	private File file;
	private ByteController bc;
	private byte[] pack;
	private int check;

	public ByteSender(File file, ByteController bc) {
		super();
		this.file = file;
		this.bc = bc;
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}

	public byte[] getPack() {
		return pack;
	}

	public void setPack(byte[] pack) {
		this.pack = pack;
	}

	public int getCheck() {
		return check;
	}

	public void setCheck(int check) {
		this.check = check;
	}

	@Override
	public void run() {
		System.out.println("Thread-sender live.");
		try (InputStream is = new FileInputStream(file)) {
			for (; check != -1;) {
				pack = new byte[1000000];
				check = is.read(pack);
//				System.out.println("Sender sending");
//				System.out.println();
				bc.setBuffer(pack);
			}
			bc.setCheckCntrl(check);
		} catch (IOException e) {
			// TODO: handle exception
		}
		System.out.println("Thread-sender done.");
	}

}
