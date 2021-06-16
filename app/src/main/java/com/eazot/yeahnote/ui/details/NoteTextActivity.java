package com.eazot.yeahnote.ui.details;

import androidx.appcompat.app.AppCompatActivity;
import com.eazot.yeahnote.R;
import com.eazot.yeahnote.domain.Note;

import android.os.Bundle;

public class NoteTextActivity extends AppCompatActivity {

    public static final String ARG_NOTE = "ARG_NOTE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_text);

        if (savedInstanceState == null) {

            Note note = getIntent().getParcelableExtra(ARG_NOTE);

            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.container, NoteTextFragment.newInstance(note))
                    .commit();

        }

    }
}