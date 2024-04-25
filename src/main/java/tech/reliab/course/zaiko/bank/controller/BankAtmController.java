package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.BankAtmRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankAtmResponseDto;
import tech.reliab.course.zaiko.bank.service.BankAtmService;


@Controller
@AllArgsConstructor
@RequestMapping("banklab/banks/{bankId}/offices/{officeId}/employees/{employeeId}/atms")
public class BankAtmController {

    private static final String REDIRECT_ATM_LIST = "redirect:/banklab/banks/{bankId}/offices/{officeId}/employees/{employeeId}/atms";
    private static final String REDIRECT_ATM_ITEM = "redirect:/banklab/banks/{bankId}/offices/{officeId}/employees/{employeeId}/atms/{id}";
    private final BankAtmService bankAtmService;

    @PostMapping({"", "/"})
    public String postAtm(@ModelAttribute("atmRequestDto") BankAtmRequestDto bankAtmRequestDto,
                          @PathVariable("bankId") Long bankId,
                          @PathVariable("officeId") Long bankOfficeId,
                          @PathVariable("employeeId") Long employeeId
    ) {
        bankAtmService.create(bankAtmRequestDto, employeeId);
        return REDIRECT_ATM_LIST;
    }

    @GetMapping({"", "/"})
    public String getAtms(Model model,
                          @ModelAttribute("atmRequestDto") BankAtmRequestDto bankAtmRequestDto,
                          @PathVariable("bankId") Long bankId,
                          @PathVariable("officeId") Long bankOfficeId,
                          @PathVariable("employeeId") Long employeeId) {
        model.addAttribute("atmResponseDtos", bankAtmService.getAllByServingEmployeeId(employeeId));
        return "atm/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getAtm(Model model, @PathVariable("id") Long id,
                         @PathVariable("bankId") Long bankId,
                         @PathVariable("officeId") Long bankOfficeId,
                         @PathVariable("employeeId") Long employeeId) {
        model.addAttribute("atmResponseDto", bankAtmService.getById(id));
        return "atm/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putAtm(@PathVariable("id") Long id,
                         @ModelAttribute("atmResponseDto") BankAtmResponseDto bankAtmResponseDto,
                         @PathVariable("bankId") Long bankId,
                         @PathVariable("officeId") Long bankOfficeId,
                         @PathVariable("employeeId") Long employeeId) {
        bankAtmService.update(bankAtmResponseDto, employeeId);
        return REDIRECT_ATM_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteAtm(@PathVariable("id") Long id,
                            @PathVariable("bankId") Long bankId,
                            @PathVariable("officeId") Long bankOfficeId,
                            @PathVariable("employeeId") Long employeeId) {
        bankAtmService.deleteById(id);
        return REDIRECT_ATM_LIST;
    }
}