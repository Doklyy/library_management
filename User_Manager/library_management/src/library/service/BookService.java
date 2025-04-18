package library.service;

import library.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book addBook(Book book);
    Optional<Book> findById(Long id);
    List<Book> findAllBooks();
    List<Book> findByCategory(String categoryCode);
    void updateQuantity(Long bookId, int change);
}
