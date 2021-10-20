package classContainer;

import java.util.Arrays;

public class ClassContainer {
	private Object[] container;

	public ClassContainer(Object[] container) {
		super();
		this.container = container;
	}

	public Object[] getContainer() {
		return container;
	}

	public void setContainer(Object[] container) {
		this.container = container;
	}

	public void push(Object obj) {
		Object[] newCont = new Object[container.length + 1];
		for (int i = 0; i < container.length; i++) {
			newCont[i + 1] = container[i];
		}
		newCont[0] = obj;
		container = newCont;
	}

	public Object pop() {
		Object temp = container[0];
		Object[] newCont = new Object[container.length - 1];
		for (int i = 0; i < newCont.length; i++) {
			newCont[i] = container[i + 1];
		}
		container = newCont;
		return temp;
	}

	public Object peek() {
		Object temp = container[0];
		return temp;
	}

	@Override
	public String toString() {
		String buff = "Container contains:\n";
		for (Object object : container) {
			buff += object + "\n";
		}
		return buff;
	}

}
