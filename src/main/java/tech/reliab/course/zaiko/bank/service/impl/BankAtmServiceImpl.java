package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.BankAtm;
import tech.reliab.course.zaiko.bank.entity.BankOffice;
import tech.reliab.course.zaiko.bank.entity.Employee;
import tech.reliab.course.zaiko.bank.service.BankAtmService;

public class BankAtmServiceImpl implements BankAtmService {

    /**
     * @param id               the id
     * @param name             the name
     *                         <br>Address (matches the address of the bank office)
     * @param status           the status (working/not working/no money)
     * @param bank             the bank
     * @param bankOffice       the bank office (an ATM can only be located in a bank office)
     * @param servingEmployee  the serving employee
     * @param canDispenseMoney can dispense money
     * @param canAcceptMoney   can accept money
     * @param totalMoney       the total money
     * @param maintenanceCost  the maintenance cost
     * @return {@link BankAtm}
     */
    @Override
    public BankAtm createBankAtm(Long id,
                                 String name,
                                 String status,
                                 Bank bank,
                                 BankOffice bankOffice,
                                 Employee servingEmployee,
                                 Boolean canDispenseMoney,
                                 Boolean canAcceptMoney,
                                 Double totalMoney,
                                 Double maintenanceCost) {
        BankAtm bankAtm = BankAtm.builder()
                .id(id)
                .name(name)
                .address(bankOffice.getAddress())
                .status(status)
                .bank(bank)
                .bankOffice(bankOffice)
                .servingEmployee(servingEmployee)
                .canDispenseMoney(canDispenseMoney)
                .canAcceptMoney(canAcceptMoney)
                .maintenanceCost(maintenanceCost)
                .build();
        bank.setAtmsAmount(bank.getAtmsAmount() + 1);
        bankOffice.setAtmsAmount(bankOffice.getAtmsAmount() + 1);
        if (bank.getTotalMoney() < totalMoney) {
            throw new IllegalArgumentException("Денег в банке меньше, чем передаётся банкомату");
        } else {
            bankAtm.setTotalMoney(totalMoney);
        }
        return bankAtm;
    }

    @Override
    public BankAtm getBankAtmById(Long id) {
        return null;
    }

    @Override
    public void updateBankAtmById(Long id, BankAtm bankAtm) {

    }

    @Override
    public void deleteBankAtmById(Long id, BankAtm bankAtm) {

    }
}
