package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.BankOffice;

/**
 * The interface Bank office service.
 */
public interface BankOfficeService {

    /**
     * Create bank office.
     *
     * @param id               the id
     * @param name             the name
     * @param address          the address
     * @param isWorking        the is working
     * @param canPlaceAtm      the can place atm
     * @param amountOfAtms     the amount of atms
     * @param canIssueCredit   the can issue credit
     * @param canDispenseMoney the can dispense money
     * @param canAcceptMoney   the can accept money
     * @param rentCost         the rent cost
     * @param bank             the bank
     * @return the bank office
     */
    BankOffice createBankOffice(Long id,
                                String name,
                                String address,
                                Boolean isWorking,
                                Boolean canPlaceAtm,
                                Integer amountOfAtms,
                                Boolean canIssueCredit,
                                Boolean canDispenseMoney,
                                Boolean canAcceptMoney,
                                Double totalMoney,
                                Double rentCost,
                                Bank bank);

    /**
     * Gets bank office by id.
     *
     * @param id the id
     * @return the bank office by id
     */
    BankOffice getBankOfficeById(Long id);

    /**
     * Update bank office by id.
     *
     * @param id the id
     */
    void updateBankOfficeById(Long id);

    /**
     * Delete bank office by id.
     *
     * @param id the id
     */
    void deleteBankOfficeById(Long id);
}
