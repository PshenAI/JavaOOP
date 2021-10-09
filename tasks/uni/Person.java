package uni;

public abstract class Person {
	private String name;
	private String surname;
	private int age;
	private Gender gender;

	public Person() {
		super();
	}

	public Person(String name, String surname, int age, uni.Person.Gender gender) {
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

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public enum Gender {
		Male, Female
	}

	public abstract String getInfo();

	@Override
	public String toString() {
		return surname + " " + name + ", age is " + age + ", gender is " + gender + ".";
	}

}
