package daiphan.exercise.service.impl;

import daiphan.exercise.model.Book;
import daiphan.exercise.repository.IBookRepository;
import daiphan.exercise.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService implements IBookService {

    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> findAll(Pageable pageable) {
        return bookRepository.findAll(pageable);
    }

    @Override
    public Book borrowBook(Book book) {
        book.setQuantity(book.getQuantity()-1);
        return bookRepository.save(book);
    }

    @Override
    public Book payBook(Book book) {
        book.setQuantity(book.getQuantity()+1);
        return bookRepository.save(book);
    }

    @Override
    public Book findById(int id) {
        Optional<Book> book=bookRepository.findById(id);
        if(book.isPresent()){
            return book.get();
        }
        return null;
    }
}
