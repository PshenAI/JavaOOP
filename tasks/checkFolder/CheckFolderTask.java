package checkFolder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CheckFolderTask implements Runnable {
	private boolean work = true;
	private File fl;
	private int iteration;
	private Thread thr = new Thread(this);

	public CheckFolderTask(File fl) {
		super();
		this.fl = fl;
		thr.start();
	}

	public File getFl() {
		return fl;
	}

	public void setFl(File fl) {
		this.fl = fl;
	}

	public int getIteration() {
		return iteration;
	}

	public void setIteration(int iteration) {
		this.iteration = iteration;
	}

	public boolean isWork() {
		return work;
	}

	public void setWork(boolean work) {
		this.work = work;
	}

	@Override
	public void run() {
		System.out.println("Thread live");
		logInit();
		while (work == true) {
			File[] orig = fl.listFiles();
			try {
				thr.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			File[] act = fl.listFiles();
			boolean check;
			if (orig.length > act.length) {
				for (int i = 0; i < orig.length; i++) {
					check = false;
					for (int j = 0; j < act.length; j++) {
						if (orig[i].getName().equals(act[j].getName())) {
							check = true;
							break;
						}
					}
					if (check != true) {
						logWriter(orig[i].getName(), false);
						System.out.println(orig[i].getName() + " was deleted.");
					}
				}
			}
			if (orig.length < act.length) {
				for (int i = 0; i < act.length; i++) {
					check = false;
					for (int j = 0; j < orig.length; j++) {
						if (act[i].getName().equals(orig[j].getName())) {
							check = true;
							break;
						}
					}
					if (check != true) {
						logWriter(act[i].getName(), true);
						System.out.println(act[i].getName() + " was added.");
					}
				}
			}
		}

	}

	public void logInit() {
		try (var pw = new PrintWriter("log.txt")) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String text = sdf.format(date);
			sdf = new SimpleDateFormat("yyyy:MM:dd");
			String text1 = sdf.format(date);
			pw.println(text1 + " at " + text + " " + thr.getName() + " started.");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void logWriter(String file, boolean action) {
		try (var pw = new PrintWriter(new FileWriter("log.txt", true))) {
			Date date = new Date();
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
			String text = sdf.format(date);
			sdf = new SimpleDateFormat("yyyy:MM:dd");
			String text1 = sdf.format(date);
			if (action == true) {
				pw.println(text1 + " at " + text + " " + file + " was added.");
			} else {
				pw.println(text1 + " at " + text + " " + file + " was deleted.");
			}

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

}
