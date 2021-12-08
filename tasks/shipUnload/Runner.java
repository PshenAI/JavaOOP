
package shipUnload;

public class Runner {

	public static void main(String[] args) {
		Ship sh1 = new Ship("Komurocho", 10);
		Ship sh2 = new Ship("Jupiter", 10);
		Ship sh3 = new Ship("Acropolis", 10);
		Ship sh4 = new Ship("Mazaya", 10);

		Ship[] ships = { sh1, sh2, sh3, sh4 };

		Dock a = new Dock(ships);
		a.startUnload();
	}

}
