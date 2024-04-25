package tech.reliab.course.zaiko.bank.service.impl;

import tech.reliab.course.zaiko.bank.entity.BankOffice;
import tech.reliab.course.zaiko.bank.entity.Employee;
import tech.reliab.course.zaiko.bank.service.EmployeeService;

import java.time.LocalDate;
import java.util.ArrayList;

public class EmployeeServiceImpl implements EmployeeService {

    /**
     * @param id             the id
     * @param fullName       the full name
     * @param dateOfBirth    the date of birth
     * @param position       the position
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
                                   Boolean isRemote,
                                   Boolean canIssueCredit,
                                   Double salary,
                                   BankOffice bankOffice) {
        Employee employee = Employee.builder()
                .id(id)
                .fullName(fullName)
                .dateOfBirth(dateOfBirth)
                .position(position)
                .salary(salary)
                .isRemote(isRemote)
                .canIssueCredit(canIssueCredit)
                .bankOffice(bankOffice)
                .servedAtms(new ArrayList<>())
                .providedCreditAccounts(new ArrayList<>())
                .build();
        bankOffice.getEmployees().add(employee);
        return employee;
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
