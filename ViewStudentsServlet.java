package com.sms.servlets;

import com.sms.util.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/ViewStudentsServlet")
public class ViewStudentsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");

        DBConnection db = new DBConnection();

        try (Connection conn = db.getConnection();
             PrintWriter out = response.getWriter()) {

            out.println("<html><head><title>Students</title>");
            out.println("<link rel='stylesheet' href='styles.css'>");
            out.println("</head><body>");
            out.println("<div class='container'><h2>Students List</h2>");
            out.println("<a class='btn' href='add_student.jsp'>Add New Student</a> ");
            out.println("<a class='btn secondary' href='index.jsp'>Home</a>");
            out.println("<table class='table'>");
            out.println("<tr>"
                    + "<th>ID</th>"
                    + "<th>Name</th>"
                    + "<th>Roll No</th>"
                    + "<th>Class</th>"
                    + "<th>Email</th>"
                    + "<th>Phone</th>"
                    + "<th>Actions</th>"
                    + "</tr>");

            String sql = "SELECT * FROM students ORDER BY id DESC";
            try (PreparedStatement ps = conn.prepareStatement(sql);
                 ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    String rollNo = rs.getString("roll_no");
                    String className = rs.getString("class");
                    String email = rs.getString("email");
                    String phone = rs.getString("phone");

                    out.println("<tr>");
                    out.println("<td>" + id + "</td>");
                    out.println("<td>" + name + "</td>");
                    out.println("<td>" + rollNo + "</td>");
                    out.println("<td>" + className + "</td>");
                    out.println("<td>" + email + "</td>");
                    out.println("<td>" + phone + "</td>");
                    out.println("<td>"
                            + "<a class='inline-action' href='edit_student.jsp?id=" + id + "'>Edit</a>"
                            + "<a class='inline-action' href='DeleteStudentServlet?id=" + id
                            + "' onclick=\"return confirm('Are you sure you want to delete this student?');\">Delete</a>"
                            + "</td>");
                    out.println("</tr>");
                }
            }

            out.println("</table>");
            out.println("</div></body></html>");

        } catch (SQLException e) {
            throw new ServletException("Database error while fetching student records", e);
        }
    }
}
