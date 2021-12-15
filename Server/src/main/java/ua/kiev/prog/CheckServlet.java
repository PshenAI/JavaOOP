package ua.kiev.prog;

import jakarta.servlet.ServletOutputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

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
        byte[] buf = requestBodyToArray(req);
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

    private byte[] requestBodyToArray(HttpServletRequest req) throws IOException {
        InputStream is = req.getInputStream();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[10240];
        int r;

        do {
            r = is.read(buf);
            if (r > 0) bos.write(buf, 0, r);
        } while (r != -1);

        return bos.toByteArray();
    }
}
