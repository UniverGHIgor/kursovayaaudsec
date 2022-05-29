package ru.mirea.osintkurs;

//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.SQLException;
//import java.sql.Statement;
//import java.util.Scanner;
// import java.util.*;
import java.sql.*;

public class SQL {
    protected Connection conn = null;
    protected String  url,namebase,pass,table;
    protected Statement stmt = null;
    protected String nickname = null, mail = null, password = null;

    public SQL(String url,String namebase,String pass,String table) {
        try {
            this.url=url;
            this.namebase=namebase;
            this.pass=pass;
            this.table=table;
            conn = DriverManager.getConnection(url,namebase,pass);
            stmt = conn.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
