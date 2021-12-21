package org.gs;

import java.util.List;
import java.util.Optional;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class BookService {

    private final List<Book> books = List.of(new Book(1L, "The Lord of the Rings"),
            new Book(2L, "Harry Potter"));

    public List<Book> getBooks() {
        return books;
    }

    public Optional<Book> getBookById(Long id) {
        return books.stream().filter(book -> id == book.getId())
                .findFirst();
    }

}
