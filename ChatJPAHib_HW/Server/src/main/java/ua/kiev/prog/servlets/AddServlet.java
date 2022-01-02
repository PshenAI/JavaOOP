package ua.kiev.prog.servlets;

import jakarta.servlet.http.*;
import ua.kiev.prog.Message;
import ua.kiev.prog.dataBases.MessageList;
import ua.kiev.prog.ReaderClass;
import javax.persistence.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class AddServlet extends HttpServlet {

	static EntityManagerFactory emf = Persistence.createEntityManagerFactory("ChatJPA");
	static EntityManager em= emf.createEntityManager();

	private MessageList msgList = MessageList.getInstance();

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);

		Message msg = Message.fromJSON(bufStr);
		if (msg != null){
			if(msg.getChatRoom().equals("")){
				msg.setChatRoom("Main");
			}
			if(msg.getToUser().equals("")){
				msg.setToUser("everyone");
			}
			System.out.println(msg);
			addToDB(msg);
			msgList.add(msg);
		}  else
			resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
	}

	private void addToDB(Message m){
		try{
			em.getTransaction().begin();
			em.persist(m);
			em.getTransaction().commit();
		} catch(Exception ex){
			em.getTransaction().rollback();
		}

	}

}
