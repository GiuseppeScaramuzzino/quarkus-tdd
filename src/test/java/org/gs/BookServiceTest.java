package org.gs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;

public class BookServiceTest {

    BookService service = new BookService();

    @Test
    public void getBooks() {
        List<Book> books = service.getBooks();
        assertEquals(2, books.size());
        assertNotNull(books.get(0));
        assertEquals(1L, books.get(0).getId());
        assertEquals("The Lord of the Rings", books.get(0).getTitle());

        assertNotNull(books.get(1));
        assertEquals(2L, books.get(1).getId());
        assertEquals("Harry Potter", books.get(1).getTitle());
    }

    @Test
    public void getBookById() {
        Optional<Book> book = service.getBookById(1L);
        assertNotNull(book);
        assertTrue(book.isPresent());
        assertEquals(1L, book.get().getId());
        assertEquals("The Lord of the Rings", book.get().getTitle());

    }

    @Test
    public void getBookByIdNotFound() {
        Optional<Book> book = service.getBookById(3L);
        assertNotNull(book);
        assertTrue(book.isEmpty());
    }
    
}
