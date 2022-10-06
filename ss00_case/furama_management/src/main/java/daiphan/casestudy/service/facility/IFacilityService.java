package daiphan.casestudy.service.facility;

import daiphan.casestudy.dto.facility.IFacilityDto;
import daiphan.casestudy.model.facility.Facility;
import daiphan.casestudy.service.IFuramaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

public interface IFacilityService extends IFuramaService<Facility> {
    Page<IFacilityDto> find(@Param("searchName") String searchName,
                            @Param("searchRentType") String searchRentType,
                            @Param("searchFacilityType") String searchFacilityType,
                            Pageable pageable);
}
