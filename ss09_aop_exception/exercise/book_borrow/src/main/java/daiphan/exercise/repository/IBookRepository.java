package daiphan.exercise.repository;

import daiphan.exercise.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface IBookRepository extends JpaRepository<Book,Integer> {
}
