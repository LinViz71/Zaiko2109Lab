package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.*;
import tech.reliab.course.zaiko.bank.service.CreditAccountService;

import java.time.LocalDate;

public class CreditAccountServiceImpl implements CreditAccountService {

    /**
     * @param id                   the id
     * @param user                 the user
     *                             <br>Name of the bank where the loan was taken
     * @param startDate            the start date
     * @param endDate              the end date
     * @param monthsOfCreditAmount the month of credit amount
     * @param creditSum            the credit sum
     * @param monthlyPayment       the monthly payment
     *                             <br>Interest rate (equals the interest rate of the bank)
     * @param providedEmployee     the provided employee
     * @param paymentAccount       the payment account
     * @param bank                 the bank
     * @return {@link CreditAccount}
     */
    @Override
    public CreditAccount createCreditAccount(Long id,
                                             User user,
                                             LocalDate startDate,
                                             LocalDate endDate,
                                             Integer monthsOfCreditAmount,
                                             Double creditSum,
                                             Double monthlyPayment,
                                             Employee providedEmployee,
                                             PaymentAccount paymentAccount,
                                             Bank bank) {
        CreditAccount creditAccount = CreditAccount.builder()
                .id(id)
                .user(user)
                .bankName(bank.getName())
                .startDate(startDate)
                .endDate(endDate)
                .monthsOfCreditAmount(monthsOfCreditAmount)
                .creditSum(creditSum)
                .monthlyPayment(monthlyPayment)
                .interestRate(bank.getInterestRate())
                .providedEmployee(providedEmployee)
                .paymentAccount(paymentAccount)
                .build();
        user.getCreditAccounts().add(creditAccount);
        return creditAccount;
    }

    @Override
    public CreditAccount getCreditAccountById(Long id) {
        return null;
    }

    @Override
    public void updateCreditAccountById(Long id) {

    }

    @Override
    public void deleteCreditAccountById(Long id) {

    }
}
