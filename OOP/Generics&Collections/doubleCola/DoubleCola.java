package doubleCola;

import java.util.Deque;
import java.util.Scanner;

public class DoubleCola {

	private Deque<String> queue;

	public DoubleCola(Deque<String> queue) {
		super();
		this.queue = queue;
	}

	public Deque<String> getQueue() {
		return queue;
	}

	public void setQueue(Deque<String> queue) {
		this.queue = queue;
	}

	public void drink() {
		Scanner sc = new Scanner(System.in);
		System.out.println("How many colas were consumed?");
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String temp = queue.peek();
			queue.pop();
			queue.add(temp);
			queue.add(temp);
		}
		System.out.println(queue);

	}

	@Override
	public String toString() {
		return "DoubleCola [queue=" + queue + "]";
	}

}
