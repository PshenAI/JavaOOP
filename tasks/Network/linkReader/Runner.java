package linkReader;

public class Runner {

	public static void main(String[] args) {
		String url = "https://www.hltv.org";
		LinkReader lr = new LinkReader(url);
		lr.linksFromHtml();

	}

}
