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
     * @param isWorking        is working
     * @param canPlaceAtm      can place atm
     * @param rentCost         the rent cost
     * @param canIssueCredit   can issue credit
     * @param canDispenseMoney can dispense money
     * @param canAcceptMoney   can accept money
     * @param bank             the bank
     * @return the bank office
     */
    BankOffice createBankOffice(Long id,
                                String name,
                                String address,
                                Double totalMoney,
                                Double rentCost,
                                Boolean isWorking,
                                Boolean canPlaceAtm,
                                Boolean canIssueCredit,
                                Boolean canDispenseMoney,
                                Boolean canAcceptMoney,
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
