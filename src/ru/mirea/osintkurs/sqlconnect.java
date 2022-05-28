package ru.mirea.osintkurs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class sqlconnect {
    // Connect to your database.
    // Replace server name, username, and password with your credentials
    public static void main() {
        String connectionUrl =
                "jdbc:sqlserver://mysql.j06318538.myjino.ru:3306;"
                        + "database=j06318538;"
                        + "user=j06318538;"
                        + "encrypt=false;"
                ;

        String insertSql = "INSERT INTO j06318538.Popular (nickname, mail, password) VALUES "
                + "('volodka', 'volodya2006@gmail.com', 'volodyakrutoy');";

        ResultSet resultSet = null;


    }
}
