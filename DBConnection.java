package com.sms.util;


import java.sql.*;


public class DBConnection {
private static final String URL = "jdbc:mysql://localhost:3306/student_management?useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=UTC";
private static final String USER = "root"; // change if needed
private static final String PASS = ""; // change if needed


static {
try {
Class.forName("com.mysql.cj.jdbc.Driver");
} catch (ClassNotFoundException e) {
e.printStackTrace();
}
}


public Connection getConnection() throws SQLException {
return DriverManager.getConnection(URL, USER, PASS);
}
}