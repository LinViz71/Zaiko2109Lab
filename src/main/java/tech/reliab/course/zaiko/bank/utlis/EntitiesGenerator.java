package tech.reliab.course.zaiko.bank.utlis;

import tech.reliab.course.zaiko.bank.entity.*;
import tech.reliab.course.zaiko.bank.service.*;
import tech.reliab.course.zaiko.bank.service.impl.*;

import java.time.LocalDate;
import java.util.Random;
import java.util.UUID;

public class EntitiesGenerator {

    private static long idCounter = 0L;
    private final BankService bankService = new BankServiceImpl();
    private final BankAtmService bankAtmService = new BankAtmServiceImpl();
    private final BankOfficeService bankOfficeService = new BankOfficeServiceImpl();
    private final CreditAccountService creditAccountService = new CreditAccountServiceImpl();
    private final EmployeeService employeeService = new EmployeeServiceImpl();
    private final PaymentAccountService paymentAccountService = new PaymentAccountServiceImpl();
    private final UserService userService = new UserServiceImpl();
    private final Random random = new Random();
    private final String[] firstNames = {"Igor", "Alexander", "Artem", "Mikhail"};
    private final String[] middleNames = {"Igorevich", "Alexandrovich", "Artemovich", "Mikhailovich"};
    private final String[] lastNames = {"Pervov", "Vtorov", "Tretyev", "Chetvertov"};
    private final String[] placesOfWork = {"SberBank", "Alfa-Bank", "VTB Bank", "Tinkoff Bank"};
    private final String[] positions = {"Manager", "Developer", "Boss", "Engineer"};

    public Bank generateBank() {
        return bankService.createBank(
                ++idCounter,
                "Bank " + UUID.randomUUID().toString().substring(0, 2)
        );
    }

    public BankOffice generateBankOffice(Bank bank) {
        return bankOfficeService.createBankOffice(
                ++idCounter,
                bank.getName() + " office " + ++idCounter,
                "Bankirskaya, " + ++idCounter,
                (double) idCounter * 10,
                (double) idCounter * 5,
                true,
                true,
                true,
                true,
                true,
                bank
        );
    }

    public Employee generateEmployee(BankOffice bankOffice) {
        return employeeService.createEmployee(
                ++idCounter,
                getGeneratedFullName(),
                LocalDate.now(),
                positions[random.nextInt(4)],
                true,
                true,
                (double) idCounter * 10,
                bankOffice
        );
    }

    public BankAtm generateBankAtm(Employee employee) {
        return bankAtmService.createBankAtm(
                ++idCounter,
                employee.getBankOffice().getBank().getName() + " ATM #" + ++idCounter,
                employee.getBankOffice().getAddress(),
                "Working",
                (double) 0,
                (double) idCounter * 5,
                true,
                true,
                employee
        );
    }

    public User generateUser() {
        return userService.createUser(
                ++idCounter,
                getGeneratedFullName(),
                LocalDate.now(),
                placesOfWork[random.nextInt(4)]
        );
    }

    public PaymentAccount generatePaymentAccount(User user, Bank bank) {
        return paymentAccountService.createPaymentAccount(
                ++idCounter,
                user,
                bank
        );
    }

    public CreditAccount generateCreditAccount(User user, Employee employee, PaymentAccount paymentAccount) {
        return creditAccountService.createCreditAccount(
                ++idCounter,
                LocalDate.now(),
                LocalDate.now(),
                (int) idCounter * 2,
                (double) idCounter * 10,
                (double) idCounter * 5,
                user,
                employee,
                paymentAccount
        );
    }

    private String getGeneratedFullName() {
        return lastNames[random.nextInt(lastNames.length)] + " " +
                firstNames[random.nextInt(firstNames.length)] + " " +
                middleNames[random.nextInt(middleNames.length)];
    }
}
