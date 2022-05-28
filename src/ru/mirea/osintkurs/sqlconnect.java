package ru.mirea.osintkurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.*;


public class sqlconnect {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.jdbc.Driver");
    }
    public static void main() {

        String url = "jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538";
        String username = "j06318538";
        String password = "kursovaya";

        System.out.println("Connecting database...");

        try (Connection connection = DriverManager.getConnection(url, username, password)) {
            System.out.println("Database connected!");
            String insertSql = "INSERT INTO j06318538.popular (nickname, mail, password) VALUES "
                    + "('volodka', 'volodya2006@gmail.com', 'volodyakrutoy');";
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }

    }
}
