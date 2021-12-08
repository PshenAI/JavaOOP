package uni.comparators;

import java.util.Comparator;

import uni.Student;

public class StudentNameComparator implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {

		if (o1.getName().compareTo(o2.getName()) > 0) {
			return 1;
		}

		if (o1.getName().compareTo(o2.getName()) < 0) {
			return -1;
		}

		return 0;
	}
}
