package asciiWriter;

public class Runner {

	public static void main(String[] args) {
		String test = "A horse with no name";
		AsciiWriter aw = new AsciiWriter(test);
		aw.outputInAscii();
	}

}
