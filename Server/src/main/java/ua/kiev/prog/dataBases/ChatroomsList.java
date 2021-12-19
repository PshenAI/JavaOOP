package ua.kiev.prog.dataBases;

import ua.kiev.prog.Chatroom;

import java.util.ArrayList;
import java.util.List;

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
