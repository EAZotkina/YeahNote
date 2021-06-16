package com.eazot.yeahnote.domain;

import java.util.ArrayList;
import java.util.List;
import com.eazot.yeahnote.R;

public class NoteRepositoryImpl implements NoteRepository {

    @Override
    public List<Note> getNotes() {
        ArrayList<Note> result = new ArrayList<>();

        result.add(new Note(R.string.note1,R.string.date1));
        result.add(new Note(R.string.note2,R.string.date1));
        result.add(new Note(R.string.note3,R.string.date1));
        result.add(new Note(R.string.note4,R.string.date1));

        return result;
    }
}
