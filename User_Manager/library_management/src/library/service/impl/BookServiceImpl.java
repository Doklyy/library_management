package library.service.impl;

import library.model.Book;
import library.service.BookService;
import library.exception.BookNotFoundException;
import java.util.*;
import java.util.stream.Collectors;

public class BookServiceImpl implements BookService {
    private Map<Long, Book> books = new HashMap<>();
    private Long currentId = 1L;

    @Override
    public Book addBook(Book book) {
        book.setId(currentId++);
        books.put(book.getId(), book);
        return book;
    }

    @Override
    public Optional<Book> findById(Long id) {
        return Optional.ofNullable(books.get(id));
    }

    @Override
    public List<Book> findAllBooks() {
        return new ArrayList<>(books.values());
    }

    @Override
    public List<Book> findByCategory(String categoryCode) {
        return books.values().stream()
                .filter(book -> book.getCategories().stream()
                        .anyMatch(category -> category.getCategoryCode().equals(categoryCode)))
                .collect(Collectors.toList());
    }

    @Override
    public void updateQuantity(Long bookId, int change) {
        Book book = books.get(bookId);
        if (book == null) {
            throw new BookNotFoundException(bookId);
        }
        book.setQuantity(book.getQuantity() + change);
    }

}
