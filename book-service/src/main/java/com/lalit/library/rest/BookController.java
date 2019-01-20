package com.lalit.library.rest;

import com.lalit.library.rest.model.BookCommand;
import com.lalit.library.rest.model.BookResponse;
import com.lalit.library.service.BookService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.UUID;

import static org.slf4j.LoggerFactory.getLogger;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/")
public class BookController {

  private static final Logger LOG = getLogger(BookController.class);

  @Autowired BookService bookService;

  @PostMapping(path = "books" ,  produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> add(@RequestBody BookCommand bookCommand) {
    LOG.info("<<<BookController.add ....");
    UUID bookId = bookService.addBook(bookCommand);
    String location =
        linkTo(methodOn(BookController.class)
                .add(bookCommand))
                .withSelfRel()
                .getHref()
            + "/"
            + bookId;
    return  ResponseEntity.created(URI.create(location)).build();
  }


  @GetMapping(path = "books/{bookId}", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<BookResponse> get(@PathVariable("bookId") String bookId){
    LOG.info("<<<BookController.get ....");
    BookResponse bookResponse = bookService.getBook(bookId);
    return  ResponseEntity.ok(bookResponse);
  }
}
