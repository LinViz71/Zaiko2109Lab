package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.Bank;
import tech.reliab.course.zaiko.bank.entity.BankOffice;
import tech.reliab.course.zaiko.bank.entity.Employee;
import tech.reliab.course.zaiko.bank.service.EmployeeService;

import java.time.LocalDate;

public class EmployeeServiceImpl implements EmployeeService {

    /**
     * @param id             the id
     * @param fullName       the full name
     * @param dateOfBirth    the date of birth
     * @param position       the position
     * @param bank           the bank
     * @param isRemote       is remote
     * @param bankOffice     the bank office
     * @param canIssueCredit can issue credit
     * @param salary         the salary
     * @return {@link Employee}
     */
    @Override
    public Employee createEmployee(Long id,
                                   String fullName,
                                   LocalDate dateOfBirth,
                                   String position,
                                   Bank bank,
                                   Boolean isRemote,
                                   BankOffice bankOffice,
                                   Boolean canIssueCredit,
                                   Double salary) {
        bank.setEmployeesAmount(bank.getEmployeesAmount()+1);
        return Employee.builder()
                .id(id)
                .fullName(fullName)
                .dateOfBirth(dateOfBirth)
                .position(position)
                .bank(bank)
                .isRemote(isRemote)
                .bankOffice(bankOffice)
                .canIssueCredit(canIssueCredit)
                .salary(salary)
                .build();
    }

    @Override
    public Employee getEmployeeById(Long id) {
        return null;
    }

    @Override
    public void updateEmployeeById(Long id) {

    }

    @Override
    public void deleteEmployeeById(Long id) {

    }
}
