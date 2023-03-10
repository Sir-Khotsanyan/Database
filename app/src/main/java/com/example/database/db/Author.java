package com.example.database.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Author {

    @PrimaryKey(autoGenerate = true)
    public int authorId;

    @ColumnInfo(name="authorName")
    public String authorName;

}
