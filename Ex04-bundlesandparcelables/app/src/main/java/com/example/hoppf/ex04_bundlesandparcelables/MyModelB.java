package com.example.hoppf.ex04_bundlesandparcelables;

import android.os.Parcel;
import android.os.Parcelable;

public class MyModelB implements Parcelable {
    public final int myFieldB;

    public MyModelB(int myFieldB) {
        this.myFieldB = myFieldB;
    }

    public MyModelB(Parcel in) {
        this.myFieldB = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(myFieldB);
    }

    public static final Creator<MyModelB> CREATOR = new Creator<MyModelB>() {
        @Override
        public MyModelB createFromParcel(Parcel in) {
            return new MyModelB(in);
        }

        @Override
        public MyModelB[] newArray(int size) {
            return new MyModelB[size];
        }
    };
}
