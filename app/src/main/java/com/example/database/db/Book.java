package com.example.database.db;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Book {

    @PrimaryKey(autoGenerate = true)
    public int bookId;

    @ColumnInfo(name="bookName")
    public String bookName;

    @ColumnInfo(name="year")
    public String year;

}
