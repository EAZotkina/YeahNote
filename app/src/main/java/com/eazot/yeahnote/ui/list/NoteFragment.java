package com.eazot.yeahnote.ui.list;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.eazot.yeahnote.R;
import com.eazot.yeahnote.domain.Note;
import com.eazot.yeahnote.domain.NoteRepository;
import com.eazot.yeahnote.domain.NoteRepositoryImpl;

import java.util.List;

public class NoteFragment extends Fragment  {

    public interface OnNoteClicked {
        void onNoteClicked(Note note);
    }

    private NoteRepository noteRepository;

    private OnNoteClicked onNoteClicked;

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof OnNoteClicked) {
            onNoteClicked = (OnNoteClicked) context;
        }

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();

        onNoteClicked = null;
        publisher = null;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        noteRepository = new NoteRepositoryImpl();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        LinearLayout notesList = view.findViewById(R.id.note_text);

        List<Note> notes = noteRepository.getNotes();

        for (Note note: notes) {

            View itemView = LayoutInflater.from(requireContext()).inflate(R.layout.fragment_note_text, notesList, false);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onNoteClicked != null) {
                        onNoteClicked.onNoteClicked(note);
                    }

                    if (publisher != null) {
                        publisher.notify(note);
                    }
                }
            });

            TextView cityName = itemView.findViewById(R.id.EnterTitle);
            cityName.setText(note.getTitle());

            notesList.addView(itemView);
        }
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
