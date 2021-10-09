package uni;

import java.util.Arrays;
import java.util.Comparator;

import uni.comparators.StudentNameComparator;
import uni.comparators.StudentSurnameComparator;
import uni.exceptions.GroupOverflowException;
import uni.exceptions.NoSuchStudentException;

public class Group {

	private Student[] students = new Student[10];
	private String name;

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public Student[] getStudents() {
		return students;
	}

	public void setStudents(Student[] students) {
		this.students = students;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void addStudent(Student student) throws GroupOverflowException {
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				students[i] = student;
				count += 1;
				break;
			}
		}
		if (count == 0) {
			throw new GroupOverflowException();
		}
	}

	public void fireStudent(int id) throws NoSuchStudentException {
		int count = 0;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				continue;
			}
			if (students[i].getId() == id) {
				students[i] = null;
				count += 1;
				break;
			}
		}
		if (count == 0) {
			throw new NoSuchStudentException();
		}
	}

	public Student searchStudent(String surname) throws NoSuchStudentException {
		Student sought = null;
		for (int i = 0; i < students.length; i++) {
			if (students[i] == null) {
				continue;
			}
			if (students[i].getSurname().equals(surname)) {
				sought = students[i];
				break;
			}
		}
		if (sought == null) {
			throw new NoSuchStudentException();
		}
		return sought;
	}

	public Student[] sortStudentsByLastName() {
		Student[] sortStud = Arrays.copyOf(students, students.length);
		Arrays.sort(sortStud,
				Comparator.nullsLast(new StudentSurnameComparator().thenComparing(new StudentNameComparator())));

		return sortStud;

	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The group is empty!");
		Student[] arr = sortStudentsByLastName();
		sb.setLength(0);
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] != null) {
				sb.append(arr[i].getInfo() + "\n");
			} else {
				continue;
			}
		}
		return sb.toString();
	}
}
