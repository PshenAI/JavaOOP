package elementSum;

import java.math.BigInteger;

public class Runner {

	public static void main(String[] args) {
		int[] intArr = new int[200_000_000];

		for (int i = 0; i < intArr.length; i++) {
			intArr[i] = (int) (Math.random() * 100);
		}

		arrSum(intArr);

		long startTime = System.nanoTime();
		int cpu = Runtime.getRuntime().availableProcessors();
		int diff0 = intArr.length / cpu;
		int diff1 = diff0;
		var thrArr = new Thread[cpu];
		var taskArr = new elementSumTask[cpu];

		for (int i = 0; i < cpu; i++) {
			if (i == 0) {
				taskArr[i] = new elementSumTask(intArr, 0, diff0);
				thrArr[i] = new Thread(taskArr[i]);
			} else if (i == cpu - 1) {
				taskArr[i] = new elementSumTask(intArr, diff1, intArr.length);
				thrArr[i] = new Thread(taskArr[i]);
			} else {
				taskArr[i] = new elementSumTask(intArr, diff1, diff1 + diff0);
				thrArr[i] = new Thread(taskArr[i]);
				diff1 = diff1 + diff0;
			}
		}

		for (int i = 0; i < thrArr.length; i++) {
			thrArr[i].start();
		}

		for (int j = 0; j < thrArr.length; j++) {
			try {
				thrArr[j].join();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		BigInteger multithreadSum = BigInteger.ZERO;
		for (int i = 0; i < taskArr.length; i++) {
			multithreadSum = multithreadSum.add(taskArr[i].getSum());
		}
		long endTime = System.nanoTime();
		System.out.println("Multithread method took: " + (endTime - startTime) + " nanoseconds and the sum is: "
				+ multithreadSum + ".");

	}

	public static BigInteger arrSum(int[] arr) {
		long startTime = System.nanoTime();
		BigInteger bg = BigInteger.ZERO;
		for (int i = 0; i < arr.length; i++) {
			bg = bg.add(BigInteger.valueOf(arr[i]));
		}
		long endTime = System.nanoTime();
		System.out.println(
				"Monothread method took: " + (endTime - startTime) + " nanoseconds and the sum is: " + bg + ".");
		return bg;

	}

}
