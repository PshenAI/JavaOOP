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
	
	public synchronized String toJSON(int n, String rec) {
		List<Message> temp = new LinkedList<>();
		for (Message m : list) {
			if(m.getTo().equals("")){
				m.setTo("everyone");
				temp.add(m);
			} else if( m.getTo().equals(rec) || m.getTo().equals("everyone")){
				temp.add(m);
			}
		}
		if((n >= temp.size())) { return null; }
		return gson.toJson(new JsonMessages(temp, n));
	}
}
