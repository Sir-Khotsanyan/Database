package com.example.database.db;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface AuthorDao {

    @Query("Select * From author")
    List<Author> getAllAuthors();

    @Insert
    void insertAuthor(Author... author);

    @Delete
    void delete(Author author);
}
