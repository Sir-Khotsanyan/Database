package com.example.database.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Book.class,Author.class}, version = 4)
public abstract class AppDatabase extends RoomDatabase {
    public abstract BookDao bookDao();
    public abstract AuthorDao authorDao();

    private static AppDatabase INSTANCE;

    public static AppDatabase getDBInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, "Bookstore")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
