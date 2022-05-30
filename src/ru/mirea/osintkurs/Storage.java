package ru.mirea.osintkurs;

import org.json.simple.JSONArray;

public class Storage {
    JSONArray sources;
    String data;
    String last_beach;
    public JSONArray getSources(){return sources;}

    public void output(){
        System.out.println("Found on site "+sources+"\n"
                +"Found data "+data+"\n"
                +"Leak date:"+last_beach+"\n");
    }
}