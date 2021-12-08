package availableSite;

import java.io.File;
import java.io.IOException;

public class Runner {

	public static void main(String[] args) {
		File fl = new File("Links.txt");
		try {
			CheckSiteService.checkSite(fl);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
