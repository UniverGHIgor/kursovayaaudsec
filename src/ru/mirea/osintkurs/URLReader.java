package ru.mirea.osintkurs;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Scanner;

public class URLReader {
    public void leakcheck()  {

            Scanner scn = new Scanner(System.in);
            System.out.print("Enter your api key: ");
            String key = scn.nextLine();

            System.out.print("Enter wanted data: ");
            String date = scn.nextLine();

            System.out.print("Enter wanted type: ");
            String type = scn.nextLine();

            try {
            URL lc = new URL("https://leakcheck.io/api?key="+key+"&check="+date+"&type="+type+"");
            URLConnection yc = lc.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));

            String inputLine="{}";
            Storage folder = new Storage();
            while ((inputLine = in.readLine()) != null) {
                System.out.println(inputLine);

                Object obj = new JSONParser().parse(inputLine); // Object obj = new JSONParser().parse(new FileReader("JSONExample.json"));
// Кастим obj в JSONObject
                JSONObject jo = (JSONObject) obj;

// Достаём firstName and lastName
                folder.sources = (String[]) jo.get("sources");
                //System.out.println(Arrays.toString(folder.sources));
                System.out.println((String[]) jo.get("sources"));
                folder.email_only = (String) jo.get("email_only");
                folder.line = (String[]) jo.get("line");
                folder.last_breach = (String[]) jo.get("last_breach");
            } in.close();
        //System.out.println("fio: " + firstName + " " + lastName);
// Достаем массив номеров
        //JSONArray phoneNumbersArr = (JSONArray) jo.get("phoneNumbers");
        //Iterator phonesItr = phoneNumbersArr.iterator();
        //System.out.println("phoneNumbers:");
// Выводим в цикле данные массива
//        while (phonesItr.hasNext()) {
//            JSONObject test = (JSONObject) phonesItr.next();
//            System.out.println("- type: " + test.get("type") + ", phone: " + test.get("number"));
//        }
    } catch (Exception e) {
        e.printStackTrace();
    }
    }
}