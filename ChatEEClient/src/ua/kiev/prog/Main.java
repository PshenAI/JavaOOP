package ua.kiev.prog;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CurrentUser cUser = CurrentUser.getInstance();
		Scanner scanner = new Scanner(System.in);
		try {
			System.out.println("Are you a new user?  \"yes\" || \"no\"");
			String newUser = scanner.nextLine();

			System.out.println("Enter your login: ");
			String login = scanner.nextLine();

			System.out.println("Enter your password: ");
			String password = scanner.nextLine();

			int auth = checkAuth(Utils.getURL() + "/check", login, password, newUser);

			cUser.setUser(login);

			if (auth != 200) {
				System.out.println("HTTP error occured: " + auth);
				return;
			}
			System.out.println("Successfully entered chat!");

			Thread th = new Thread(new GetThread());
			th.setDaemon(true);
			th.start();

            System.out.println("Enter your message: ");
			while (true) {
				String text = scanner.nextLine();
				if (text.isEmpty()) break;

				System.out.println("Who's the recipient?");
				String to = scanner.nextLine();

				Message m = new Message(login, to, text);
				int res = m.send(Utils.getURL() + "/add");

				if (res != 200) { // 200 OK
					System.out.println("HTTP error occured: " + res);
					return;
				}
			}
			try {
				exitServer(cUser.getLogin());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		} finally {
			scanner.close();
		}
	}

	public static int exitServer(String login) throws IOException{
		URL url = new URL(Utils.getURL() + "/online");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		try (OutputStream os = conn.getOutputStream()) {
			os.write(login.getBytes(StandardCharsets.UTF_8));
			return conn.getResponseCode();
		}
	}

	public static int checkAuth(String url, String login, String password, String newUser) throws IOException{
		URL obj = new URL(url);
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		try (OutputStream os = conn.getOutputStream()) {
			String userData = login + " " + password + " " + newUser;
			os.write(userData.getBytes(StandardCharsets.UTF_8));
			return conn.getResponseCode();
		}
	}
}
