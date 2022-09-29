package daiphan.casestudy.repository.facility;

import daiphan.casestudy.model.facility.FacilityType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFacilityTypeRepository extends JpaRepository<FacilityType,Integer> {

    @Modifying
    @Query(value = "update FacilityType set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);
}
