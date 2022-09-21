package daiphan.exercise.repository;

import daiphan.exercise.dto.BlogDto;
import daiphan.exercise.dto.IBlogDto;
import daiphan.exercise.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from Blog  where is_delete = 0 ", nativeQuery = true)
    Page<Blog> findAll(Pageable pageable);

    @Query(value = "select * from Blog  where title like %:key% and is_delete = 0 ", nativeQuery = true)
    Page<Blog> searchByTitle(@Param("key") String title, Pageable pageable);

    @Modifying
    @Query(value = " update Blog as b set b.is_delete = 1 where b.id = :i and b.is_delete = 0;", nativeQuery = true)
    int deleteLogic(@Param("i") int id);

/*    @Query(nativeQuery = true)
    Page<BlogDto> search( String key, Pageable pageable);*/

    @Query(value = "select blog.title as title, category.name_category as categoryName " +
            "from blog inner join category on category.id = blog.category_id " +
            "where blog.is_delete = 0 ",
            countQuery = "select count(*)" +
                    " from blog inner join category on category.id = blog.category_id " +
                    " where blog.is_delete = 0 ",nativeQuery = true)
    Page<IBlogDto> searchInterface(String key, Pageable pageable);
}
