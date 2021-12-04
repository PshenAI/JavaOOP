package com.gamil.sicyaas.surveyhw;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "SurveyServlet", value = "/surveyResults")
public class SurveyServlet extends HttpServlet {
    static final String answ1 = "Patriarch";
    static final String answ2 = "Form of art";
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        List<String> answers = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            String temp = req.getParameter(String.valueOf(i));
            if(temp != null) {
                answers.add(temp);
            }
        }
        HttpSession session = req.getSession(true);
        if(answers.get(0).equals(answ1)){
            session.setAttribute("answ1", answ1 + " - right!");
        } else {
            session.setAttribute("answ1", answers.get(0)+ " - wrong!");
        }
        if(answers.get(1).equals(answ2)){
            session.setAttribute("answ2", answ2 + " - right!");
        } else {
            session.setAttribute("answ2", answers.get(1)+ " - wrong!");
        }
        String firstAnswer = (String)session.getAttribute("answ1");
        String secondAnswer = (String)session.getAttribute("answ2");
        PrintWriter pw = resp.getWriter();

        pw.println("<html>" +
                "<head><title>Survey results</title></head>" +
                "<body><h1> Your answers are...</h1><br>" +
                "<fieldset><h2>" + firstAnswer + "</h2></fieldset><br>" +
                "<fieldset><h2>" + secondAnswer + "</h2></fieldset></body>" +
                "</html>");
    }

}
