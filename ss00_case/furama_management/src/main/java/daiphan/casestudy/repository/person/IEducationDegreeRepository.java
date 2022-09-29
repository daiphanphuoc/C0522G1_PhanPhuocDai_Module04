package daiphan.casestudy.repository.person;

import daiphan.casestudy.model.person.EducationDegree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IEducationDegreeRepository extends JpaRepository<EducationDegree,Integer> {

    @Modifying
    @Query(value = "update education_degree set is_delete = 1 where  id = :id and is_delete = 0 ",nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);
}
