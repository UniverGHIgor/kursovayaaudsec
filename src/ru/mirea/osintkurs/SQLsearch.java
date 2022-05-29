package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
//import java.sql.PreparedStatement;

public class SQLsearch extends SQL{

    public SQLsearch(String url, String namebase, String pass, String table) {
        super(url, namebase, pass, table);
        Startconnect();
    }
    public void search() {
        Scanner scn = new Scanner(System.in);
        System.out.print("You can choose search option: ");
        System.out.print("\n1) Search by nickname" +
                         "\n2) Search by mail" +
                         "\n3) Search by password\n");
        int i=scn.nextInt();
        while((i!=1) & (i!=2) &( i!=3)) {
            System.out.println("Error retype");
            i=scn.nextInt();
        }
        switch (i) {
            case 1:
                search_by("nickname");
                break;
            case 2:
                search_by("mail");
                break;
            case 3:
                search_by("password");
                break;
            default:
                search_by("mail");
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
            } else {System.out.println("Congratulations no data found in the database");}
        } catch (Exception e) {
			e.printStackTrace();
		}
    }
}
