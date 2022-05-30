package ru.mirea.osintkurs;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;

import java.net.*;
import java.io.*;
import java.util.*;
//import java.util.concurrent.TimeUnit;

public class URLReader extends Thread{
    public void run()  {
            Scanner scn = new Scanner(System.in);
            System.out.print("Enter your api key: ");
            String key = scn.nextLine();

            System.out.print("Enter wanted type(email,phone,auto): ");
            String type = scn.nextLine();

            System.out.print("Enter wanted data: ");
            String date = scn.nextLine();

            try {
            URL lc = new URL("https://leakcheck.io/api?key="+key+"&check="+date+"&type="+type+"");
            URLConnection yc = lc.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(yc.getInputStream()));
            String inputLine= in.readLine();
            in.close();
            Object obj = new JSONParser().parse(inputLine);
            JSONObject jo = (JSONObject) obj;
            for (int j = 0; j < 50; ++j) System.out.println();
            if ((Boolean) jo.get("success")) {
                System.out.println("Data found successfully");
               ArrayList<Storage> vec = new ArrayList<Storage>();

                int i = 0;
                while(i != (Long)jo.get(("found"))){
                    Storage data = new Storage();
                    data.sources=(JSONArray)((JSONObject) ((JSONArray)jo.get("result")).get(i)).get("sources");
                    data.data=(String) ((JSONObject) ((JSONArray)jo.get("result")).get(i)).get("line");
                    data.last_beach=(String) ((JSONObject) ((JSONArray)jo.get("result")).get(i)).get("last_breach");
                    vec.add(data);
                    i++;
                }
                System.out.println("Total Found: "+(Long)jo.get(("found")));
                vec.get(0).output();


                int userinsert=0;
                while ((userinsert!=1) & (userinsert!=2)){
                    System.out.println("""
                            1)Output all
                            2)Return to main menu""");
                    userinsert=scn.nextInt();
                }
                switch (userinsert){
                    case 1 -> {
                        for (Storage storage : vec) {
                            storage.output();
                        }
                        System.out.println("Please enter to return main menu");
                        userinsert=scn.nextInt();
                    }
                    default -> {}
                }
            } else {
                System.out.println("There are no entries for your request in our database. Probably you're safe!");
                System.out.println("Please enter to return main menu");
                int userinsert=scn.nextInt();
            }
    } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Connection error");
                System.out.println("Please enter to return main menu");
                int userinsert=scn.nextInt();
                for (int i = 0; i < 50; ++i) System.out.println();
    }
    }
}