package com.example.mynotesapplication.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.mynotesapplication.dao.NotesDao;
import com.example.mynotesapplication.entities.Note;

@Database(entities = {Note.class}, version = 1)
public abstract class NotesAppDB extends RoomDatabase {
    abstract public NotesDao getNotesDao();

    private static NotesAppDB db;

    public static NotesAppDB getInstance(Context context) {
        if (db == null) {
            db = buildDBInstance(context);
        }
        return db;
    }

    public static NotesAppDB buildDBInstance(Context context){
        return Room.databaseBuilder(context, NotesAppDB.class, "my-notes-database").allowMainThreadQueries().build();
    }

    public void cleanUp() {
        db = null;
    }
}