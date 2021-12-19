package ua.kiev.prog;

import java.util.ArrayList;
import java.util.List;

public class Chatroom {
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
