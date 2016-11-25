package com.example.hoppf.ex04_bundlesandparcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModelC implements Parcelable {
    public static final String SQL_CREATETABLE = "CREATE TABLE IF NOT EXISTS MyModelC(myFieldC TEXT);";
    public final String myFieldC;

    public MyModelC(String myFieldC) {
        this.myFieldC = myFieldC;
    }

    public MyModelC(Parcel in) {
        this.myFieldC = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(myFieldC);
    }

    public static final Creator<MyModelC> CREATOR = new Creator<MyModelC>() {
        @Override
        public MyModelC createFromParcel(Parcel in) {
            return new MyModelC(in);
        }

        @Override
        public MyModelC[] newArray(int size) {
            return new MyModelC[size];
        }
    };
}