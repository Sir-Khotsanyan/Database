package com.example.database;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.database.db.Author;
import com.example.database.db.Book;

import java.util.List;

public class BookListAdapter extends RecyclerView.Adapter<BookListAdapter.MyViewHolder> {

    private Context context;
    private List<Book> bookList;
    private List<Author> authorList;

    public BookListAdapter(Context context){
        this.context=context;
    }

    public void setBookList(List<Book> bookList,List<Author> authorList){
        this.bookList=bookList;
        this.authorList=authorList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BookListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
       View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);

       return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvBookName.setText(this.bookList.get(position).bookName);
        holder.tvYear.setText(this.bookList.get(position).year);
        holder.tvAuthorName.setText(this.authorList.get(position).authorName);
    }

    @Override
    public int getItemCount() {
        return this.bookList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvBookName;
        TextView tvYear;
        TextView tvAuthorName;

        public MyViewHolder(View view) {
            super(view);
            tvBookName = view.findViewById(R.id.tvBookName);
            tvYear = view.findViewById(R.id.tvYear);
            tvAuthorName=view.findViewById(R.id.tvAuthorName);
        }
    }
}
