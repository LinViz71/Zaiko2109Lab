package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.EmployeeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.EmployeeResponseDto;
import tech.reliab.course.zaiko.bank.service.EmployeeService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/banks/{bankId}/offices/{officeId}/employees")
public class EmployeeController {

    private static final String REDIRECT_EMPLOYEE_LIST = "redirect:/banklab/banks/{bankId}/offices/{officeId}/employees";
    private static final String REDIRECT_EMPLOYEE_ITEM = "redirect:/banklab/banks/{bankId}/offices/{officeId}/employees/{id}";
    private final EmployeeService employeeService;

    @PostMapping({"", "/"})
    public String postEmployee(@ModelAttribute("employeeRequestDto") EmployeeRequestDto employeeRequestDto,
                               @PathVariable("officeId") Long bankOfficeId,
                               @PathVariable("bankId") Long bankId) {
        employeeService.create(employeeRequestDto, bankOfficeId);
        return REDIRECT_EMPLOYEE_LIST;
    }

    @GetMapping({"", "/"})
    public String getEmployees(Model model,
                               @ModelAttribute("employeeRequestDto") EmployeeRequestDto employeeRequestDto,
                               @PathVariable("officeId") Long bankOfficeId,
                               @PathVariable("bankId") Long bankId) {
        model.addAttribute("employeeResponseDtos", employeeService.getAllByBankOfficeId(bankOfficeId));
        return "employee/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getEmployee(Model model, @PathVariable("id") Long id,
                            @PathVariable("officeId") Long bankOfficeId,
                            @PathVariable("bankId") Long bankId) {
        model.addAttribute("employeeResponseDto", employeeService.getById(id));
        return "employee/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putEmployee(@PathVariable("id") Long id,
                            @ModelAttribute("employeeResponseDto") EmployeeResponseDto employeeResponseDto,
                            @PathVariable("officeId") Long bankOfficeId,
                            @PathVariable("bankId") Long bankId) {
        employeeService.update(employeeResponseDto, bankOfficeId);
        return REDIRECT_EMPLOYEE_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteEmployee(@PathVariable("id") Long id,
                               @PathVariable("officeId") Long bankOfficeId,
                               @PathVariable("bankId") Long bankId) {
        employeeService.deleteById(id);
        return REDIRECT_EMPLOYEE_LIST;
    }
}