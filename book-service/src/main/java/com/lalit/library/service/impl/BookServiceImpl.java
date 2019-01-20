package com.lalit.library.service.impl;

import com.lalit.library.model.Book;
import com.lalit.library.repository.BookRepository;
import com.lalit.library.rest.model.BookCommand;
import com.lalit.library.rest.model.BookResponse;
import com.lalit.library.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    BookRepository bookRepository;

    @Override
    public UUID addBook(BookCommand bookCommand) {
        Book book =  bookRepository.save(new Book(bookCommand));
        return UUID.fromString(book.getBookId());
    }

    @Override
    public BookResponse getBook(String bookId) {
        Book book = bookRepository.findByBookId(bookId);
        return new BookResponse(book);
    }
}
