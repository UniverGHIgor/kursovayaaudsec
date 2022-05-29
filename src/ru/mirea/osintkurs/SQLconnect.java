package ru.mirea.osintkurs;
import java.sql.*;

public class SQLconnect extends SQL{


    public SQLconnect(String url, String namebase, String pass, String table) {
        super(url, namebase, pass, table);
    }

    public void Startconnect() {
        System.out.println("Connecting database...");
        try (Connection connection = DriverManager.getConnection(url, namebase, pass)) {
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        }
    }
}
