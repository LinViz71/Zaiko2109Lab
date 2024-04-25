package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.BankAtm;
import tech.reliab.course.zaiko.bank.entity.BankOffice;
import tech.reliab.course.zaiko.bank.entity.Employee;

/**
 * The interface BankAtmService.
 */
public interface BankAtmService {

    /**
     * Create bank atm.
     *
     * @param id               the id
     * @param name             the name
     * @param status           the status
     * @param totalMoney       the total money
     * @param bankOffice       the bank office
     * @param servingEmployee  the serving employee
     * @param canDispenseMoney the can dispense money
     * @param canAcceptMoney   the can accept money
     * @param maintenanceCost  the maintenance cost
     * @param bank             the bank
     * @return the bank atm
     */
    BankAtm createBankAtm(Long id,
                          String name,
                          String status,
                          Bank bank,
                          BankOffice bankOffice,
                          Employee servingEmployee,
                          Boolean canDispenseMoney,
                          Boolean canAcceptMoney,
                          Double totalMoney,
                          Double maintenanceCost);

    /**
     * Get bank atm by id.
     *
     * @param id the id
     * @return the bank atm by id
     */
    BankAtm getBankAtmById(Long id);

    /**
     * Update bank atm by id.
     *
     * @param id      the id
     * @param bankAtm the bank atm
     */
    void updateBankAtmById(Long id, BankAtm bankAtm);

    /**
     * Delete bank atm by id.
     *
     * @param id      the id
     * @param bankAtm the bank atm
     */
    void deleteBankAtmById(Long id, BankAtm bankAtm);
}
