package sorting;

import java.util.Objects;

public class Student extends Person {
	private int id;
	private String group;

	public Student(String name, String surname, int age, Person.Gender gender) {
		super(name, surname, age, gender);
	}

	public Student(int id, String group, String name, String surname, int age, Person.Gender gender) {
		super(name, surname, age, gender);
		this.id = id;
		this.group = group;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGroup() {
		return group;
	}

	public void setGroup(String group) {
		this.group = group;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + Objects.hash(group, id);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (super.equals(obj) == false) {
			return false;
		}
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(group, other.group) && id == other.id && super.equals(obj);
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", group=" + group + "]";
	}

	@Override
	public String getInfo() {
		return "Student name is " + super.toString() + ", ID is " + id + ", group is " + group + ".";
	}

}
