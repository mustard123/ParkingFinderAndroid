package com.example.silas.parkingfinder;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by silas on 14.12.17.
 */

public final class ItemGenerator {

    private static final Pattern p = Pattern.compile("[0-9]+");

    public static Item generateItem(String name, String description, String link) {

        Matcher m = p.matcher(description);

        String status = (description.substring(0, description.indexOf("/"))).trim();
        int freeSpaces= -1;
        if (m.find()){
            freeSpaces = Integer.parseInt(m.group());
        }


        return new Item(name, status, freeSpaces, link);
    }


}
