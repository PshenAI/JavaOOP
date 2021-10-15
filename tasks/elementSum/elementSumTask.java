package elementSum;

import java.math.BigInteger;

public class ElementSumTask implements Runnable {

	private int[] arr;
	private int indFrom;
	private int indTo;
	private BigInteger sum;

	public ElementSumTask(int[] arr, int indFrom, int indTo) {
		super();
		this.arr = arr;
		this.indFrom = indFrom;
		this.indTo = indTo;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	public int getIndFrom() {
		return indFrom;
	}

	public void setIndFrom(int indFrom) {
		this.indFrom = indFrom;
	}

	public int getIndTo() {
		return indTo;
	}

	public void setIndTo(int indTo) {
		this.indTo = indTo;
	}

	public BigInteger getSum() {
		return sum;
	}

	public void setSum(BigInteger sum) {
		this.sum = sum;
	}

	@Override
	public void run() {
		sum = BigInteger.ZERO;
		for (int i = indFrom; i < indTo; i++) {
			sum = sum.add(BigInteger.valueOf(arr[i]));
		}

	}

}
