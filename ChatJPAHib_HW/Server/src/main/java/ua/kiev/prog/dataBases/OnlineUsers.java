package ua.kiev.prog.dataBases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class OnlineUsers {

    private static final OnlineUsers os = new OnlineUsers();
    private final Gson gson;
    private final List<String> onlineUsers = new ArrayList<>();

    private OnlineUsers(){ gson = new GsonBuilder().create();}

    public static OnlineUsers getInstance(){ return os; }

    public void add(String user){ onlineUsers.add(user); }

    public void remove(String user){ onlineUsers.remove(user); }

    public String toJSON(){
        return gson.toJson(onlineUsers);
    }

    public List<String> getList(){ return onlineUsers;}

    public boolean userStatus(String login){
        if(onlineUsers.contains(login)){
            return true;
        }
        return false;
    }

}
