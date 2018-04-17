package com.example.silas.parkingfinder;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by silas on 14.12.17.
 */

public class Item implements Parcelable {
    private final String name;
    private final String status;
    private final int freeSpaces;
    private final String link;



    public Item (@NonNull String name, String status, int freeSpaces, String link){
        this.name = name;
        this.status = status;
        this.freeSpaces = freeSpaces;
        this.link = link;

    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public int getFreeSpaces() {
        return freeSpaces;
    }

    public String getLink() {
        return link;
    }

    protected Item(Parcel in) {
        name = in.readString();
        status = in.readString();
        freeSpaces = in.readInt();
        link = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(status);
        dest.writeInt(freeSpaces);
        dest.writeString(link);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Item> CREATOR = new Parcelable.Creator<Item>() {
        @Override
        public Item createFromParcel(Parcel in) {
            return new Item(in);
        }

        @Override
        public Item[] newArray(int size) {
            return new Item[size];
        }
    };
}
