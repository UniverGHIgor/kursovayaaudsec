package ru.mirea.osintkurs;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.Statement;
import java.sql.*;

public class SQLconnect {
    // Connect to your database.
    // Replace server name, username, and password with your credentials

//    public static void jdbc(String[] args) throws Exception {
//        Class.forName("com.mysql.jdbc.Driver");
//    }
    public static void Startconnect(String url, String username, String pass) {
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, username, pass)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
