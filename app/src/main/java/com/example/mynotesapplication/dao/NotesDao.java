package com.example.mynotesapplication.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.mynotesapplication.entities.Note;

import java.util.List;

@Dao
public interface NotesDao {
    @Query("SELECT * FROM notes ORDER BY id DESC")
    LiveData<List<Note>> getAll();

    @Query("SELECT * FROM notes WHERE id=:id")
    LiveData<Note> getNote(Integer id);

    @Insert()
    void createNote(Note note);

    @Update()
    void updateNote(Note note);

    @Delete()
    void deleteNote(Note note);
}