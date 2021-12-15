package ua.kiev.prog;

import java.util.HashMap;
import java.util.Map;

public class AuthData {

    private static final AuthData authData = new AuthData();
    private final Map<String, String> map = new HashMap<>();

    public static AuthData getInstance() {
        return authData;
    }

    public synchronized void add(String[] kv) {
        map.put(kv[0], kv[1]);
    }

    public synchronized String get(String key) { return map.get(key); }
}
