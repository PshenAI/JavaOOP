package ua.kiev.prog;

import java.util.Date;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.persistence.*;

@Entity
@Table(name = "Messages")
public class Message {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date = new Date();
	private String fromUser;
	private String toUser;
	private String text;
	private String chatRoom;

//	public Message(String from,String to, String text) {
//		this.from = from;
//		this.to = to;
//		this.text = text;
//	}

	public Message(){}

	public Message(String from,String to, String text, String chatRoom) {
		this.fromUser = from;
		this.toUser = to;
		this.text = text;
		this.chatRoom = chatRoom;
	}

	public String toJSON() {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.toJson(this);
	}
	
	public static Message fromJSON(String s) {
		Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd HH:mm:ss").create();
		return gson.fromJson(s, Message.class);
	}
	@Override
	public String toString() {
		return new StringBuilder().append("[").append(date).append(", Chatroom: ").append(chatRoom)
				.append(", From: ").append(fromUser).append(", To: ").append(toUser)
				.append("] ").append(text)
				.toString();
	}

//	@Override
//	public String toString() {
//		return new StringBuilder().append("[").append(date)
//				.append(", From: ").append(from).append(", To: ").append(to)
//				.append("] ").append(text)
//                .toString();
//	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getFromUser() {
		return fromUser;
	}

	public void setFromUser(String fromUser) {
		this.fromUser = fromUser;
	}

	public String getToUser() {
		return toUser;
	}

	public void setToUser(String toUser) {
		this.toUser = toUser;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getChatRoom() {return chatRoom;}

	public void setChatRoom(String chatRoom) {this.chatRoom = chatRoom;}
}
