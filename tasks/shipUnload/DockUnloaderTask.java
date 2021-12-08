package shipUnload;

public class DockUnloaderTask implements Runnable {

	private Ship ship;
	private Dock dk;
	private Thread thr;

	public DockUnloaderTask(Ship ship, Dock dk) {
		super();
		this.ship = ship;
		this.dk = dk;
		thr = new Thread(this);
		thr.start();
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
		dk.shipUnloader(ship);
	}

}
