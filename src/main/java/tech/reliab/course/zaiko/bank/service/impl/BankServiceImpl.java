package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.service.BankService;

import java.util.Random;

/**
 * The type Bank service.
 */
public class BankServiceImpl implements BankService {

    /**
     * @param id   the id
     * @param name the name<br>
     *             <br>Number of offices (automatically filled and calculated when adding a new office, default 0 <br>
     *             Number of ATMs (automatically filled and calculated when adding a new ATM, default 0<br>
     *             Number of employees (automatically filled and calculated when adding a new employee, default 0<br>
     *             Number of clients (automatically filled and calculated when adding a new client, default 0<br>
     *             Bank rating (generated randomly, from 0 to 100, where 100 is the highest score, the higher the bank rating, the lower the interest rate)<br>
     *             Total money in the bank (generated randomly, but not more than 1,000,000)<br>
     *             Interest rate (generated randomly, but not more than 20%, however, the bank rating must be taken into account, the higher it is, the lower the interest rate should be generated)<br>
     * @return {@link Bank}
     */
    @Override
    public Bank createBank(Long id, String name) {
        Random random = new Random();
        Bank bank = Bank.builder()
                .id(id)
                .name(name)
                .officesAmount(0)
                .atmsAmount(0)
                .employeesAmount(0)
                .customersAmount(0)
                .rating(random.nextInt(101))
                .totalMoney(Math.round(random.nextDouble(1_000_000) * 100.0) / 100.0)
                .build();
        bank.setInterestRate(Math.round((20 - bank.getRating() * 0.2) * 100.0) / 100.0);
        return bank;
    }

    @Override
    public Bank getBankById(Long id) {
        return null;
    }

    @Override
    public void updateBankById(Long id, Bank bank) {
    }

    @Override
    public void deleteBankById(Long id, Bank bank) {

    }
}
