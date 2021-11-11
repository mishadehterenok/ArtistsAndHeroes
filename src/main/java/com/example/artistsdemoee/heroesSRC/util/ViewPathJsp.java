package com.example.artistsdemoee.heroesSRC.util;

public class ViewPathJsp {
    private static final String VIEW_PATH = "/resources/jsp/heroes/";
    private static final String FORMAT_JSP = ".jsp";

    public static String getPathToJsp(String jspName){
        return String.format("%s%s%s",VIEW_PATH,jspName,FORMAT_JSP);
    }
}

