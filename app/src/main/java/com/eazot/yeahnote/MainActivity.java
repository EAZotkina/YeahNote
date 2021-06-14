package com.eazot.yeahnote;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


            boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

            if (isLandscape) {
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment_note, NoteTextFragment.newInstance(1))
                        .commit();

            }else {
                setContentView(R.layout.fragment_note);

            }
   }
}