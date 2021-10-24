package uni;

import java.util.Objects;

import uni.exceptions.GenderChoiceException;

public class Student extends Person implements CSVConverter {
	private int id;
	private String group;

	public Student(String name, String surname, int age, uni.Person.Gender gender) {
		super(name, surname, age, gender);
	}

	public Student(int id, String group, String name, String surname, int age, uni.Person.Gender gender) {
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
	public String getInfo() {
		return "Student name is " + super.toString() + ", ID is " + id + ", group is " + group + ".";
	}

	@Override
	public String toCSVString() {
		StringBuilder sb = new StringBuilder();
		sb.append(this.getId() + "," + this.getGroup() + "," + this.getName() + "," + this.getSurname() + ","
				+ this.getAge() + "," + this.getGender().toString());
		return sb.toString();
	}

	@Override
	public Student fromCSVString(String str) throws GenderChoiceException {
		String[] strArr = str.split(",");
		if (strArr[strArr.length - 1].equals("Male")) {
			Student st = new Student(Integer.parseInt(strArr[0]), strArr[1], strArr[2], strArr[3],
					Integer.parseInt(strArr[4]), Gender.Male);
			return st;
		} else if (strArr[strArr.length - 1].equals("Female")) {
			Student st = new Student(Integer.parseInt(strArr[0]), strArr[1], strArr[2], strArr[3],
					Integer.parseInt(strArr[4]), Gender.Female);
			return st;
		} else {
			throw new GenderChoiceException();
		}

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

}
