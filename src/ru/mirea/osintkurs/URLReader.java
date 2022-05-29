package ru.mirea.osintkurs;
import java.net.*;
import java.io.*;
import java.util.Scanner;

public class URLReader {
    public void leakcheck()  {
        try {
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter your api key: ");
            String key = scn.nextLine();

            System.out.print("Enter wanted data: ");
            String date = scn.nextLine();

            System.out.print("Enter wanted type: ");
            String type = scn.nextLine();

            URL lc = new URL("https://leakcheck.io/api?key="+key+"&check="+date+"&type="+type+"");
            URLConnection yc = lc.openConnection();
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            yc.getInputStream()));
            String inputLine;

            while ((inputLine = in.readLine()) != null)
                System.out.println(inputLine);
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}