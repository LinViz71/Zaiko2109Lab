package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankResponseDto;
import tech.reliab.course.zaiko.bank.service.BankService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/banks")
public class BankController {

    private static final String REDIRECT_BANK_LIST = "redirect:/banklab/banks";
    private static final String REDIRECT_BANK_ITEM = "redirect:/banklab/banks/{id}";
    private final BankService bankService;

    @PostMapping({"", "/"})
    public String postBank(@ModelAttribute("bankRequestDto") BankRequestDto bankRequestDto) {
        bankService.create(bankRequestDto);
        return REDIRECT_BANK_LIST;
    }

    @GetMapping({"", "/"})
    public String getBanks(Model model, @ModelAttribute("bankRequestDto") BankRequestDto bankRequestDto) {
        model.addAttribute("bankResponseDtos", bankService.getAll());
        return "bank/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getBank(Model model, @PathVariable("id") Long id) {
            model.addAttribute("bankResponseDto", bankService.getById(id));
            return "bank/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putBank(@PathVariable("id") Long id,
                          @ModelAttribute("bankResponseDto") BankResponseDto bankResponseDto) {
        bankService.update(bankResponseDto);
        return REDIRECT_BANK_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteBank(@PathVariable("id") Long id) {
        bankService.deleteById(id);
        return REDIRECT_BANK_LIST;
    }
}
