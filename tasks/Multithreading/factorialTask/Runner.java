package factorialTask;

public class Runner {

	public static void main(String[] args) {

		var curThr = Thread.currentThread();

		System.out.println(curThr.getName() + " started.");

		var thrArr = new Thread[100];

		for (int i = 0; i < thrArr.length; i++) {
			var ft1 = new FactorialTask(i);
			var thr1 = new Thread(ft1);
			thrArr[i] = thr1;
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

		System.out.println(curThr.getName() + " done.");
	}

}
