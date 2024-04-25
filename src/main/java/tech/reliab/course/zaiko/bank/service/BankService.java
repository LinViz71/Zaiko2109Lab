package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.entity.Bank;

/**
 * The interface Bank service.
 */
public interface BankService {

    /**
     * Create bank.
     *
     * @param id   the id
     * @param name the name
     * @return the bank
     */
    Bank createBank(Long id, String name);

    /**
     * Get bank by id.
     *
     * @param id the id
     * @return the bank by id
     */
    Bank getBankById(Long id);

    /**
     * Update bank by id.
     *
     * @param id   the id
     * @param bank the bank
     */
    void updateBankById(Long id, Bank bank);

    /**
     * Delete bank by id.
     *
     * @param id   the id
     * @param bank the bank
     */
    void deleteBankById(Long id, Bank bank);
}
