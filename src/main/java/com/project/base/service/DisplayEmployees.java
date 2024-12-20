package com.project.base.service;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/display")
public class DisplayEmployees extends HttpServlet {
    //private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstschematest", "root", "kinnu");

            String sql = "SELECT * FROM employee";
            PreparedStatement pstm = con.prepareStatement(sql);
            ResultSet rs = pstm.executeQuery();

            PrintWriter out = resp.getWriter();
            resp.setContentType("text/html");

            out.println("<html><head>");
            out.println("<style>");
            
            // General page styling with black background
            out.println("body { font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif; background-color: #121212; color: #fff; margin: 0; padding: 0; display: flex; justify-content: center; align-items: center; min-height: 100vh; overflow-y: auto; }");
            out.println(".container { background-color: #ffffff; padding: 20px; border-radius: 10px; box-shadow: 0 10px 20px rgba(0, 0, 0, 0.1); width: 80%; max-width: 1000px; text-align: center; }");
            
            // Heading styling
            out.println("h2 { font-size: 28px; color: #333; margin-bottom: 20px; font-weight: bold; }");

            // Table styling with white text in the black background
            out.println("table { width: 100%; border-collapse: collapse; margin-top: 20px; color: #fff; }");
            out.println("th, td { padding: 10px 15px; text-align: left; border: 1px solid #ddd; }");
            out.println("th { background-color: #6a11cb; color: #fff; font-size: 18px; }");
            out.println("tr:nth-child(even) { background-color: #333333; }");
            out.println("tr:nth-child(odd) { background-color: #444444; }"); // Slightly lighter row background

            // Button styling
            out.println("input[type='submit'] { background: linear-gradient(135deg, #2575fc, #6a11cb); color: white; border: none; padding: 8px 20px; border-radius: 8px; font-size: 16px; cursor: pointer; transition: all 0.3s ease; }");
            out.println("input[type='submit']:hover { background: linear-gradient(135deg, #6a11cb, #2575fc); transform: translateY(-2px); }");

            // Back button styling
            out.println(".back-btn { margin-top: 20px; padding: 10px 20px; background-color: #eee; border-radius: 8px; cursor: pointer; font-size: 16px; }");
            out.println(".back-btn:hover { background-color: #ccc; }");

            out.println("</style>");
            out.println("</head><body>");
            
            out.println("<div class='container'>");
            out.println("<h2>Employee List</h2>");
            out.println("<table>");
            out.println("<tr><th>ID</th><th>Name</th><th>Age</th><th>Email</th><th>Salary</th><th>Actions</th></tr>");

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int age = rs.getInt("age");
                String email = rs.getString("email");
                double sal = rs.getDouble("sal");

                out.println("<tr>");
                out.println("<td>" + id + "</td>");
                out.println("<td>" + name + "</td>");
                out.println("<td>" + age + "</td>");
                out.println("<td>" + email + "</td>");
                out.println("<td>" + sal + "</td>");
                out.println("<td>");
                out.println("<form action='ProjectUpdate.html' method='get' style='display:inline;'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<input type='submit' value='Update'>");
                out.println("</form>");
                out.println("<form action='ProjectDelete.html' method='post' style='display:inline;'>");
                out.println("<input type='hidden' name='id' value='" + id + "'>");
                out.println("<input type='submit' value='Delete'>");
                out.println("</form>");
                out.println("</td>");
                out.println("</tr>");
            }

            out.println("</table>");
            out.println("<form action='ProjectWelcome.html'>");
            out.println("<input class='back-btn' type='submit' value='Back'>");
            out.println("</form>");
            out.println("</div>");
            out.println("</body></html>");

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }
}
