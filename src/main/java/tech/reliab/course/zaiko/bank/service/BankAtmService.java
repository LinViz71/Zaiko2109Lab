package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.BankAtm;
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
     * @param canDispenseMoney the can dispense money
     * @param canAcceptMoney   the can accept money
     * @param maintenanceCost  the maintenance cost
     * @param servingEmployee  the serving employee
     * @return the bank atm
     */
    BankAtm createBankAtm(Long id,
                          String name,
                          String address,
                          String status,
                          Double totalMoney,
                          Double maintenanceCost,
                          Boolean canDispenseMoney,
                          Boolean canAcceptMoney,
                          Employee servingEmployee);

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
