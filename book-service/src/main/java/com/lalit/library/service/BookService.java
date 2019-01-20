package com.lalit.library.service;

import com.lalit.library.rest.model.BookCommand;
import com.lalit.library.rest.model.BookResponse;

import java.util.UUID;

public interface BookService {
    UUID addBook(BookCommand bookCommand);

    BookResponse getBook(String bookId);
}
