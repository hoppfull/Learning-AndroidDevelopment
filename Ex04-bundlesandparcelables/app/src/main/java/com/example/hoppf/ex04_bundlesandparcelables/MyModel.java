package com.example.hoppf.ex04_bundlesandparcelables;
// http://shri.blog.kraya.co.uk/2010/04/26/android-parcel-data-to-pass-between-activities-using-parcelable-classes/

import android.os.Parcel;
import android.os.Parcelable;
public class MyModel implements Parcelable {
    public final String s;
    public final int x;

    public MyModel(String s, int x) {
        this.s = s;
        this.x = x;
    }

    public MyModel(Parcel in) {
        s = in.readString();
        x = in.readInt();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int i) {
        out.writeString(s);
        out.writeInt(x);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        @Override
        public Object createFromParcel(Parcel in) {
            return new MyModel(in);
        }

        @Override
        public MyModel[] newArray(int size) {
            return new MyModel[size];
        }
    };
}
