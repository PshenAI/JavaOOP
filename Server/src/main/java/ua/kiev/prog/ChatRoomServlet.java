package ua.kiev.prog;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "ChatRoomServlet", urlPatterns = "/chatRoom")
public class ChatRoomServlet extends HttpServlet {

    private ChatroomsList chtl = ChatroomsList.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
        String[] userData = bufStr.split(" ");
        System.out.println("Got request " + userData[0]);
        if(userData[0].equals("-newRoom")){
            Chatroom chtr = new Chatroom(userData[2], userData[1]);
            chtl.add(chtr);
            System.out.println(chtl.getList());
        } else if(userData[0].equals("-deleteRoom")){
            for (Chatroom chtr: chtl.getList()) {
                if(chtr.getName().equals(userData[2])){
                    chtl.delete(chtr.getName());
                }
            }
        } else if(userData[0].equals("-enterRoom")){
            for (Chatroom chtr: chtl.getList()) {
                if(chtr.getName().equals(userData[2])){
                    chtr.add(userData[1]);
                    System.out.println(chtr.getParticipants());
                }
            }
        } else if(userData[0].equals("-leaveRoom")){
            for (Chatroom chtr: chtl.getList()) {
                if(chtr.getName().equals(userData[2])){
                    chtr.remove(userData[1]);
                    System.out.println(chtr.getParticipants());
                }
            }
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String room = req.getParameter("room");
        String user = req.getParameter("user");
        String respString = "";
        for (Chatroom chtr: chtl.getList()) {
            if (chtr.getName().equals(room) && chtr.getParticipants().contains(user)){
                respString = "true";
            } else{
                respString = "false";
            }
        }
        OutputStream os = resp.getOutputStream();
        byte[] buf = respString.getBytes(StandardCharsets.UTF_8);
        os.write(buf);
    }
}
