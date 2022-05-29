package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
//import java.sql.PreparedStatement;
public class SQLInsert {
    static String nickname = null,
                  mail = null,
                  password = null;

    public static void Startinsert(String url, String username, String pass) {
        try {
            Connection conn = DriverManager.getConnection(url, username, pass);
            Statement stmt = conn.createStatement();
            Scanner scn = new Scanner(System.in);
            try {
                Class.forName("com.mysql.jdbc.Driver");

                System.out.print("Enter your nickname: ");
                nickname = scn.nextLine();

                System.out.print("Enter your mail: ");
                mail = scn.nextLine();

                System.out.print("Enter your password: ");
                password = scn.nextLine();

                System.out.print("\nInserting your data into table...");
                //stmt = conn.createStatement();

                String insertSql = "INSERT INTO "+username+".Popular (nickname, mail, password) VALUES "
                        + "('"+nickname+"','"+mail+"','"+password+"');";


                PreparedStatement statement = conn.prepareStatement(insertSql);
                statement.executeUpdate(insertSql);


                System.out.println(" SUCCESS!\n");

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt.close();
                conn.close();
            }
            System.out.println("Thank you for your patronage!");
        }
        catch (SQLException e) {

        }
    }
}