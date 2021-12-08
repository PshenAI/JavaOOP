package uni;

import java.io.IOException;

import uni.Person.Gender;
import uni.exceptions.GroupOverflowException;

public class Runner {

	public static void main(String[] args) {
		Student ast = new Student(11111, null, "Aaron", "Velvetov", 20, Gender.Male);
		Student bst = new Student(33333, null, "David", "Kottov", 21, Gender.Male);
		Student cst = new Student(22222, null, "Boris", "Kotletov", 22, Gender.Male);
		Student dst = new Student(44444, null, "Kotto", "Velvetova", 19, Gender.Female);
		Student est = new Student(55555, null, "Katto", "Kottova", 22, Gender.Female);
		Student fst = new Student(66666, null, "Joel", "Mickelson", 20, Gender.Male);
		Student gst = new Student(77777, null, "Elly", "Bjorn", 18, Gender.Female);
		Student hst = new Student(88888, null, "Marlin", "Al", 25, Gender.Female);
		Student ist = new Student(99999, null, "Johnathan", "Safaro", 19, Gender.Male);

		Student[] tempArr = { ast, cst, dst, bst, est, fst, gst, hst, ist };

		Group first = new Group("8806");
		for (int i = 0; i < tempArr.length; i++) {
			if (tempArr[i] == null) {
				continue;
			}
			Student temp = tempArr[i];
			temp.setGroup(first.getName());
			try {
				first.addStudent(temp);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}
		}

		GroupFileStorage gfs = new GroupFileStorage();
		try {
			gfs.saveGroupToCSV(first);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		File fl0 = new File("C:\\Users\\Velvet X\\Documents\\Java OOP\\ExcptDz");
//		File fl1 = gfs.findFileByGroupName("8806.csv", fl0);

		System.out.println(first.toString());

	}

}
