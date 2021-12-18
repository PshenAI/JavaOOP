package ua.kiev.prog;

import java.util.ArrayList;
import java.util.List;

class Chatroom{
    private String name;
    private List<String> participants =  new ArrayList<>();
    private String owner;

    public Chatroom(String name, String owner) {
        this.name = name;
        this.owner = owner;
        participants.add(owner);
    }

    public String getName() {return name;}

    public List<String> getParticipants() {return participants;}

    public synchronized void add(String login){participants.add(login);}

    public synchronized void remove(String login){participants.remove(login);}

    @Override
    public String toString() {
        return "Chatroom{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }
}

public class ChatroomsList {

    private static final ChatroomsList ctl = new ChatroomsList();
    private final List<Chatroom> chatroomList = new ArrayList<>();

    public static ChatroomsList getInstance(){ return ctl;}

    public List<Chatroom> getList(){ return chatroomList; }

    public synchronized void add(Chatroom cr){ chatroomList.add(cr);}

    public synchronized void delete(String name){
        for (Chatroom room: chatroomList) {
            if (room.getName().equals(name)){
                chatroomList.remove(room);
                System.out.println(name + " room removed.");
            } else{
                System.out.println("No such room.");
            }
        }
    }

}
