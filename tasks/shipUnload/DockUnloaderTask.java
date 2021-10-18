package shipUnload;

public class DockUnloaderTask implements Runnable {

	private Ship ship;
	private Dock dk;
	private Thread thr;
	private Object lock = new Object();

	public DockUnloaderTask(Ship ship, Dock dk) {
		super();
		this.ship = ship;
		this.dk = dk;
		thr = new Thread(this);
		thr.start();
	}

	public Object getLock() {
		return lock;
	}

	public void setLock(Object lock) {
		this.lock = lock;
	}

	public Ship getShip() {
		return ship;
	}

	public void setShip(Ship ship) {
		this.ship = ship;
	}

	public Dock getDk() {
		return dk;
	}

	public void setDk(Dock dk) {
		this.dk = dk;
	}

	@Override
	public void run() {
		queueChecker();
		dk.shipUnloader(ship);
	}

	public void queueChecker() {
		for (; dk.getShipNumber() >= 2;) {
			synchronized (lock) {
				try {
					lock.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}

}
