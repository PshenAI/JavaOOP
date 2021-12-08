package shipUnload;

public class Dock {

	private Ship[] ships;
	private int shipNumber;
	private DockUnloaderTask dk;

	public Dock(Ship[] ships) {
		super();
		this.ships = ships;
	}

	public int getShipNumber() {
		return shipNumber;
	}

	public void setShipNumber(int shipNumber) {
		this.shipNumber = shipNumber;
	}

	public Ship[] getShips() {
		return ships;
	}

	public void setShips(Ship[] ships) {
		this.ships = ships;
	}

	public void startUnload() {
		for (int i = 0; i < ships.length; i++) {
			dk = new DockUnloaderTask(ships[i], this);
		}
	}

	public void shipUnloader(Ship ship) {
		for (; shipNumber >= 2;) {
			synchronized (this) {
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		shipNumber += 1;
		Thread thr = Thread.currentThread();
		System.out.println("Now unloading " + ship.getName());
		int count = ship.getCargo();
		for (int i = 0; i < count; i++) {
			ship.setCargo(ship.getCargo() - 1);
			try {
				thr.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if (ship.getCargo() == 0) {
				System.out.println(thr.getName() + " => " + ship.getName() + " is unloaded." + " Remained cargo = "
						+ ship.getCargo());
			}
		}
		shipNumber -= 1;
		synchronized (this) {
			notifyAll();
		}
	}

}