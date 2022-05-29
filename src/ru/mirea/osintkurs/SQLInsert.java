package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
//import java.sql.PreparedStatement;
public class SQLInsert extends SQL{
    public SQLInsert(String url, String namebase, String pass, String table) {
        super(url, namebase, pass, table);
        Startconnect();
    }
    public void Startinsert() {
        try {
            try {
                //Class.forName("com.mysql.jdbc.Driver");
                Scanner scn = new Scanner(System.in);
                System.out.print("Enter your nickname: ");
                nickname = scn.nextLine();

                System.out.print("Enter your mail: ");
                mail = scn.nextLine();

                System.out.print("Enter your password: ");
                password = scn.nextLine();

                System.out.print("\nInserting your data into table...");

                String insertSql = "INSERT INTO "+namebase+"."+table+" (nickname, mail, password) VALUES "
                        + "('"+nickname+"','"+mail+"','"+password+"');";
                stmt = conn.prepareStatement(insertSql);
                stmt.executeUpdate(insertSql);

                System.out.println(" SUCCESS!\n");

            } catch (SQLException se) {
                se.printStackTrace();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                stmt.close();
                conn.close();
            }
        }
        catch (SQLException e) {

        }
    }
}