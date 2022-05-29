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
            System.out.print("\n1) Delete by nickname" +
                    "\n2) Delete by mail" +
                    "\n3) Delete by password\n");
            int i=scn.nextInt();
            while((i!=1) & (i!=2) &( i!=3)) {
                System.out.println("Error retype");
                i=scn.nextInt();
            }
            switch (i) {
                case 1:
                    delete("nickname");
                    break;
                case 2:
                    delete("mail");
                    break;
                case 3:
                    delete("password");
                    break;
                default:
                    delete("mail");
            }
        }




        public void delete(String args) {
            //Connection conn = DriverManager.getConnection("jdbc:mysql://mysql.j06318538.myjino.ru:3306/j06318538", "j06318538", "kursovaya");
            //Statement stmt = null;
            //Scanner scn = new Scanner(System.in);
            //String nickname = null, mail = null, password = null;
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

