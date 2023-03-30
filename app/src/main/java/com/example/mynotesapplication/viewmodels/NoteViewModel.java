package com.example.mynotesapplication.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.mynotesapplication.entities.Note;
import com.example.mynotesapplication.repositories.NotesRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    NotesRepository notesRepository;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        notesRepository = new NotesRepository(application);
    }

    public LiveData<List<Note>> getAll(){
        return notesRepository.getAll();
    }

    public LiveData<Note> getNote(Integer id){
        return notesRepository.getNote(id);
    }

    public void createNote(Note note){
        notesRepository.createNote(note);
    }

    public void updateNote(Note note){
        notesRepository.updateNote(note);
    }
    public void deleteNote(Note note){
        notesRepository.deleteNote(note);
    }
}
