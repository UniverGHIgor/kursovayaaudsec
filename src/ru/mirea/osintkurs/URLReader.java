package ru.mirea.osintkurs;
import java.net.*;
import java.io.*;

public class URLReader {
    public static void leakcheck() throws Exception {

        URL lc = new URL("https://leakcheck.io/api?key= &check=skif926@mail.ru&type=auto");
        URLConnection yc = lc.openConnection();
        BufferedReader in = new BufferedReader(
                new InputStreamReader(
                        yc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null)
            System.out.println(inputLine);
        in.close();
    }
}