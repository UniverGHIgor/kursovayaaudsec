package ru.mirea.osintkurs;
import java.util.*;
public class SQLInsert extends SQL {
    public SQLInsert(String url, String namebase, String pass, String table) {
        super(url, namebase, pass, table);
        Startconnect();
    }
    public SQLInsert(String url, String namebase, String pass, String table , String nickname,String mail,String password) {
        super(url, namebase, pass, table);
        this.nickname=nickname;
        this.mail=mail;
        this.password=password;
        Startconnect();
    }
    public void Startinsert() {
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
            try {
                stmt = conn.prepareStatement(insertSql);
                stmt.executeUpdate(insertSql);
                System.out.println(" SUCCESS!\n");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }