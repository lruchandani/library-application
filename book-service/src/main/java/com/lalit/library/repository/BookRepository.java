package com.lalit.library.repository;

import com.lalit.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface BookRepository extends JpaRepository<Book,Long> {

    @Override
    <S extends Book> S save(S s);

    List<Book> findByTitle(String tittle);

    Book findByBookId(String bookId);
}
