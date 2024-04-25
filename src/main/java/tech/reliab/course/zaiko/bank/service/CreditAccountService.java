package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.*;

import java.time.LocalDate;

/**
 * The interface CreditAccountService.
 */
public interface CreditAccountService {

    /**
     * Create credit account.
     *
     * @param id                  the id
     * @param user                the user
     * @param startDate           the start date
     * @param endDate             the end date
     * @param monthOfCreditAmount the month of credit amount
     * @param creditSum           the credit sum
     * @param monthlyPayment      the monthly payment
     * @param providedEmployee    the provided employee
     * @param paymentAccount      the payment account
     * @param bank                the bank
     * @return the credit account
     */
    CreditAccount createCreditAccount(Long id,
                                      User user,
                                      LocalDate startDate,
                                      LocalDate endDate,
                                      Integer monthOfCreditAmount,
                                      Double creditSum,
                                      Double monthlyPayment,
                                      Employee providedEmployee,
                                      PaymentAccount paymentAccount,
                                      Bank bank);

    /**
     * Gets credit account by id.
     *
     * @param id the id
     * @return the credit account by id
     */
    CreditAccount getCreditAccountById(Long id);

    /**
     * Update credit account by id.
     *
     * @param id the id
     */
    void updateCreditAccountById(Long id);

    /**
     * Delete credit account by id.
     *
     * @param id the id
     */
    void deleteCreditAccountById(Long id);
}
