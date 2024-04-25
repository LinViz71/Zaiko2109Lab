package tech.reliab.course.zaiko.bank.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import tech.reliab.course.zaiko.bank.model.dto.request.PaymentAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.PaymentAccountResponseDto;
import tech.reliab.course.zaiko.bank.service.BankService;
import tech.reliab.course.zaiko.bank.service.PaymentAccountService;

@Controller
@AllArgsConstructor
@RequestMapping("banklab/users/{userId}/pay-accs")
public class PaymentAccountController {

    private static final String REDIRECT_PAYMENT_ACCOUNT_LIST = "redirect:/banklab/users/{userId}/pay-accs";
    private static final String REDIRECT_PAYMENT_ACCOUNT_ITEM = "redirect:/banklab/users/{userId}/pay-accs/{id}";
    private final PaymentAccountService paymentAccountService;
    private final BankService bankService;

    @PostMapping({"", "/"})
    public String postPaymentAccount(@ModelAttribute("paymentAccountRequestDto") PaymentAccountRequestDto paymentAccountRequestDto,
                                     @PathVariable("userId") Long userId) {
        paymentAccountService.create(paymentAccountRequestDto, userId);
        return REDIRECT_PAYMENT_ACCOUNT_LIST;
    }

    @GetMapping({"", "/"})
    public String getPaymentAccounts(Model model,
                                     @ModelAttribute("paymentAccountRequestDto") PaymentAccountRequestDto paymentAccountRequestDto,
                                     @PathVariable("userId") Long userId) {
        model.addAttribute("paymentAccountResponseDtos", paymentAccountService.getAllByUserId(userId));
        model.addAttribute("bankResponseDtos", bankService.getAll());
        return "payment_account/list";
    }

    @GetMapping({"/{id}", "/{id}/"})
    public String getPaymentAccount(Model model, @PathVariable("id") Long id,
                                    @PathVariable("userId") Long userId) {
        PaymentAccountResponseDto paymentAccountResponseDto = paymentAccountService.getById(id);
        model.addAttribute("paymentAccountResponseDto", paymentAccountResponseDto);
        model.addAttribute("bankResponseDto", bankService.getById(paymentAccountResponseDto.getBankId()));
        model.addAttribute("bankResponseDtos", bankService.getAll());

        return "payment_account/item";
    }

    @PutMapping({"/{id}", "/{id}/"})
    public String putPaymentAccount(@PathVariable("id") Long id,
                                     @ModelAttribute("paymentAccountResponseDto") PaymentAccountResponseDto paymentAccountResponseDto,
                                     @PathVariable("userId") Long userId) {
        paymentAccountService.update(paymentAccountResponseDto, userId);
        return REDIRECT_PAYMENT_ACCOUNT_ITEM;
    }

    @DeleteMapping({"/{id}", "/{id}/"})
    public String deletePaymentAccount(@PathVariable("id") Long id,
                                        @PathVariable("userId") Long userId) {
        paymentAccountService.deleteById(id);
        return REDIRECT_PAYMENT_ACCOUNT_LIST;
    }
}
