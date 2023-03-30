package com.example.mynotesapplication.repositories;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mynotesapplication.dao.NotesDao;
import com.example.mynotesapplication.db.NotesAppDB;
import com.example.mynotesapplication.entities.Note;

import java.util.List;

public class NotesRepository {

    final private NotesAppDB db;
    final private NotesDao notesDao;

    final private LiveData<List<Note>> notes;

    public NotesRepository(@NonNull Application application){
        db = NotesAppDB.getInstance(application.getApplicationContext());
        notesDao = db.getNotesDao();
        notes = notesDao.getAll();
    }


    public LiveData<List<Note>> getAll(){
        return notes;
    }

    public LiveData<Note> getNote(Integer id){
        return notesDao.getNote(id);
    }

    public void createNote(Note note){
        notesDao.createNote(note);
    }

    public void updateNote(Note note){
        notesDao.updateNote(note);
    }
    public void deleteNote(Note note){
        notesDao.deleteNote(note);
    }
}
