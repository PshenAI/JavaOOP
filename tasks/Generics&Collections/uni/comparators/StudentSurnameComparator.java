package uni.comparators;

import java.util.Comparator;

import uni.Student;

public class StudentSurnameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		if (o1.getSurname().compareTo(o2.getSurname()) > 0) {
			return 1;
		}

		if (o1.getSurname().compareTo(o2.getSurname()) < 0) {
			return -1;
		}

		return 0;
	}

}
