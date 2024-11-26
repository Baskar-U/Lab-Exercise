package com.ticketbooking;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/PageCounter")
public class PageCounter extends HttpServlet {
    private int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        counter++;
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Number of visits: " + counter + "</h1>");
    }
}
