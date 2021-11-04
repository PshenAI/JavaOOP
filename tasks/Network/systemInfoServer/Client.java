package systemInfoServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class Client implements Runnable {

	private SyncCounter syncount;
	private Socket soc;
	private String answ;
	Thread t;
	
	
		public Client(Socket soc, String answ, SyncCounter syncount) {
		super();
		this.syncount = syncount;
		this.soc = soc;
		this.answ = answ;
		t = new Thread(this);
		t.start();
	}
	public void run() {
		syncount.addCounter(t);
		try (InputStream is = soc.getInputStream();
				OutputStream os = soc.getOutputStream();
				PrintWriter pw = new PrintWriter(os)) {
			byte[] rec1 = new byte[is.available()];
			is.read(rec1);
			for (byte b : rec1) {
				System.out.print((char) b);
			}
			String response = "HTTP/1.1 200 OK\r\n" + "Server: My_Server\r\n" + "Content-Type: text/html\r\n"
					+ "Content-Length: " + "\r\n" + "Connection: close\r\n\r\n";
			String request = t.getName().replaceAll("\\D", "");
			answ = answ + request;
			pw.print(response + answ);
			pw.flush();
		} catch (IOException e) {
			System.out.println(e.toString());
		}
		syncount.deCounter(t);
	}
}
