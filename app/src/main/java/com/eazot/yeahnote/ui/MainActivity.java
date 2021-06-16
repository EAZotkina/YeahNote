package com.eazot.yeahnote.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.eazot.yeahnote.R;
import com.eazot.yeahnote.domain.Note;
import com.eazot.yeahnote.ui.details.NoteTextActivity;
import com.eazot.yeahnote.ui.details.NoteTextFragment;
import com.eazot.yeahnote.ui.list.NoteFragment;
import com.eazot.yeahnote.ui.list.Publisher;
import com.eazot.yeahnote.ui.list.PublisherHolder;

public class MainActivity extends AppCompatActivity implements NoteFragment.OnNoteClicked, PublisherHolder {


    private final Publisher publisher = new Publisher();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void onNoteClicked(Note note) {

        boolean isLandscape = getResources().getBoolean(R.bool.isLandscape);

        if (isLandscape) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.note_fragment, NoteTextFragment.newInstance(note))
                    .commit();

        } else {
            Intent intent = new Intent(this, NoteTextActivity.class);
            intent.putExtra(NoteTextActivity.ARG_NOTE, note);
            startActivity(intent);
        }
    }

    @Override
    public Publisher getPublisher() {
        return publisher;
    }
}
