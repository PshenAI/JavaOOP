package ua.kiev.prog.dataBases;

import java.util.HashMap;
import java.util.Map;

public class AllUsers {

    private static final AllUsers allUsers = new AllUsers();

    private final Map<String, Integer> users = new HashMap<>();

    public static AllUsers getInstance(){return allUsers; }

    public Map<String, Integer> getUsers(){return users; }

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
