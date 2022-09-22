package daiphan.exercise.service;

import daiphan.exercise.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {

    Page<Book> findAll(Pageable pageable);

    Book borrowBook(Book book);

    Book payBook(Book book);

    Book findById(int id);
}
