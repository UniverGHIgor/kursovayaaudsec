package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;

class Employee extends sqlconnect {


    public static class SQLInsert {

        public static void main() {
            Connection conn = DriverManager.getConnection(url, username, pass);
            Statement stmt = null;
            Scanner scn = new Scanner(System.in);
            String nickname = null, mail = null, password = null;

            try {
                Class.forName("com.mysql.jdbc.Driver");

                System.out.print("Enter your nickname: ");
                nickname = scn.nextLine();

                System.out.print("Enter your mail: ");
                mail = scn.nextLine();

                System.out.print("Enter your password: ");
                password = scn.nextLine();


                System.out.print("\nInserting your data into table...");
                stmt = conn.createStatement();

                String insertSql = "INSERT INTO popular (nickname, mail, password) VALUES (?, ?, ?)";

                PreparedStatement statement = conn.prepareStatement(insertSql);
                statement.setString(1, "volodka");
                statement.setString(2, "volodya2006gmail.com");
                statement.setString(3, "volodyakrutoy");
                statement.executeUpdate(insertSql);


                System.out.println(" SUCCESS!\n");

            } catch(SQLException se) {
                se.printStackTrace();
            } catch(Exception e) {
                e.printStackTrace();
            } finally {
                try {
                    if(stmt != null)
                        conn.close();
                } catch(SQLException se) {
                }
                try {
                    if(conn != null)
                        conn.close();
                } catch(SQLException se) {
                    se.printStackTrace();
                }
            }
            System.out.println("Thank you for your patronage!");
        }
    }
}

