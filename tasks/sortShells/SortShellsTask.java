package sortShells;

public class SortShellsTask implements Runnable {

	private int[] arr;

	public SortShellsTask(int[] arr) {
		super();
		this.arr = arr;
	}

	public int[] getArr() {
		return arr;
	}

	public void setArr(int[] arr) {
		this.arr = arr;
	}

	@Override
	public void run() {
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
