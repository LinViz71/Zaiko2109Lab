package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.PaymentAccount;
import tech.reliab.course.zaiko.bank.entity.User;
import tech.reliab.course.zaiko.bank.service.PaymentAccountService;

public class PaymentAccountServiceImpl implements PaymentAccountService {

    /**
     * @param id      the id
     * @param user    the user
     *                <br>Name of the bank where this account is opened
     *                <br>Balance (0.0 by default)
     * @param bank    the bank
     * @return {@link PaymentAccount}
     */
    @Override
    public PaymentAccount createPaymentAccount(Long id, User user, Bank bank) {
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .id(id)
                .user(user)
                .bankName(bank.getName())
                .balance(0.0)
                .build();

        user.getPaymentAccounts().add(paymentAccount);
        return paymentAccount;
    }

    @Override
    public PaymentAccount getPaymentAccountById(Long id) {
        return null;
    }

    @Override
    public void updatePaymentAccountById(Long id) {

    }

    @Override
    public void deletePaymentAccountById(Long id) {

    }
}
