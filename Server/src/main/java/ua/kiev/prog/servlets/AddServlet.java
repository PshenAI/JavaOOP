package ua.kiev.prog.servlets;

import jakarta.servlet.http.*;
import ua.kiev.prog.Message;
import ua.kiev.prog.MessageList;
import ua.kiev.prog.ReaderClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class AddServlet extends HttpServlet {

	private MessageList msgList = MessageList.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

		Message msg = Message.fromJSON(bufStr);
		if (msg != null)
			msgList.add(msg);
		else
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}

}
