package com.sms.servlet;
import com.sms.util.DBConnection;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.*;


@WebServlet("/AddStudentServlet")
public class AddStudentServlet extends HttpServlet {
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
String name = request.getParameter("name");
String roll = request.getParameter("roll_no");
String className = request.getParameter("className");
String email = request.getParameter("email");
String phone = request.getParameter("phone");


DBConnection db = new DBConnection();
try (Connection conn = db.getConnection()){
String sql = "INSERT INTO students (name, roll_no, class, email, phone) VALUES (?,?,?,?,?)";
try (PreparedStatement ps = conn.prepareStatement(sql)){
ps.setString(1, name);
ps.setString(2, roll);
ps.setString(3, className);
ps.setString(4, email);
ps.setString(5, phone);
ps.executeUpdate();
}
} catch (SQLException e) {
e.printStackTrace();
// ideally set an error message
}
response.sendRedirect("ViewStudentsServlet");
}
}