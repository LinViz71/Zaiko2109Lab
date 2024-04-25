package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.BankOfficeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankOfficeResponseDto;
import tech.reliab.course.zaiko.bank.service.BankOfficeService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/banks/{bankId}/offices")
public class BankOfficeController {

    private static final String REDIRECT_OFFICE_LIST = "redirect:/banklab/banks/{bankId}/offices";
    private static final String REDIRECT_OFFICE_ITEM = "redirect:/banklab/banks/{bankId}/offices/{id}";
    private final BankOfficeService bankOfficeService;

    @PostMapping({"", "/"})
    public String postOffice(@ModelAttribute("bankOfficeRequestDto") BankOfficeRequestDto bankOfficeRequestDto,
                             @PathVariable("bankId") Long bankId) {
        bankOfficeService.create(bankOfficeRequestDto, bankId);
        return REDIRECT_OFFICE_LIST;
    }

    @GetMapping({"", "/"})
    public String getOffices(Model model,
                             @ModelAttribute("bankOfficeRequestDto") BankOfficeRequestDto bankOfficeRequestDto,
                             @PathVariable("bankId") Long bankId) {
        model.addAttribute("bankOfficeResponseDtos", bankOfficeService.getAllByBankId(bankId));
        return "office/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getOffice(Model model, @PathVariable("id") Long id,
                            @PathVariable("bankId") Long bankId) {
            model.addAttribute("bankOfficeResponseDto", bankOfficeService.getById(id));
            return "office/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putOffice(@PathVariable("id") Long id,
                            @ModelAttribute("bankOfficeResponseDto") BankOfficeResponseDto bankOfficeResponseDto,
                            @PathVariable("bankId") Long bankId) {
        bankOfficeService.update(bankOfficeResponseDto, bankId);
        return REDIRECT_OFFICE_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteOffice(@PathVariable("id") Long id,
                               @PathVariable("bankId") Long bankId) {
        bankOfficeService.deleteById(id);
        return REDIRECT_OFFICE_LIST;
    }
}
