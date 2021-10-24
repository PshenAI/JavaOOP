package folderCopy;

import java.io.File;

public class Runner {

	public static void main(String[] args) {

		Thread thr = Thread.currentThread();
		File in = new File("test0");
		File out = new File("test1");
		int cpu = Runtime.getRuntime().availableProcessors();
		Thread[] thrArr = new Thread[cpu];

		int count = 0;
		if (in.isDirectory() == true) {
			File[] fileArr = in.listFiles();
			for (File file : fileArr) {
				File fl = new File(out, file.getName());
				FolderCopyTask fct = new FolderCopyTask(file, fl);
				if (thrArr[cpu - 1] == null) {
					thrArr[count] = new Thread(fct);
					thrArr[count].start();
					count += 1;
				} else {
					boolean check = false;
					while (check == false) {
						for (int i = 0; i < thrArr.length; i++) {
							if (thrArr[i].isAlive() == false) {
								thrArr[i] = new Thread(fct);
								thrArr[i].start();
								check = true;
								break;
							}
						}
						try {
							thr.sleep(50);
						} catch (InterruptedException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
				}
			}
			for (int i = 0; i < thrArr.length; i++) {
				try {
					thrArr[i].join();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

		} else {
			System.out.println("Entered file is not a directory.");
		}

		System.out.println("Done!");

	}

}
