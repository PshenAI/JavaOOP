package goodsList;

public class Runner {

	public static void main(String[] args) {
		Goods gd1 = new Goods();
		gd1.setDescription("1-hour house mixtape.flac.");
		gd1.setMass(348);
		gd1.setPrice(15);

		Goods gd2 = new Goods(5, "Lo-Fi playlist.mp3.", 1231);
		gd2.sellNotif();

		System.out.println();

		System.out.println(gd1.toString());
		System.out.println(gd2.toString());
	}

}
