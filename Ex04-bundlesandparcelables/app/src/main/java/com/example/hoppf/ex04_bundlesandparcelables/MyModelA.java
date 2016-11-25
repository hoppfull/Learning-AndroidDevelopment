package com.example.hoppf.ex04_bundlesandparcelables;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Arrays;

public class MyModelA implements Parcelable {
    public final MyModelB myModelB;
    public final MyModelC[] myModelCs;

    public MyModelA(MyModelB myModelB, MyModelC[] myModelCs) {
        this.myModelB = myModelB;
        this.myModelCs = myModelCs;
    }

    public MyModelA(Parcel in) {
        this.myModelB = in.readParcelable(MyModelB.class.getClassLoader());
        this.myModelCs = in.createTypedArray(MyModelC.CREATOR);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(myModelB, i);
        parcel.writeTypedArray(myModelCs, i);
    }

    public static final Creator<MyModelA> CREATOR = new Creator<MyModelA>() {
        @Override
        public MyModelA createFromParcel(Parcel in) {
            return new MyModelA(in);
        }

        @Override
        public MyModelA[] newArray(int size) {
            return new MyModelA[size];
        }
    };
}
