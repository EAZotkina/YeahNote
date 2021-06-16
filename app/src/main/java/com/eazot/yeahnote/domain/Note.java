package com.eazot.yeahnote.domain;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

public class Note implements Parcelable {

        @StringRes
        private final int title;
        private final int date;

        public Note(int title, int date) {
            this.title = title;
            this.date = date;
        }

        protected Note(Parcel in) {
            title = in.readInt();
            date = in.readInt();
        }

        public static final Creator<Note> CREATOR = new Creator<Note>() {
            @Override
            public Note createFromParcel(Parcel in) {
                return new Note(in);
            }

            @Override
            public Note[] newArray(int size) {
                return new Note[size];
            }
        };


    @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(title);
            dest.writeInt(date);
        }

        public int getTitle() {
           return title;
        }

    public int getDate() {
        return date;
    }
}



