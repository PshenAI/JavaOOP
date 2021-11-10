package filters;

import java.util.Objects;

public class Cat implements Comparable<Cat> {

	private String name;
	private Integer weight;

	public Cat(String name, int weight) {
		super();
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
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
		return this.weight.compareTo(o.weight);
	}

	@Override
	public int hashCode() {
		return Objects.hash(weight, name);
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
		return weight == other.weight && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Cat [name=" + name + ", weight=" + weight + "]";
	}

}
