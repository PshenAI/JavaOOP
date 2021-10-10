package uni.comparators;

import java.util.Comparator;

import uni.Student;

public class StudentSurnameComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student st1 = (Student) o1;
		Student st2 = (Student) o2;

		if (st1.getSurname().compareTo(st2.getSurname()) > 0) {
			return 1;
		}

		if (st1.getSurname().compareTo(st2.getSurname()) < 0) {
			return -1;
		}

		return 0;
	}

}
