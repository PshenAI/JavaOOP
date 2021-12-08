package folderCopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FolderCopyTask implements Runnable {

	private File in;
	private File out;

	public FolderCopyTask(File in, File out) {
		super();
		this.in = in;
		this.out = out;
	}

	public File getIn() {
		return in;
	}

	public void setIn(File in) {
		this.in = in;
	}

	public File getOut() {
		return out;
	}

	public void setOut(File out) {
		this.out = out;
	}

	@Override
	public void run() {
		try {
			copyFile(in, out);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void copyFile(File in, File out) throws IOException {
		try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {
			is.transferTo(os);
			System.out.println(in.getName() + " copied.");
		} catch (IOException e) {
			throw e;
		}
	}

}
