package daiphan.exercise.repository;

import daiphan.exercise.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICategoryRepository extends JpaRepository<Category, Integer> {

    @Query(value = "select * from Category  where name_category like %:key% ", nativeQuery = true)
    List<Category> searchByName(@Param("key") String search);
}
