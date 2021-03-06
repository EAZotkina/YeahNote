package com.eazot.yeahnote.ui.list;

import com.eazot.yeahnote.domain.Note;

import java.util.ArrayList;
import java.util.List;

public class Publisher {

    private final List<Observer> observers = new ArrayList<>();

    public void subscribe(Observer observer) {
        observers.add(observer);
    }

    public void unsubscribe(Observer observer) {
        observers.remove(observer);
    }

    public void notify(Note note) {
        for (Observer observer: observers) {
            observer.updateNote(note);
        }
    }
}
