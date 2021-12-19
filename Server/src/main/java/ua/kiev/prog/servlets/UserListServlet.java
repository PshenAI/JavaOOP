package ua.kiev.prog.servlets;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ua.kiev.prog.dataBases.AllUsers;
import ua.kiev.prog.dataBases.OnlineUsers;
import ua.kiev.prog.ReaderClass;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;

@WebServlet(name = "UserListServlet", urlPatterns = "/online")
public class UserListServlet extends HttpServlet {

    private OnlineUsers ou = OnlineUsers.getInstance();
    private AllUsers au = AllUsers.getInstance();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String all = req.getParameter("all");
        String status = req.getParameter("status");
        String result;
        if(all != null){
            result = au.toJSON();
        } else {
            result = ou.toJSON();
        }


        if(status != null && ou.userStatus(status)){
            result = "true";
        }
        if(status != null && !ou.userStatus(status)){
            result = "false";
        }
        OutputStream os = resp.getOutputStream();
        byte[] buf = result.getBytes(StandardCharsets.UTF_8);
        os.write(buf);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        byte[] buf = ReaderClass.requestBodyToArray(req);
        String bufStr = new String(buf, StandardCharsets.UTF_8);
        ou.remove(bufStr);
        System.out.println(bufStr + " went offline.");
    }

}
