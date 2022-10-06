package daiphan.casestudy.repository.facility;

import daiphan.casestudy.dto.facility.IFacilityDto;
import daiphan.casestudy.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface IFacilityRepository extends JpaRepository<Facility,Integer> {

    @Modifying
    @Query(value = "update facility set is_delete = 1 where id = :id  and is_delete = 0 ", nativeQuery = true)
    int  deleteLogicById(@Param("id") int id);

    @Query(value = "select facility.id, facility.`name`, `description`,leased_area as leasedArea, max_person as maxPerson," +
            "  rental_costs as rentalCosts, rent_type.`name` as rentType, facility_type.`name` as facilityType  " +
            "from facility join facility_type on facility_type_id = facility_type.id " +
            "join rent_type on rent_type_id = rent_type.id where facility.is_delete = 0 " +
            "and facility.`name` like %:searchName% " +
            "and facility_type.`name` like %:searchFacilityType% " +
            "and rent_type.`name` like %:searchRentType%",
            countQuery = "select  count(*)  from facility " +
                    "join facility_type on facility_type_id = facility_type.id" +
                    " join rent_type on rent_type_id = rent_type.id where facility.is_delete = 0 " +
                    "and facility.`name` like %:searchName% " +
                    "and facility_type.`name` like %:searchFacilityType% " +
                    "and rent_type.`name` like %:searchRentType% ",nativeQuery = true)
    Page<IFacilityDto> find(@Param("searchName") String searchName,
                            @Param("searchRentType") String searchRentType,
                            @Param("searchFacilityType") String searchFacilityType,
                            Pageable pageable);
}
