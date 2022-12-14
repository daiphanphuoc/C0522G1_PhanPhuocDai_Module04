package daiphan.casestudy.controller.facility;

import daiphan.casestudy.dto.person.IEmployeeDto;
import daiphan.casestudy.model.dto.EmployeeDto;
import daiphan.casestudy.model.dto.FacilityDto;
import daiphan.casestudy.model.facility.*;
import daiphan.casestudy.model.person.Employee;
import daiphan.casestudy.service.facility.IFacilityService;
import daiphan.casestudy.service.facility.IFacilityTypeService;
import daiphan.casestudy.service.facility.IRentTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;

@Controller
@RequestMapping("/facility")
public class FacilityController {

    @Autowired
    private IRentTypeService rentTypeService;

    @Autowired
    private IFacilityService facilityService;

    @Autowired
    private IFacilityTypeService facilityTypeService;

    private void useTotal(Model model,
                          @RequestParam(defaultValue = "") String searchName,
                          @RequestParam(defaultValue = "") String searchRentType,
                          @RequestParam(defaultValue = "") String searchFacilityType,
                          @PageableDefault(value = 3) Pageable pageable) {
        model.addAttribute("facility",new FacilityDto());
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchRentType", searchRentType);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityList", facilityService.find(searchName, searchRentType, searchFacilityType, pageable));

    }

    @GetMapping
    public String showFacility(Model model,
                               @RequestParam(defaultValue = "") String searchName,
                               @RequestParam(defaultValue = "") String searchRentType,
                               @RequestParam(defaultValue = "") String searchFacilityType,
                               @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        model.addAttribute("facilityDto",new FacilityDto());
        return "facility/facility";
    }

    @GetMapping("/view/{id}")
    public String showInfo(@PathVariable int id, Model model,
                           @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "") String searchRentType,
                           @RequestParam(defaultValue = "") String searchFacilityType,
                           @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facility", facilityDto);
        model.addAttribute("facilityDto", new FacilityDto());

        model.addAttribute("action", "openInfo");
        return "facility/facility";
    }

    @GetMapping("/update/{id}")
    public String showModalUpdate(@PathVariable int id, Model model,
                                  @RequestParam(defaultValue = "") String searchName,
                                  @RequestParam(defaultValue = "") String searchRentType,
                                  @RequestParam(defaultValue = "") String searchFacilityType,
                                  @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            BeanUtils.copyProperties(facility, facilityDto);
            model.addAttribute("action", "openUpdate");
        } else {
            model.addAttribute("action", "openFail");
            model.addAttribute("msg", "C?? s??? ko t???n t???i");
        }
        model.addAttribute("facilityDto", facilityDto);
        return "facility/facility";
    }

    @PostMapping("/update/{id}")
    public String updateByModal(@PathVariable int id,
                                @ModelAttribute FacilityDto facilityDto,
                                Model model, BindingResult bindingResult,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchRentType,
                                @RequestParam(defaultValue = "") String searchFacilityType,
                                @PageableDefault(value = 3) Pageable pageable) {

        Facility facility = facilityService.findById(id);
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        if (facility != null) {
            if (bindingResult.hasFieldErrors()) {
                model.addAttribute("action", "openUpdate");
                return "facility/facility";
            }
            BeanUtils.copyProperties(facilityDto, facility);
            facilityService.update(facility);
            model.addAttribute("action", "openMsg");
            model.addAttribute("msg", "C???p nh???t th??nh c??ng");
            model.addAttribute("facilityDto", new FacilityDto());
            return "facility/facility";
        }
        model.addAttribute("action", "openFail");
        model.addAttribute("msg", "C???p nh???t th???t b???i");
        return "facility/facility";
    }

    @PostMapping("/create")
    public String createByModal(@ModelAttribute @Validated FacilityDto facilityDto,
                                Model model, BindingResult bindingResult,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchRentType,
                                @RequestParam(defaultValue = "") String searchFacilityType,
                                @PageableDefault(value = 3) Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute("action", "openCreate");
            return "facility/facility";
        }
        Facility facility;
        if (facilityDto.getFacilityType().getId() == 1) {
            facility = new Villa();
        } else if (facilityDto.getFacilityType().getId() == 2) {
            facility = new House();
        } else {
            facility = new Room();
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.insert(facility);
        model.addAttribute("action", "openMsg");
        model.addAttribute("msg", "Th??m m???i th??nh c??ng");
        model.addAttribute("facilityDto", new FacilityDto());

        return "facility/facility";
    }


    @GetMapping("/delete")
    public String deleteByModal(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            boolean rs = facilityService.delete(id);
            if (rs) {
                redirectAttributes.addFlashAttribute("mesDelete", "X??a th??nh c??ng");
            } else {
                redirectAttributes.addFlashAttribute("mesDelete", "X??a th???t b???i");
            }
        } else {
            redirectAttributes.addFlashAttribute("mesDelete", "Kh??ng t???n t???i");
        }
        return "redirect:/facility";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("facilityDto", new FacilityDto());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        return "facility/create";
    }

    @PostMapping("/add")
    public String createNewByForm(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {

        if(bindingResult.hasFieldErrors()){
            return  "facility/create";
        }

        Facility facility;
        if (facilityDto.getFacilityType().getId() == 1) {
            facility = new Villa();
        } else if (facilityDto.getFacilityType().getId() == 2) {
            facility = new House();
        } else {
            facility = new Room();
        }
        BeanUtils.copyProperties(facilityDto, facility);
        facilityService.insert(facility);
        model.addAttribute("action", "openMsg");
        model.addAttribute("msg", "Th??m m???i th??nh c??ng");

        redirectAttributes.addFlashAttribute("message", "Th??m m???i  th??nh c??ng!");
        return "redirect:/facility";


    }
}
