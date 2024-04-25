package tech.reliab.course.zaiko.bank.service.impl;

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
     * @param totalMoney       the total money
     * @param maintenanceCost  the maintenance cost
     * @param canDispenseMoney can dispense money
     * @param canAcceptMoney   can accept money
     *                         the bank office (an ATM can only be located in a bank office)
     * @param servingEmployee  the serving employee
     * @return {@link BankAtm}
     */
    @Override
    public BankAtm createBankAtm(Long id,
                                 String name,
                                 String address,
                                 String status,
                                 Double totalMoney,
                                 Double maintenanceCost,
                                 Boolean canDispenseMoney,
                                 Boolean canAcceptMoney,
                                 Employee servingEmployee) {
        BankOffice bankOffice = servingEmployee.getBankOffice();
        BankAtm bankAtm = BankAtm.builder()
                .id(id)
                .name(name)
                .address(address)
                .status(status)
                .canDispenseMoney(canDispenseMoney)
                .canAcceptMoney(canAcceptMoney)
                .maintenanceCost(maintenanceCost)
                .bankOffice(bankOffice)
                .servingEmployee(servingEmployee)
                .build();
        bankOffice.getBankAtms().add(bankAtm);
        servingEmployee.getServedAtms().add(bankAtm);
        if (bankOffice.getTotalMoney() < totalMoney) {
            throw new IllegalArgumentException("Денег в офисе банка меньше, чем передаётся банкомату");
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
