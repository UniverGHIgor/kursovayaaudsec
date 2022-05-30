package ru.mirea.osintkurs;
import java.sql.*;
import java.util.*;
import java.sql.PreparedStatement;


    public class SQLDelete extends SQL{

        public SQLDelete(String url, String namebase, String pass, String table) {
            super(url, namebase, pass, table);
            Startconnect();
        }
        public void Startdelete(){
            Scanner scn = new Scanner(System.in);
            System.out.print("You can choose delete option: ");
            System.out.print("""

                    1) Delete by nickname
                    2) Delete by mail
                    3) Delete by password
                    """);
            int userinsert=scn.nextInt();
            while((userinsert!=1) & (userinsert!=2) &( userinsert!=3)) {
                System.out.println("Error retype");
                userinsert=scn.nextInt();
            }
            switch (userinsert) {
                case 1 -> delete("nickname");
                case 2 -> delete("mail");
                case 3 -> delete("password");
                default -> delete("mail");
            }
        }

        public void delete(String args) {
            try {
                //Class.forName("com.mysql.jdbc.Driver");
                System.out.print("Enter your data to be deleted: ");
                Scanner scn = new Scanner(System.in);
                String data = scn.nextLine();

                System.out.print("\nDeleting your data into table...");
                stmt = conn.createStatement();
                String deleteSql = "DELETE FROM "+namebase+"."+table+" WHERE "+args+" = '"+data+"'";
                stmt = conn.prepareStatement(deleteSql);
                stmt.executeUpdate(deleteSql);

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
        }
    }

