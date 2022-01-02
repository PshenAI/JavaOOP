package ua.kiev.prog.dataBases;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;


public class AllUsers {
    private final Gson gson = new GsonBuilder().create();
    private static final AllUsers allUsers = new AllUsers();

    private final Map<String, Integer> users = new HashMap<>();

    public static AllUsers getInstance(){return allUsers; }

    public Map<String, Integer> getUsers(){return users; }

    public String toJSON(){
        Set<String> temp = users.keySet();
        return gson.toJson(temp);
    }

    public synchronized void add(String login){
        int count = 1;
        if(users.get(login) == null){
            users.put(login, count);
        } else {
            count = users.get(login) + 1;
            users.put(login, count);
        }
    }
}
