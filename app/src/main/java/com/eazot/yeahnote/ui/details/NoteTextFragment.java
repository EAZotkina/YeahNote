package com.eazot.yeahnote.ui.details;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.eazot.yeahnote.R;
import com.eazot.yeahnote.domain.Note;
import com.eazot.yeahnote.ui.list.Observer;
import com.eazot.yeahnote.ui.list.Publisher;
import com.eazot.yeahnote.ui.list.PublisherHolder;

public class NoteTextFragment extends Fragment implements Observer {

    private static final String ARG_NOTE = "ARG_NOTE";

    public static com.eazot.yeahnote.ui.details.NoteTextFragment newInstance(Note note) {
        com.eazot.yeahnote.ui.details.NoteTextFragment fragment = new com.eazot.yeahnote.ui.details.NoteTextFragment();
        Bundle bundle = new Bundle();
        bundle.putParcelable(ARG_NOTE, note);
        fragment.setArguments(bundle);
        return fragment;
    }

    private Publisher publisher;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        if (context instanceof PublisherHolder) {
            publisher = ((PublisherHolder) context).getPublisher();

            publisher.subscribe(this);
        }
    }

    @Override
    public void onDetach() {
        if (publisher != null) {
            publisher.unsubscribe(this);
        }
        super.onDetach();
    }

    public NoteTextFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_note, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView title = view.findViewById(R.id.EnterTitle);
        TextView date = view.findViewById(R.id.DateCreated);

        Note note = getArguments().getParcelable(ARG_NOTE);

        title.setText(note.getTitle());
        date.setText(note.getDate());
    }

    @Override
    public void updateNote(Note note) {
        Toast.makeText(requireContext(), note.getTitle(), Toast.LENGTH_LONG).show();

    }
}