package daiphan.exercise.repository;

import daiphan.exercise.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from Blog b where b.is_delete = 0;", nativeQuery = true)
    List<Blog> findAll();

    @Query(value = "select * from Blog  b where b.title like %:key% and b.is_delete = 0;", nativeQuery = true)
    List<Blog> searchByTitle(@Param("key") String title);

    @Modifying
    @Query(value = " update Blog b set b.is_delete = 1 where b.id = :i and b.is_delete = 0;", nativeQuery = true)
    int deleteLogic(@Param("i") int id);
}
