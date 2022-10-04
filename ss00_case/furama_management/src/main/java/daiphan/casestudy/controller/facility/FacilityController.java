package daiphan.casestudy.controller.facility;

import daiphan.casestudy.model.dto.FacilityDto;
import daiphan.casestudy.model.facility.RentType;
import daiphan.casestudy.service.facility.IFacilityService;
import daiphan.casestudy.service.facility.IFacilityTypeService;
import daiphan.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    @GetMapping
    public String showFacility(Model model,
                               @RequestParam(defaultValue = "") String searchName,
                               @RequestParam(defaultValue = "") String searchRentType,
                               @RequestParam(defaultValue = "") String searchFacilityType,
                               Pageable pageable){
        model.addAttribute("searchName",searchName);
        model.addAttribute("searchRentType",searchRentType);
        model.addAttribute("searchFacilityType",searchFacilityType);
        model.addAttribute("newFacilityDto", new FacilityDto());
        model.addAttribute("updateFacilityDto", new FacilityDto());
        model.addAttribute("rentTypeList",rentTypeService.findAll());
        model.addAttribute("facilityTypeList",facilityTypeService.findAll());
        model.addAttribute("facilityList",facilityService.find(searchName,searchRentType,searchFacilityType,pageable));
        return "facility/facility";
    }
}
