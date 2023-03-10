package com.example.database.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface BookDao {

    @Query("Select * From book")
    List<Book> getAllBooks();

    @Insert
    void insertBook(Book... book);

    @Delete
    void delete(Book book);
}
