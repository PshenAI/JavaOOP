package sortShells;

import java.util.Arrays;

public class Runner {

	public static void main(String[] args) {

		int[] testArr = new int[100];
		for (int i = 0; i < testArr.length; i++) {
			testArr[i] = (int) (Math.random() * 100);
		}
		int[] copyArr = testArr.clone();

		long startCopyTime = System.nanoTime();
		shellSort(copyArr);
		long endCopyTime = System.nanoTime();
		System.out.println("Monothread method took: " + (endCopyTime - startCopyTime)
				+ " nanoseconds and the result is:\n" + Arrays.toString(copyArr));
		System.out.println();

		long startTime = System.nanoTime();
		int cpu = Runtime.getRuntime().availableProcessors();
		var sortTask = new SortShellsTask[cpu];
		var thrArr = taskCreator(testArr, sortTask, cpu);

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
		int[] resultArr = mergeSequence(sortTask, testArr);
		long endTime = System.nanoTime();
		System.out.println("Multithread method took: " + (endTime - startTime) + " nanoseconds and the result is:\n"
				+ Arrays.toString(resultArr));

	}

	public static int[] mergeSequence(SortShellsTask[] sortArr, int[] check) {
		int[] result = new int[check.length];
		int l = 0;
		int r = 0;
		int count = 0;
		int[] temp1 = sortArr[1].getArr();
		int[] temp0 = sortArr[0].getArr();
		for (int i = 0; i < temp1.length + temp0.length; i++) {
			if (l >= temp0.length) {
				result[i] = temp1[r];
				r += 1;
			} else if (r >= temp1.length) {
				result[i] = temp0[l];
				l += 1;
			} else if (temp0[l] < temp1[r]) {
				result[i] = temp0[l];
				l += 1;
			} else {
				result[i] = temp1[r];
				r += 1;
			}
		}
		count = temp1.length + temp0.length;

		for (int i = 0; i < sortArr.length - 1 && count != 100; i++) {
			int[] temp2 = new int[count];
			for (int j = 0; j < temp2.length; j++) {
				temp2[j] = result[j];
			}
			int[] temp3 = sortArr[i + 2].getArr();
			r = 0;
			l = 0;
			for (int j = 0; j < temp2.length + temp3.length; j++) {
				if (l >= temp2.length) {
					result[j] = temp3[r];
					r += 1;
				} else if (r >= temp3.length) {
					result[j] = temp2[l];
					l += 1;
				} else if (temp2[l] < temp3[r]) {
					result[j] = temp2[l];
					l += 1;
				} else {
					result[j] = temp3[r];
					r += 1;
				}
			}
			count += temp3.length;
		}

		return result;
	}

	public static Thread[] taskCreator(int[] testArr, SortShellsTask[] sortTask, int cpu) {
		int part = testArr.length / cpu;
		var thrArr = new Thread[cpu];
		for (int i = 0; i < cpu; i++) {
			if (i == cpu - 1) {
				int[] arr = new int[testArr.length - part * i];
				for (int j = 0; j < testArr.length - part * i; j++) {
					int step = i * part;
					arr[j] = testArr[step + j];
				}
				sortTask[i] = new SortShellsTask(arr);
				thrArr[i] = new Thread(sortTask[i]);
			} else {
				int[] arr = new int[part];
				for (int j = 0; j < part; j++) {
					int step = i * part;
					arr[j] = testArr[step + j];
				}
				sortTask[i] = new SortShellsTask(arr);
				thrArr[i] = new Thread(sortTask[i]);
			}

		}
		return thrArr;
	}

	public static void shellSort(int[] arr) {
		int h = arr.length / 2;
		for (; h > 0;) {
			for (int i = h; i < arr.length; i++) {
				for (int j = i; j >= h && arr[j] < arr[j - h]; j -= h) {
					int temp = arr[j];
					arr[j] = arr[j - h];
					arr[j - h] = temp;
				}
			}
			h = h / 2;
		}
	}

}
