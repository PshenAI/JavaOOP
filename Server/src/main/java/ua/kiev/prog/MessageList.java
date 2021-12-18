package ua.kiev.prog;

import java.util.LinkedList;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MessageList {
	private static final MessageList msgList = new MessageList();

    private final Gson gson;
	private final List<Message> list = new LinkedList<>();
	
	public static MessageList getInstance() {
		return msgList;
	}
  
  	private MessageList() {
		gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
	}
	
	public synchronized void add(Message m) {
		list.add(m);
	}
	
	public synchronized String toJSON(int n, String rec, String room) {
		List<Message> temp = new LinkedList<>();
		for (Message m : list) {
			if(m.getChatRoom().equals("")){
				m.setChatRoom("Main");
			}
			if(m.getTo().equals("")){
				m.setTo("everyone");
			}
			if(m.getTo().equals("everyone") && m.getChatRoom().equals(room)){
				temp.add(m);
			} else if(m.getTo().equals(rec) && m.getChatRoom().equals(room)){
				System.out.println(m.getChatRoom().equals(room) + " " + m.getChatRoom() + " " + room);
				temp.add(m);
			}
		}
		if((n >= temp.size())) { return null; }
		return gson.toJson(new JsonMessages(temp, n));
	}
}
