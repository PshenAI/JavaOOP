package ua.kiev.prog.servlets;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import ua.kiev.prog.AuthData;
import ua.kiev.prog.OnlineUsers;
import ua.kiev.prog.ReaderClass;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

@WebServlet(name = "CheckServlet", urlPatterns = "/check")
public class CheckServlet extends HttpServlet {

    private AuthData authData = AuthData.getInstance();
    private OnlineUsers ou = OnlineUsers.getInstance();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
        String[] userData = bufStr.split(" ");
        if(userData[2].equals("yes") && !userData[0].equals("") && !userData[1].equals("")){
            authData.add(userData);
            ou.add(userData[0]);
            System.out.println(ou.getList());
            System.out.println(userData[0] + " is online.");
        } else if(userData[2].equals("no") && authData.get(userData[0]).equals(userData[1])){
            ou.add(userData[0]);
            System.out.println(ou.getList());
            System.out.println(userData[0] + " is online.");
        } else {
            resp.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
