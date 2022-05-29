package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;

class Employee extends sqlconnect {

    public static class SQLInsert {

        public static void main() {
            try {
                Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538", "j06318538", "kursovaya");
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

                    String insertSql = "INSERT INTO j06318538.Popular (nickname, mail, password) VALUES "
                            + "('volodka', 'volodya2006@gmail.com', 'volodyakrutoy');";

                    PreparedStatement statement = conn.prepareStatement(insertSql);
                    statement.executeUpdate(insertSql);


                    System.out.println(" SUCCESS!\n");

                } catch (SQLException se) {
                    se.printStackTrace();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (stmt != null)
                            conn.close();
                    } catch (SQLException se) {
                    }
                    try {
                        if (conn != null)
                            conn.close();
                    } catch (SQLException se) {
                        se.printStackTrace();
                    }
                }
                System.out.println("Thank you for your patronage!");
            }
            catch (SQLException e) {}
        }
    }
}

