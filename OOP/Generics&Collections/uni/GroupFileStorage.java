package uni;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import uni.exceptions.GenderChoiceException;
import uni.exceptions.GroupOverflowException;

public class GroupFileStorage {

	public void saveGroupToCSV(Group gr) throws IOException {

		File fl = new File(gr.getName() + ".csv");

		try (var pw = new PrintWriter(fl)) {
			Student[] students = new Student[gr.getStudents().size()];
			gr.getStudents().toArray(students);
			for (Student student : students) {
				if (student == null) {
					continue;
				}
				String temp = student.toCSVString() + "\n";
				pw.write(temp);
			}
		} catch (IOException e) {
			throw e;
		}

	}

	public Group loadGroupFromCSV(File file) throws IOException {
		Group gr = new Group();

		try (BufferedReader br = new BufferedReader(new FileReader(file))) {
			String studStr = "";
			Student jst = new Student(0, null, null, null, 0, null);
			for (;;) {
				studStr = br.readLine();
				if (studStr == null) {
					break;
				}
				try {
					jst = jst.fromCSVString(studStr);
				} catch (GenderChoiceException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				try {
					gr.addStudent(jst);
				} catch (GroupOverflowException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

			}
		} catch (IOException e) {
			throw e;
		}
		return gr;
	}

	public File findFileByGroupName(String groupName, File workFolder) {
		if (workFolder.isDirectory() == true) {
			File[] files = workFolder.listFiles();
			String[] folderNames = workFolder.list();
			for (int i = 0; i < folderNames.length; i++) {
				if (folderNames[i].equals(groupName)) {
					File fl = files[i];
					return fl;
				} else if (i == folderNames.length - 1) {
					System.out.println("There's no such file in enetered directory.");
					return null;
				}
			}
		} else {
			System.out.println("The path you've entered does not lead to directory.");
			return null;
		}
		return null;
	}

}
