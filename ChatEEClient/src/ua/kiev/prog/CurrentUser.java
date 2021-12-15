package ua.kiev.prog;

public class CurrentUser {

    private static final CurrentUser cUser = new CurrentUser();
    private String login;

    public static CurrentUser getInstance() { return cUser; }

    public void setUser(String login){ this.login = login;}

    public String getLogin() {
        return login;
    }
}
