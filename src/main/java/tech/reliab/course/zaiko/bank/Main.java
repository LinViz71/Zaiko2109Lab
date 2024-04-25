package tech.reliab.course.zaiko.bank;

import tech.reliab.course.zaiko.bank.entity.*;
import tech.reliab.course.zaiko.bank.service.*;
import tech.reliab.course.zaiko.bank.service.impl.*;

import java.time.LocalDate;
import java.util.List;

public class Main {

    public static void main(String[] args) {


        BankService bankService = new BankServiceImpl();
        BankAtmService bankAtmService = new BankAtmServiceImpl();
        BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
        CreditAccountService creditAccountService = new CreditAccountServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
        UserService userService = new UserServiceImpl();

        Bank bank = bankService.createBank(
                1L,
                "Alfa bank");
        BankOffice bankOffice = bankOfficeService.createBankOffice(
                1L,
                "Alfa office #11",
                "Alfovskaya, 33",
                true,
                true,
                0,
                true,
                true,
                true,
                1.0,
                1.0,
                bank
        );
        Employee employee = employeeService.createEmployee(
                1L,
                "Petrov Petr Petrovich",
                LocalDate.now(),
                "Manager", bank,
                true,
                bankOffice,
                true,
                1.0);
        BankAtm bankAtm = bankAtmService.createBankAtm(
                1L,
                "Alfa ATM #33",
                "Working",
                bank,
                bankOffice,
                employee,
                true,
                true,
                1.0,
                1.0
        );
        User user = userService.createUser(
                1L,
                "Ivanov Ivan Ivanovich",
                LocalDate.now(),
                "X5",
                List.of(bank)
        );
        PaymentAccount paymentAccount = paymentAccountService.createPaymentAccount(
                1L,
                user,
                bank
        );
        CreditAccount creditAccount = creditAccountService.createCreditAccount(
                1L,
                user,
                LocalDate.now(),
                LocalDate.now(),
                1,
                1.0,
                1.0,
                employee,
                paymentAccount,
                bank
        );
        System.out.println(bank);
        System.out.println();
        System.out.println(bankAtm);
        System.out.println();
        System.out.println(bankOffice);
        System.out.println();
        System.out.println(creditAccount);
        System.out.println();
        System.out.println(employee);
        System.out.println();
        System.out.println(paymentAccount);
        System.out.println();
        System.out.println(user);
    }
}
