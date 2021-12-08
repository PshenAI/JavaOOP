package systemInfoServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Runner {

	public static void main(String[] args) {
		int cpu = Runtime.getRuntime().availableProcessors();
		String userName = System.getProperty("user.name");
		String cpuName = System.getProperty("os.arch");
		String answer = "Server named " + userName + " got " + cpuName + " with " + cpu + " cores. "
				+ "Current request number is: ";

		try (ServerSocket soc = new ServerSocket(8080)) {
			for (;;) {
				SyncCounter sc = new SyncCounter();
				Socket clisoc = soc.accept();
				Client cli = new Client(clisoc, answer, sc);
			}

		} catch (IOException e) {
			System.out.println("Server couldn't start.");
		}

	}

}
