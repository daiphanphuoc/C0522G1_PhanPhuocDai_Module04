package daiphan.exercise.repository;

import daiphan.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from Blog  where is_delete = 0 ", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from Blog  where title like %:key% and is_delete = 0 ", nativeQuery = true)
    Page<Blog> searchByTitle(@Param("key") String title, Pageable pageable);

    @Modifying
    @Query(value = " update Blog as b set b.is_delete = 1 where b.id = :i and b.is_delete = 0;", nativeQuery = true)
    int deleteLogic(@Param("i") int id);
}
