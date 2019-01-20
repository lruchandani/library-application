package com.lalit.library.model;


import com.lalit.library.rest.model.BookCommand;

import javax.persistence.*;
import java.util.UUID;

@Entity(name = "BOOK")
public class Book {

    @Id
    @Column(name = "BOOK_ID", nullable = false ,unique = true)
    String bookId;


    @Column(name = "TITLE",nullable = false)
    String title;

    public Book() {
        bookId = UUID.randomUUID().toString();
    }

    public Book(BookCommand bookCommand) {
        this();
        this.title = bookCommand.getTitle();
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
