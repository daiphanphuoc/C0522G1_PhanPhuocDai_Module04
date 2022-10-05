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
                          Pageable pageable) {
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchRentType", searchRentType);
        model.addAttribute("searchFacilityType", searchFacilityType);
        model.addAttribute("newFacilityDto", new FacilityDto());
        model.addAttribute("facility", new FacilityDto());
        model.addAttribute("updateFacilityDto", new FacilityDto());
        model.addAttribute("rentTypeList", rentTypeService.findAll());
        model.addAttribute("facilityTypeList", facilityTypeService.findAll());
        model.addAttribute("facilityList", facilityService.find(searchName, searchRentType, searchFacilityType, pageable));

    }

    @GetMapping
    public String showFacility(Model model,
                               @RequestParam(defaultValue = "") String searchName,
                               @RequestParam(defaultValue = "") String searchRentType,
                               @RequestParam(defaultValue = "") String searchFacilityType,
                               Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);
        return "facility/facility";
    }

    @GetMapping("/view/{id}")
    public String showInfo(@PathVariable int id, Model model,
                           @RequestParam(defaultValue = "") String searchName,
                           @RequestParam(defaultValue = "") String searchRentType,
                           @RequestParam(defaultValue = "") String searchFacilityType,
                           Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        BeanUtils.copyProperties(facility, facilityDto);
        model.addAttribute("facility", facilityDto);

        model.addAttribute("action", "openInfo");
        return "facility/facility";
    }

    @GetMapping("/update/{id}")
    public String showModalUpdate(@PathVariable int id, Model model,
                                  @RequestParam(defaultValue = "") String searchName,
                                  @RequestParam(defaultValue = "") String searchRentType,
                                  @RequestParam(defaultValue = "") String searchFacilityType,
                                  Pageable pageable) {
        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

        FacilityDto facilityDto = new FacilityDto();
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            BeanUtils.copyProperties(facility, facilityDto);
            model.addAttribute("updateFacilityDto", facilityDto);
            model.addAttribute("action", "openUpdate");
        } else {
            model.addAttribute("action", "openFail");
            model.addAttribute("msg", "Cơ sở ko tồn tại");
        }
        return "facility/facility";
    }

    @PostMapping("/update/{id}")
    public String updateByModal(@PathVariable int id,
                                @ModelAttribute FacilityDto updateFacilityDto,
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
            BeanUtils.copyProperties(updateFacilityDto, facility);
            facilityService.update(facility);
            model.addAttribute("action", "openMsg");
            model.addAttribute("msg", "Cập nhật thành công");
            return "facility/facility";
        }
        model.addAttribute("action", "openFail");
        model.addAttribute("msg", "Cập nhật thất bại");
        return "facility/facility";
    }

    @PostMapping("/create")
    public String createByModal(@PathVariable int id,
                                @ModelAttribute @Validated FacilityDto newFacilityDto,
                                Model model, BindingResult bindingResult,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchRentType,
                                @RequestParam(defaultValue = "") String searchFacilityType,
                                @PageableDefault(value = 3) Pageable pageable) {


        useTotal(model, searchName, searchRentType, searchFacilityType, pageable);

       /* if (bindingResult.hasFieldErrors()) {
            model.addAttribute("action", "openCreate");
            return "facility/facility";
        }*/
        Facility facility;
        if (newFacilityDto.getFacilityType().getId() == 1) {
            facility = new Villa();
        } else if (newFacilityDto.getFacilityType().getId() == 2) {
            facility = new House();
        } else {
            facility = new Room();
        }
        BeanUtils.copyProperties(newFacilityDto, facility);
        facilityService.insert(facility);
        model.addAttribute("action", "openMsg");
        model.addAttribute("msg", "Thêm mới thành công");
        return "facility/facility";
    }


    @GetMapping("/delete")
    public String deleteByModal(@RequestParam int id, RedirectAttributes redirectAttributes) {
        Facility facility = facilityService.findById(id);
        if (facility != null) {
            boolean rs = facilityService.delete(id);
            if (rs) {
                redirectAttributes.addFlashAttribute("mesDelete", "Xóa thành công");
            } else {
                redirectAttributes.addFlashAttribute("mesDelete", "Xóa thất bại");
            }
        } else {
            redirectAttributes.addFlashAttribute("mesDelete", "Không tồn tại");
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
    public String createNew(@ModelAttribute @Validated FacilityDto facilityDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {


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
        model.addAttribute("msg", "Thêm mới thành công");

        redirectAttributes.addFlashAttribute("message", "Thêm mới nhân viên thành công!");
        return "redirect:/facility";


    }
}
