package uni;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

import uni.comparators.StudentNameComparator;
import uni.comparators.StudentSurnameComparator;
import uni.exceptions.GroupOverflowException;
import uni.exceptions.NoSuchStudentException;

public class Group {

	private final int groupSize = 10;
	private List<Student> students = new ArrayList<>(groupSize);
	private String name;

	public Group() {
		super();
	}

	public Group(String name) {
		super();
		this.name = name;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
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
		if (students.size() < groupSize) {
			students.add(student);
			count += 1;
		}
		if (count == 0) {
			throw new GroupOverflowException();
		}
	}

	public void fireStudent(int id) throws NoSuchStudentException {
		int count = 0;
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getId() == id) {
				students.remove(i);
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
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getSurname().equals(surname)) {
				sought = students.get(i);
				break;
			}
		}
		if (sought == null) {
			throw new NoSuchStudentException();
		}
		return sought;
	}

	public List<Student> sortStudentsByLastName() {

		List<Student> buffer = new ArrayList<>(students);
		Collections.sort(buffer, new StudentSurnameComparator().thenComparing(new StudentNameComparator()));
		return buffer;

	}

	public boolean equilCheck() {
		for (int i = 0; i < students.size(); i++) {
			for (int j = i; j < students.size(); j++) {
				if (students.get(i).equals(students.get(j)) && i != j) {
					System.out.println("Students by the indexes " + i + " and " + j + " are equal!");
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + students.hashCode();
		result = prime * result + Objects.hash(name);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Group other = (Group) obj;
		return Objects.equals(name, other.name) && students.equals(other.students);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("The group is empty!");
//		Student[] arr = sortStudentsByLastName();
		List<Student> arr = sortStudentsByLastName();
		sb.setLength(0);
		for (int i = 0; i < arr.size(); i++) {
			sb.append(arr.get(i).getInfo() + "\n");

		}
		return sb.toString();
	}
}
