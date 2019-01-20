package com.lalit.library.rest.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lalit.library.model.Book;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookResponse {
    String bookId;
    String title;

    public BookResponse() {
    }

    public BookResponse(Book book) {
        this.bookId = book.getBookId();
        this.title = book.getTitle();
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }
}
