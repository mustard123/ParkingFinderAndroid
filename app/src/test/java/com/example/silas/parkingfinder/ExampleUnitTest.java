package com.example.silas.parkingfinder;


import org.junit.Before;
import org.junit.Test;



import java.io.Reader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */

public class ExampleUnitTest {

    Reader xmlString;

    @Before
    public void getXML()throws Exception {
        String url = "http://www.pls-zh.ch/plsFeed/rss";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();

        xmlString = response.body().charStream();

    }


    @Test
    public void addition_isCorrect() throws Exception {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void getRequest() throws Exception{
        String url = "http://www.pls-zh.ch/plsFeed/rss";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        assertNotNull(response.body().string());
    }


    @Test
    public void regexTest(){
        String string = "open / 26";

        Pattern p = Pattern.compile("[0-9]+");
        Matcher m = p.matcher(string);
        if (m.find()){
           assertEquals("26", m.group());
        }


    }

    @Test
    public void itemGenerator(){
        String description = "open / 26";
        String name = "name";
        String link = "link";

        Item item = ItemGenerator.generateItem(name, description, link);
        assertEquals(26, item.getFreeSpaces());
        assertEquals("open", item.getStatus());

    }





}