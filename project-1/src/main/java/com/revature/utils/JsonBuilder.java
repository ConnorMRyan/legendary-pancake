package com.revature.utils;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;


public class JsonBuilder {
    static GsonBuilder gsb = new GsonBuilder();
    static Gson gson = gsb.create();

   public static String makeJSON(Object o){
       return gson.toJson(o);
    }
}
