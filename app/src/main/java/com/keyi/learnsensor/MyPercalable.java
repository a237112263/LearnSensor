package com.keyi.learnsensor;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Administrator on 2016/11/3.
 */
public class MyPercalable implements Parcelable{

    protected MyPercalable(Parcel in) {
    }

    public static final Creator<MyPercalable> CREATOR = new Creator<MyPercalable>() {
        @Override
        public MyPercalable createFromParcel(Parcel in) {
            return new MyPercalable(in);
        }

        @Override
        public MyPercalable[] newArray(int size) {
            return new MyPercalable[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
    }
}
