package daiphan.casestudy.repository.business;

import daiphan.casestudy.model.business.ContractDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Transactional
@Repository
public interface IContractDetailRepository extends JpaRepository<ContractDetail,Integer> {

    @Modifying
    @Query(value = "update ContractDetail set is_delete = 1 where id = :id  and is_delete = 0", nativeQuery = true)
    boolean deleteLogicById(@Param("id") int id);
}
