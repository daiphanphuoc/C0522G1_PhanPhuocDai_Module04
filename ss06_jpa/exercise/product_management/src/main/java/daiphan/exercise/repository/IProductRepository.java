package daiphan.exercise.repository;

import daiphan.exercise.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IProductRepository extends JpaRepository<Product,Integer> {

    @Query(value = "select * from  Product p where p.is_delete = 0;", nativeQuery = true)
    List<Product> productAll();

    @Query(value ="select * from Product p where p.is_delete = 0 and  p.name like %:key% ;", nativeQuery = true)
    List<Product> searchByName(@Param("key") String name);

    @Modifying
    @Query(value = "update Product p set p.is_delete = 1 where p.id = :i and p.is_delete = 0;", nativeQuery = true)
    int deleteLogic(@Param("i") int id);

    @Query(value = "select * from  Product p where p.is_delete = 0 and p.id = :i;", nativeQuery = true)
    Product detail(@Param("i") int id);
}
