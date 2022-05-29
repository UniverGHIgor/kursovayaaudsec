package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;

public class SQLsearch {
    public static void search() {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538", "j06318538", "kursovaya");
            Statement stmt = null;
            Scanner scn = new Scanner(System.in);
            String nickname = null, mail = null, password = null;

            try {

                Class.forName("com.mysql.jdbc.Driver");

                System.out.print("You can choose search option: ");
                System.out.print("\n1) Search by nickname");
                System.out.print("\n2) Search by mail");
                System.out.print("\n3) Search by password");
                int i=scn.nextInt();
                while(i=1 | i=2 | i=3) {
                    i=scn.nextInt();
                }
                System.out.print("Enter your mail: ");
                mail = scn.nextLine();




                System.out.print("\nDeleting your data into table...");
                stmt = conn.createStatement();

                String deleteSql = "DELETE FROM j06318538.Popular WHERE mail = '"+mail+"'";


                PreparedStatement statement = conn.prepareStatement(deleteSql);
                statement.executeUpdate(deleteSql);


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
