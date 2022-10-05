package daiphan.casestudy.service.impl.facility;

import daiphan.casestudy.dto.person.IFacilityDto;
import daiphan.casestudy.model.facility.Facility;
import daiphan.casestudy.repository.facility.IFacilityRepository;
import daiphan.casestudy.service.facility.IFacilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityService implements IFacilityService {

    @Autowired
    private IFacilityRepository facilityRepository;

    @Override
    public List<Facility> findAll() {
        return facilityRepository.findAll();
    }

    @Override
    public Facility findById(int id) {
        return facilityRepository.findById(id).get();
    }

    @Override
    public Facility insert(Facility element) {
        return facilityRepository.save(element);
    }

    @Override
    public Facility update(Facility element) {
        return facilityRepository.save(element);
    }

    @Override
    public boolean delete(int id) {
        return facilityRepository.deleteLogicById(id)==1;
    }

    @Override
    public Page<IFacilityDto> find(String searchName, String searchRentType, String searchFacilityType, Pageable pageable) {
        return facilityRepository.find(searchName,searchRentType,searchFacilityType,pageable);
    }
}
