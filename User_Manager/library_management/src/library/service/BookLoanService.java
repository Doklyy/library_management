package library.service;

import library.model.BookLoan;
import library.model.User;
import java.util.List;

public interface BookLoanService {
    BookLoan borrowBook(User user, Long bookId);
    BookLoan returnBook(Long loanId);
    List<BookLoan> findUserLoans(Long userId);
    List<BookLoan> findOverdueLoans();
} 