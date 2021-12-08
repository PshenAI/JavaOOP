package multithreadCopy;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class ByteReceiver implements Runnable {

	private File file;
	private byte[] pack;
	private ByteController bc;

	public ByteReceiver(File file, ByteController bc) {
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

	public ByteController getBc() {
		return bc;
	}

	public void setBc(ByteController bc) {
		this.bc = bc;
	}

	@Override
	public void run() {
		System.out.println("Thread-receiver live.");
		try (OutputStream os = new FileOutputStream(file)) {
			int count = 0;
			for (; bc.getCheckCntrl() != -1;) {
				pack = bc.getBuffer();
				count += 1;
//				System.out.println("Receiver writing");
//				System.out.println();
				System.out.println(count + " Mb copied.");
				os.write(pack);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		System.out.println("Thread-receiver done.");
	}

}
