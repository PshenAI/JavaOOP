package ua.kiev.prog;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.util.ISO8601Utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		CurrentUser cUser = CurrentUser.getInstance();
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();

		try(Scanner scanner = new Scanner(System.in)) {
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
			System.out.println("Which chatroom do you want to use? (Leave blank if you want to use Main)");
			String chatRoom = scanner.nextLine();
			if(!chatRoom.equals("") && !checkRoom(chatRoom, login) ){
				System.out.println("No such room or you don't have access to one. \nRedirecting to Main...");
				cUser.setChatRoom("Main");
			} else if(chatRoom.equals("")){
				cUser.setChatRoom("Main");
			} else {
				cUser.setChatRoom(chatRoom);
			}

			System.out.println("Successfully entered chat!");

			Thread th = new Thread(new GetThread());
			th.setDaemon(true);
			th.start();

            System.out.println("Enter the message or command: ");
			while (true) {
				String text = scanner.nextLine();
				if (text.isEmpty()) break;

				if(text.startsWith("-")){
					String request = "";
					if(text.equals("-getUsers")){
						System.out.println(getOnlineUsers(gson));
					} else if(text.equals("-getStatus")){
						System.out.println("Whose status you want to check out?");
						request = scanner.nextLine();
						System.out.println(getUserStatus(request));
					} else if(text.equals("-newRoom")){
						System.out.println("Give a name to your room: ");
						request = scanner.nextLine();
						chatRoomControl(text, login, request);
					} else if(text.equals("-deleteRoom")){
						System.out.println("Which room you want to delete?");
						request = scanner.nextLine();
						chatRoomControl(text, login, request);
					} else if(text.equals("-enterRoom")){
						System.out.println("Which room you want to enter?");
						request = scanner.nextLine();
						chatRoomControl(text, login, request);
					} else if(text.equals("-leaveRoom")){
						System.out.println("Which room you want to leave?");
						request = scanner.nextLine();
						chatRoomControl(text, login, request);
					} else {
						System.out.println("Unknown command!");
					}
				} else {
					System.out.println("Who's the recipient?");
					String to = scanner.nextLine();

					Message m = new Message(login, to, text, chatRoom);
					int res = m.send(Utils.getURL() + "/add");

					if (res != 200) { // 200 OK
						System.out.println("HTTP error occured: " + res);
						return;
					}
				}
			}
			try {
				exitServer(cUser.getLogin());
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static boolean checkRoom(String name, String login) throws IOException{
		URL url = new URL(Utils.getURL() + "/chatRoom?room=" + name + "&user=" + login);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try(InputStream is = http.getInputStream()) {
			byte[] buf = ReaderClass.responseBodyToArray(is);
			String strBuf = new String(buf, StandardCharsets.UTF_8);
			if(strBuf.equals("true")){
				return true;
			}
			return false;
		}
	}

	private static int chatRoomControl(String command, String login, String roomName) throws IOException{
		URL obj = new URL(Utils.getURL() + "/chatRoom");
		HttpURLConnection conn = (HttpURLConnection) obj.openConnection();

		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		try (OutputStream os = conn.getOutputStream()) {
			String userData = command + " " + login + " " + roomName;
			os.write(userData.getBytes(StandardCharsets.UTF_8));
			return conn.getResponseCode();
		}

	}

	private static String getUserStatus(String login) throws IOException{
		String result;
		URL url = new URL(Utils.getURL() + "/online?status=" + login);
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try(InputStream is = http.getInputStream()) {
			byte[] buf = ReaderClass.responseBodyToArray(is);
			String strBuf = new String(buf, StandardCharsets.UTF_8);
			if(strBuf.equals("true")){
				result = login + " is online.";
			} else{
				result = login + " is offline.";
			}
			return result;
		}
	}

	private static List<String> getOnlineUsers(Gson gson) throws IOException {
		URL url = new URL(Utils.getURL() + "/online");
		HttpURLConnection http = (HttpURLConnection) url.openConnection();
		try(InputStream is = http.getInputStream()) {
			byte[] buf = ReaderClass.responseBodyToArray(is);
			String strBuf = new String(buf, StandardCharsets.UTF_8);
			List<String> users = gson.fromJson(strBuf, List.class);
			return users;
		}
	}

	private static int exitServer(String login) throws IOException{
		URL url = new URL(Utils.getURL() + "/online");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("POST");
		conn.setDoOutput(true);

		try (OutputStream os = conn.getOutputStream()) {
			os.write(login.getBytes(StandardCharsets.UTF_8));
			return conn.getResponseCode();
		}
	}

	private static int checkAuth(String url, String login, String password, String newUser) throws IOException{
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
