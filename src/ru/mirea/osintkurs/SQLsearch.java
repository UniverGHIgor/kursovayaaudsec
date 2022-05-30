package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;

public class SQLsearch extends SQL{

    public SQLsearch(String url, String namebase, String pass, String table) {
        super(url, namebase, pass, table);
        Startconnect();
    }

    public void search() {
        Scanner scn = new Scanner(System.in);
        System.out.print("""
                You can choose search option:

                1) Search by nickname
                2) Search by mail
                3) Search by password
                """);
        int userinsert=scn.nextInt();
        while((userinsert!=1) & (userinsert!=2) &( userinsert!=3)) {
            for (int i = 0; i < 50; ++i) System.out.println();
            System.out.print("""
                You can choose search option:

                1) Search by nickname
                2) Search by mail
                3) Search by password
                """);
            userinsert=scn.nextInt();
        }
        switch (userinsert) {
            case 1 -> search_by("nickname");
            case 2 -> search_by("mail");
            case 3 -> search_by("password");
            default -> search_by("mail");
        }
    }
    public void search_by(String args) {
        try {
            System.out.print("Enter your data: ");
            Scanner scn = new Scanner(System.in);
            String data = scn.nextLine();
            String search = "SELECT * FROM "+namebase+"."+table+" WHERE "+args+" = '"+data+"'";
            PreparedStatement ps = conn.prepareStatement(search);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("nickname");
                String email = rs.getString("mail");
                String password = rs.getString("password");
                System.out.println("nickname: " + name + "\nmail: " + email + "\npassword: " + password);
                System.out.println("Please enter to return main menu");
                int userinsert=scn.nextInt();
                for (int i = 0; i < 50; ++i) System.out.println();
            } else {
                System.out.println("Congratulations no data found in the database");
                System.out.println("Please enter to return main menu");
                int userinsert=scn.nextInt();
                for (int i = 0; i < 50; ++i) System.out.println();}
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}
