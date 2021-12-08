package intrd;

public class Cat {

	private String name;
	private Integer age;
	private String colour;

	public Cat(String name, Integer age, String colour) {
		super();
		this.name = name;
		this.age = age;
		this.colour = colour;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	@Override
	public String toString() {
		return this.getName();
	}

}
