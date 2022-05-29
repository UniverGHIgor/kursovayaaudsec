package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;

public class SQLsearch {
    Connection conn = null;
    Statement stmt = null;
    Scanner scn = new Scanner(System.in);
    String nickname = null, mail = null, password = null;

    public SQLsearch() {
        try {
            conn = DriverManager.getConnection("jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538", "j06318538", "kursovaya");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void search_by(String args) throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.print("Enter your data: ");
        String data = scn.nextLine();

        String search = "SELECT * FROM j06318538.Popular WHERE "+args+" = '"+data+"'";
        PreparedStatement ps = conn.prepareStatement(search);
        ResultSet rs = ps.executeQuery();

        //System.out.println("nickname\t\tmail\t\tpassword");

        if (rs.next()) {

            String name = rs.getString("nickname");
            String email = rs.getString("mail");
            String password = rs.getString("password");

            // Print and display name, emailID and password
            System.out.println("nickname: " + name + "\nmail: " + email + "\npassword: " + password);
        }


    }




    public void search() throws SQLException {
        Scanner scn = new Scanner(System.in);
        System.out.print("You can choose search option: ");
        System.out.print("\n1) Search by nickname");
        System.out.print("\n2) Search by mail");
        System.out.print("\n3) Search by password\n");
        int i=scn.nextInt();
        while((i!=1) & (i!=2) &( i!=3)) {
            System.out.println("Error retype");
            i=scn.nextInt();
        }
        search_by("mail");
    }
}
