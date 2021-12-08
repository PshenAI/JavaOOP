package comparator;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

	private String name;
	private Integer age;

	public Cat(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public int compareTo(Cat o) {
		if (o == null) {
			throw new NullPointerException();
		}
		if (this.getName().length() > o.getName().length()) {
			return 1;
		}
		if (this.getName().length() < o.getName().length()) {
			return -1;
		}
		return this.age.compareTo(o.age);
	}

	@Override
	public int hashCode() {
		return Objects.hash(age, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cat other = (Cat) obj;
		return age == other.age && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", age=" + age + "]";
	}

}