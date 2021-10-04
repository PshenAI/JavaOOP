package uni;

import uni.Person.gender;
import uni.exceptions.GroupOverflowException;

public class Runner {

	public static void main(String[] args) {
		Student ast = new Student(11111, null, "Aaron", "Velvetov", 20, gender.Male);
		Student bst = new Student(33333, null, "David", "Kottov", 21, gender.Male);
		Student cst = new Student(22222, null, "Boris", "Kotletov", 22, gender.Male);
		Student dst = new Student(44444, null, "Kotto", "Velvetova", 19, gender.Female);
		Student est = new Student(55555, null, "Katto", "Kottova", 22, gender.Female);
		Student fst = new Student(66666, null, "Aaron", "Kotletov", 23, gender.Male);

		Student[] tempArr = { ast, fst, cst, dst, bst, est };

		Group first = new Group("8806");
		for (int i = 0; i < tempArr.length; i++) {
			Student temp = tempArr[i];
			temp.setGroup(first.getName());
			try {
				first.addStudent(temp);
			} catch (GroupOverflowException e) {
				e.printStackTrace();
			}

		}
		System.out.println(first.toString());
	}

}
