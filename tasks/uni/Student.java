package uni;

public class Student extends Person {
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
	public String toString() {
		return "Student [id=" + id + ", group=" + group + "]";
	}

}
