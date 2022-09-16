package daiphan.exercise.repository;

import daiphan.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog, Integer> {


    @Query(value = "select * from Blog  b where is_delete = 0 and title like %:key%;", nativeQuery = true)
    List<Blog> searchByTitle(@Param("key") String title);


    @Query(value = " update Blog set is_delete = 1 where  is_delete = 0 and id = :i;", nativeQuery = true)
    int deleteLogic(@Param("i") int id);
}
