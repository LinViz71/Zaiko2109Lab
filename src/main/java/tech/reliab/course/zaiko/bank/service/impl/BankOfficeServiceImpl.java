package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.BankOffice;
import tech.reliab.course.zaiko.bank.service.BankOfficeService;

import java.util.ArrayList;

public class BankOfficeServiceImpl implements BankOfficeService {

    /**
     * @param id               the id
     * @param name             the name
     * @param address          the address
     * @param isWorking        is working
     * @param canPlaceAtm      can place atm (directly depends on the total number of ATMs of the bank)
     * @param canIssueCredit   can issue credit
     * @param canDispenseMoney can dispense money
     * @param canAcceptMoney   can accept money
     * @param totalMoney       the total money (directly depends on the field "Total money in the bank")
     * @param rentCost         the rent cost
     * @param bank             the bank
     * @return {@link BankOffice}
     */
    @Override
    public BankOffice createBankOffice(Long id,
                                       String name,
                                       String address,
                                       Double totalMoney,
                                       Double rentCost,
                                       Boolean isWorking,
                                       Boolean canPlaceAtm,
                                       Boolean canIssueCredit,
                                       Boolean canDispenseMoney,
                                       Boolean canAcceptMoney,
                                       Bank bank) {
        BankOffice bankOffice = BankOffice
                .builder()
                .id(id)
                .name(name)
                .address(address)
                .rentCost(rentCost)
                .isWorking(isWorking)
                .canPlaceAtm(canPlaceAtm)
                .canIssueCredit(canIssueCredit)
                .canDispenseMoney(canDispenseMoney)
                .canAcceptMoney(canAcceptMoney)
                .bankAtms(new ArrayList<>())
                .employees(new ArrayList<>())
                .bank(bank)
                .build();
        if (bank.getTotalMoney() < totalMoney) {
            throw new IllegalArgumentException("Wrong money amount in bank/office");
        } else {
            bankOffice.setTotalMoney(totalMoney);
        }
        bank.getOffices().add(bankOffice);

        return bankOffice;
    }

    @Override
    public BankOffice getBankOfficeById(Long id) {
        return null;
    }

    @Override
    public void updateBankOfficeById(Long id) {

    }

    @Override
    public void deleteBankOfficeById(Long id) {

    }
}
