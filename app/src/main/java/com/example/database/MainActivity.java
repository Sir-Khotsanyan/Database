package com.example.database;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.example.database.db.AppDatabase;
import com.example.database.db.Author;
import com.example.database.db.Book;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private BookListAdapter bookListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button addNewBookButton = findViewById(R.id.addNewBookButton);
        addNewBookButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(new Intent(MainActivity.this, AddNewBookActivity.class), 100);
            }
        });

        initRecyclerView();

        loadBookList();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL );
        recyclerView.addItemDecoration(dividerItemDecoration);
        bookListAdapter=new BookListAdapter(this);
        recyclerView.setAdapter(bookListAdapter);
    }

    private void loadBookList() {
        AppDatabase db = AppDatabase.getDBInstance(this.getApplicationContext());
        List<Book> bookList = db.bookDao().getAllBooks();
        List<Author> authorList=db.authorDao().getAllAuthors();
        bookListAdapter.setBookList(bookList,authorList);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            loadBookList();
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
}
