package daiphan.casestudy.controller.person;

import daiphan.casestudy.dto.person.ICustomerDto;
import daiphan.casestudy.model.dto.CustomerDto;
import daiphan.casestudy.model.person.Customer;
import daiphan.casestudy.model.person.CustomerType;
import daiphan.casestudy.service.person.ICustomerService;
import daiphan.casestudy.service.person.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/customer")
public class CustomerController {


    @Autowired
    private ICustomerService customerService;

    @Autowired
    private ICustomerTypeService customerTypeService;

    @GetMapping()
    public String showCustomers(@RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchAddress,
                                @RequestParam(defaultValue = "") String searchType,
                                Model model,
                                @PageableDefault(value = 3/*, sort = "customer.name",
                                        direction = Sort.Direction.DESC*/) Pageable pageable) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerDtoUpdate", new CustomerDto());

        useTotal(searchName,searchAddress,searchType,model,pageable);
        return "customer/customer";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customerDto", new CustomerDto());
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        return "customer/create";
    }

    @PostMapping("/create")
    public String createNew(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                            RedirectAttributes redirectAttributes, Model model) {
        new CustomerDto().validate(customerDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (ICustomerDto customer : customerService.findAllDto()) {
            if (customerDto.getIdCitizen().equals(customer.getIdCitizen())) {
                isDuplicateIdCard = true;
                break;
            }
        }

        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCitizen", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }

            LocalDate minAge = LocalDate.now().minusYears(80);
            LocalDate maxAge = LocalDate.now().minusYears(18);
            model.addAttribute("minAge", minAge);
            model.addAttribute("maxAge", maxAge);

            return "customer/create";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType());
        customer.setCustomerType(customerType);
        Customer c = customerService.insert(customer);
        if (c != null) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");
            return "redirect:/customer";
        }

        return "customer/create";

    }


    @PostMapping("/add")
    public String createNewByModal(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult,
                                   RedirectAttributes redirectAttributes, @RequestParam(defaultValue = "") String searchName,
                                   @RequestParam(defaultValue = "") String searchAddress,
                                   @RequestParam(defaultValue = "") String searchType,
                                   Model model,
                                   @PageableDefault(value = 3/*, sort = "customer.name",
                                        direction = Sort.Direction.DESC*/) Pageable pageable) {
        model.addAttribute("customerDtoUpdate", new CustomerDto());
        new CustomerDto().validate(customerDto, bindingResult);

        boolean isDuplicateIdCard = false;
        for (ICustomerDto customer : customerService.findAllDto()) {
            if (customerDto.getIdCitizen().equals(customer.getIdCitizen())) {
                isDuplicateIdCard = true;
                break;
            }
        }
        useTotal(searchName,searchAddress,searchType,model,pageable);
        if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
            model.addAttribute("customerTypeList", customerTypeService.findAll());

            if (isDuplicateIdCard) {
                model.addAttribute("duplicateIdCitizen", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
            }
            model.addAttribute("action", "openCreate");
            return "customer/customer";
        }

        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto, customer);
        CustomerType customerType = new CustomerType();
        customerType.setId(customerDto.getCustomerType());
        customer.setCustomerType(customerType);
        Customer c = customerService.insert(customer);
        if (c != null) {
            redirectAttributes.addFlashAttribute("message", "Thêm mới khách hàng thành công!");
            return "redirect:/customer";
        }

        return "customer/customer";

    }
    @GetMapping("/delete")
    public String deleteByModal(@RequestParam int id, RedirectAttributes redirectAttributes){
        Customer customer =customerService.findById(id);
        if(customer!=null){
            boolean rs = customerService.delete(id);
            if(rs){
                redirectAttributes.addFlashAttribute("mesDelete","Xóa thành công");
            }
            else{
                redirectAttributes.addFlashAttribute("mesDelete","Xóa thất bại");
            }
        }else{
            redirectAttributes.addFlashAttribute("mesDelete","Không tồn tại");
        }
        return "redirect:/customer";
    }

    @GetMapping("/update/{id}")
    public String showModalUpdate(@PathVariable int id,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchAddress,
                                @RequestParam(defaultValue = "") String searchType,
                                Model model,
                                @PageableDefault(value = 3/*, sort = "customer.name",
                                        direction = Sort.Direction.DESC*/) Pageable pageable) {

        CustomerDto customerDtoUpdate = new CustomerDto();
        Customer customer = customerService.findById(id);
        if (customer != null) {
            BeanUtils.copyProperties(customer, customerDtoUpdate);
            customerDtoUpdate.setCustomerType(customer.getId());

            model.addAttribute("customerDtoUpdate", customerDtoUpdate);
            model.addAttribute("customerDto", new CustomerDto());

            useTotal(searchName,searchAddress,searchType,model,pageable);

            model.addAttribute("action","openUpdate");
            return "customer/customer";
        }
        return "/layout";
    }
    @PostMapping("/update/{id}")
    public String updateByModal(@PathVariable int id,
                                @ModelAttribute CustomerDto customerDtoUpdate,
                                @RequestParam(defaultValue = "") String searchName,
                                @RequestParam(defaultValue = "") String searchAddress,
                                @RequestParam(defaultValue = "") String searchType,
                                Model model,BindingResult bindingResult,
                                @PageableDefault(value = 3/*, sort = "customer.name",
                                        direction = Sort.Direction.DESC*/) Pageable pageable) {

        Customer customer = customerService.findById(id);
        if (customer != null) {
            new CustomerDto().validate(customerDtoUpdate, bindingResult);

            boolean isDuplicateIdCard = false;
            List<ICustomerDto> customerDtos =customerService.findAllDto();
            for (ICustomerDto customerDto : customerDtos) {
                if (customerDtoUpdate.getIdCitizen().equals(customerDto.getIdCitizen()) &&
                        !customerDtoUpdate.getIdCitizen().equals(customer.getIdCitizen())) {
                    isDuplicateIdCard = true;
                    break;
                }
            }
            useTotal(searchName,searchAddress,searchType,model,pageable);
            if (bindingResult.hasFieldErrors() || isDuplicateIdCard) {
                model.addAttribute("customerTypeList", customerTypeService.findAll());

                if (isDuplicateIdCard) {
                    model.addAttribute("duplicateIdCitizen", "Số CMND/CCCD đã tồn tại, vui lòng kiểm tra lại.");
                }
                model.addAttribute("action", "openUpdate");
                return "customer/customer";
            }

            BeanUtils.copyProperties( customerDtoUpdate,customer);
            CustomerType customerType =new CustomerType();
            customerType.setId(customerDtoUpdate.getCustomerType());
            customer.setCustomerType(customerType);
            customerService.update(customer);
            model.addAttribute("customerDtoUpdate", new CustomerDto());
            model.addAttribute("customerDto", new CustomerDto());
            useTotal(searchName,searchAddress,searchType,model,pageable);

            return "customer/customer";
        }
        return "/layout";
    }

    private void useTotal(@RequestParam(defaultValue = "") String searchName,
                          @RequestParam(defaultValue = "") String searchAddress,
                          @RequestParam(defaultValue = "") String searchType,
                          Model model,
                          @PageableDefault(value = 3/*, sort = "customer.name",
                                        direction = Sort.Direction.DESC*/) Pageable pageable){
        model.addAttribute("customerTypeList", customerTypeService.findAll());
        LocalDate minAge = LocalDate.now().minusYears(80);
        LocalDate maxAge = LocalDate.now().minusYears(18);
        model.addAttribute("minAge", minAge);
        model.addAttribute("maxAge", maxAge);
        model.addAttribute("searchName", searchName);
        model.addAttribute("searchAddress", searchAddress);
        model.addAttribute("searchType", searchType);
        model.addAttribute("customers", customerService.find(searchName, searchAddress, searchType, pageable));

    }
}
