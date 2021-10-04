package uni;

public abstract class Person {
	private String name;
	private String surname;
	private int age;
	private gender gender;

	public Person() {
		super();
	}

	public Person(String name, String surname, int age, uni.Person.gender gender) {
		super();
		this.name = name;
		this.surname = surname;
		this.age = age;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public gender getGender() {
		return gender;
	}

	public void setGender(gender gender) {
		this.gender = gender;
	}

	public enum gender {
		Male, Female
	}

	public abstract String getInfo();

	@Override
	public String toString() {
		return name + " " + surname + ", age is " + age + ", gender is " + gender + ".";
	}

}
