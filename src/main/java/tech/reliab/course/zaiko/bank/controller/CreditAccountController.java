package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.CreditAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.CreditAccountResponseDto;
import tech.reliab.course.zaiko.bank.service.BankService;
import tech.reliab.course.zaiko.bank.service.CreditAccountService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/users/{userId}/pay-accs/{payAccId}/cred-accs")
public class CreditAccountController {

    private static final String REDIRECT_CREDIT_ACCOUNT_LIST = "redirect:/banklab/users/{userId}/pay-accs/{payAccId}/cred-accs";
    private static final String REDIRECT_CREDIT_ACCOUNT_ITEM = "redirect:/banklab/users/{userId}/pay-accs/{payAccId}/cred-accs/{id}";
    private final CreditAccountService creditAccountService;
    private final BankService bankService;

    @PostMapping({"", "/"})
    public String postCreditAccount(@ModelAttribute("creditAccountRequestDto") CreditAccountRequestDto creditAccountRequestDto,
                                    @PathVariable("userId") Long userId,
                                    @PathVariable("payAccId") Long payAccId
    ) {
        creditAccountService.create(creditAccountRequestDto, payAccId);
        return REDIRECT_CREDIT_ACCOUNT_LIST;
    }

    @GetMapping({"", "/"})
    public String getCreditAccounts(Model model,
                                    @ModelAttribute("creditAccountRequestDto") CreditAccountRequestDto creditAccountRequestDto,
                                    @PathVariable("userId") Long userId,
                                    @PathVariable("payAccId") Long payAccId) {
        model.addAttribute("creditAccountResponseDtos", creditAccountService.getAllByPayAccId(payAccId));
        model.addAttribute("bankResponseDtos", bankService.getAll());
        return "credit_account/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getCreditAccount(Model model, @PathVariable("id") Long id,
                                   @PathVariable("userId") Long userId,
                                   @PathVariable("payAccId") Long payAccId) {
        CreditAccountResponseDto creditAccountResponseDto = creditAccountService.getById(id);
        model.addAttribute("creditAccountResponseDto", creditAccountResponseDto);
        return "credit_account/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putCreditAccount(@ModelAttribute("creditAccountResponseDto") CreditAccountResponseDto creditAccountResponseDto,
                                   @PathVariable("id") Long id,
                                   @PathVariable("userId") Long userId,
                                   @PathVariable("payAccId") Long payAccId) {
        creditAccountService.update(creditAccountResponseDto);
        return REDIRECT_CREDIT_ACCOUNT_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deleteCreditAccount(@PathVariable("id") Long id,
                                      @PathVariable("userId") Long userId,
                                      @PathVariable("payAccId") Long payAccId) {
        creditAccountService.deleteById(id);
        return REDIRECT_CREDIT_ACCOUNT_LIST;
    }
}
