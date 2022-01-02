package ua.kiev.prog.servlets;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ua.kiev.prog.dataBases.AllUsers;
import ua.kiev.prog.dataBases.AuthData;
import ua.kiev.prog.dataBases.OnlineUsers;
import ua.kiev.prog.ReaderClass;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "CheckServlet", urlPatterns = "/check")
public class CheckServlet extends HttpServlet {

    private AuthData authData = AuthData.getInstance();
    private OnlineUsers ou = OnlineUsers.getInstance();
    private AllUsers au = AllUsers.getInstance();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
        String[] userData = bufStr.split(" ");
        if(userData[2].equals("yes") && !userData[0].equals("") && !userData[1].equals("")){
            authData.add(userData);
            ou.add(userData[0]);
            au.add(userData[0]);
            System.out.println(au.getUsers());
            System.out.println(userData[0] + " is online.");
        } else if(userData[2].equals("no") && authData.get(userData[0]).equals(userData[1])){
            ou.add(userData[0]);
            au.add(userData[0]);
            System.out.println(au.getUsers());
            System.out.println(userData[0] + " is online.");
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
