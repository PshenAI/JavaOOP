package ua.kiev.prog;

public class CurrentUser {

    private static final CurrentUser cUser = new CurrentUser();
    private String login;
    private String chatRoom;

    public static CurrentUser getInstance() { return cUser; }

    public void setUser(String login){ this.login = login;}

    public String getLogin() {
        return login;
    }

    public String getChatRoom() {return chatRoom;}

    public void setChatRoom(String chatRoom) {this.chatRoom = chatRoom;}
}
