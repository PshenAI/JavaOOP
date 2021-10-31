package systemInfoServer;

import java.util.concurrent.atomic.AtomicInteger;

public class SyncCounter {
	public AtomicInteger counter = new AtomicInteger(0);

	public synchronized void addCounter(Thread t) {
		counter.getAndIncrement();
		while (counter.get() > 1) {
			try {
				System.out.println(t.getName() + "---------------------------------------------------------------");
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public synchronized void deCounter(Thread t) {
		counter.getAndDecrement();
		notifyAll();
		System.out.println(t.getName() + "++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}

}
