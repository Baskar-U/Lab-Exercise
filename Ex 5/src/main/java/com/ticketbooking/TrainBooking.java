package com.ticketbooking;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/TrainBooking")
public class TrainBooking extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination = request.getParameter("destination");
        String adults = request.getParameter("adults");
        String children = request.getParameter("children");

        // Process booking logic here

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Train booked successfully!</h1>");
        out.println("<p>Destination: " + destination + "</p>");
        out.println("<p>Adults: " + adults + "</p>");
        out.println("<p>Children: " + children + "</p>");
    }
}
