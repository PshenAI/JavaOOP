package factorialTask;

import java.math.BigInteger;

public class FactorialTask implements Runnable {

	int number;

	public FactorialTask(int number) {
		super();
		this.number = number;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	@Override
	public void run() {
		var thr = Thread.currentThread();
		var fact = BigInteger.ONE;
		for (int i = 1; i <= number; i++) {
			fact = fact.multiply(BigInteger.valueOf(i));
		}
		if (!thr.getName().equals("Thread-0"))
			System.out.println(thr.getName() + " calculated : " + fact);

	}

}
