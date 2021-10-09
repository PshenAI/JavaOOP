package uni;

import uni.exceptions.WrongCSVFormatException;

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
		sb.append(this.getId() + ";" + this.getGroup() + ";" + this.getName() + ";" + this.getSurname() + ";"
				+ this.getAge() + ";" + this.getGender().toString());
		return sb.toString();
	}

	@Override
	public Student fromCSVString(String str) throws WrongCSVFormatException {
		String[] strArr = str.split(";");
		if (strArr[strArr.length - 1].equals("Male")) {
			Student st = new Student(Integer.parseInt(strArr[0]), strArr[1], strArr[2], strArr[3],
					Integer.parseInt(strArr[4]), Gender.Male);
			return st;
		} else if (strArr[strArr.length - 1].equals("Female")) {
			Student st = new Student(Integer.parseInt(strArr[0]), strArr[1], strArr[2], strArr[3],
					Integer.parseInt(strArr[4]), Gender.Female);
			return st;
		} else {
			throw new WrongCSVFormatException();
		}

	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", group=" + group + "]";
	}

}
