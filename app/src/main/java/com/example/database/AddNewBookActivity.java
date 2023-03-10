package com.example.database;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.database.db.AppDatabase;
import com.example.database.db.Author;
import com.example.database.db.Book;

public class AddNewBookActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_book);

        final EditText bookNameInput= findViewById(R.id.bookNameInput);
        final EditText yearInput= findViewById(R.id.yearInput);
        final EditText authorNameInput=findViewById(R.id.authorName);
        Button saveButton=findViewById(R.id.saveButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveNewBook(bookNameInput.getText().toString(),yearInput.getText().toString(),authorNameInput.getText().toString());
            }
        });
    }

    private void saveNewBook(String bookName,String year,String authorName){
        AppDatabase db=AppDatabase.getDBInstance(this.getApplicationContext());

        Book book=new Book();
        book.bookName=bookName;
        book.year=year;
        Author author=new Author();
        author.authorName=authorName;
        db.bookDao().insertBook(book);
        db.authorDao().insertAuthor(author);

        finish();
    }
}
