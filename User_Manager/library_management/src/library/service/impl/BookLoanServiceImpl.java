package library.service.impl;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import library.exception.BookNotFoundException;
import library.exception.LibraryException;
import library.model.Book;
import library.model.BookLoan;
import library.model.User;
import library.service.BookLoanService;
import library.service.BookService;

public class BookLoanServiceImpl implements BookLoanService {
    private Map<Long, BookLoan> loans = new HashMap<>();
    private Long currentId = 1L;
    private final BookService bookService;

    public BookLoanServiceImpl(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public BookLoan borrowBook(User user, Long bookId) {
        Book book = bookService.findById(bookId)
                .orElseThrow(() -> new BookNotFoundException(bookId));
        
        if (book.getQuantity() <= 0) {
            throw new LibraryException("Book is not available for borrowing");
        }

        BookLoan loan = new BookLoan(user, book);
        loan.setId(currentId++);
        loans.put(loan.getId(), loan);
        
        bookService.updateQuantity(bookId, -1);
        
        return loan;
    }

    @Override
    public BookLoan returnBook(Long loanId) {
        BookLoan loan = loans.get(loanId);
        if (loan == null) {
            throw new LibraryException("Loan not found");
        }

        loan.setReturnDate(LocalDateTime.now());
        loan.setStatus("RETURNED");
        
        bookService.updateQuantity(loan.getBook().getId(), 1);
        
        return loan;
    }

    @Override
    public List<BookLoan> findUserLoans(Long userId) {
        return loans.values().stream()
                .filter(loan -> loan.getUser().getUserId().equals(userId))
                .collect(Collectors.toList());
    }

    @Override
    public List<BookLoan> findOverdueLoans() {
        LocalDateTime now = LocalDateTime.now();
        return loans.values().stream()
                .filter(loan -> "BORROWED".equals(loan.getStatus()) 
                        && loan.getDueDate().isBefore(now))
                .collect(Collectors.toList());
    }

}
