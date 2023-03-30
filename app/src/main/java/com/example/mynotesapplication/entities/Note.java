package com.example.mynotesapplication.entities;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "notes")
public class Note {

    public Note(final String title, final String body) {
        this.title = title;
        this.body = body;
    }

    @PrimaryKey(autoGenerate = true)
    public Integer id;

    @ColumnInfo(name = "title")
    public String title;

    @ColumnInfo(name = "body")
    public String body;

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
