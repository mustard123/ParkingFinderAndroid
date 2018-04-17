package com.example.silas.parkingfinder;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import org.xmlpull.v1.XmlPullParserException;
import org.xmlpull.v1.XmlPullParserFactory;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.List;

public class ParkingActivity extends AppCompatActivity implements DownloadCallback {

    List parkingList = null;
    ParkingListFragment parkingListFragment;
    NetworkFragment networkFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_parking);


        networkFragment = NetworkFragment.newInstance("http://www.pls-zh.ch/plsFeed/rss");
        getSupportFragmentManager().beginTransaction().add(networkFragment, null).commit();


        parkingListFragment = ParkingListFragment.newInstance();
        getSupportFragmentManager().beginTransaction().add(R.id.parking_fragment_container, parkingListFragment).commit();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.fetch_action:
                networkFragment.getData();
                return true;
        }

        return false;
    }

    @Override
    public void showResult(String result) {

        try {
            parkingList = parseXmlString(result);
          parkingListFragment.updateDatasource(parkingList);
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        }


    }

    private List parseXmlString (String string)throws XmlPullParserException, IOException{

        ParkingDataParser parkingDataParser = new ParkingDataParser(XmlPullParserFactory.newInstance().newPullParser());
        List result = parkingDataParser.parse(new StringReader(string));
        return result;
    }
}
