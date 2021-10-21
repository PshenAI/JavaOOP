package shellsSort;

public class ShellsSort implements Runnable {

	private int[] array;
	private int begin;
	private int end;
	private Thread thr;
	private int index;
	private boolean stop = false;

	public ShellsSort(int[] array, int begin, int end) {
		super();
		this.array = array;
		this.begin = begin;
		this.end = end;
		thr = new Thread(this);
		thr.start();
		this.index = begin;
	}

	public Thread getThr() {
		return thr;
	}

	public int peekElement() {
		return array[index];
	}

	public int pollElement() {
		int temp = array[index];
		check();
		return temp;
	}

	public boolean isStop() {
		return stop;
	}

	@Override
	public void run() {
		int size = end - begin;
		int h = size / 2;
		int startPoint = begin + h;
		for (; startPoint > begin;) {
			for (int i = h; i < end; i++) {
				for (int j = i; j >= startPoint && array[j] < array[j - h]; j -= h) {
					int temp = array[j];
					array[j] = array[j - h];
					array[j - h] = temp;
				}
			}
			h = h / 2;
			startPoint = begin + h;
		}
	}

	private void check() {
		this.index++;
		if (this.index >= this.end) {
			this.stop = true;
		}
	}

}
