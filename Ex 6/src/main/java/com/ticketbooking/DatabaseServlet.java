package com.ticketbooking;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/DatabaseServlet")
public class DatabaseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "jdbc:mysql://localhost:3306/yourDB";
        String username = "root";
        String password = "password";
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection(url, username, password);
            String sql = "INSERT INTO bookings (destination, adults, children) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, request.getParameter("destination"));
            stmt.setInt(2, Integer.parseInt(request.getParameter("adults")));
            stmt.setInt(3, Integer.parseInt(request.getParameter("children")));
            stmt.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<h1>Booking added to database!</h1>");
    }
}
