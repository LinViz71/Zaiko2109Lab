package tech.reliab.course.zaiko.bank;

import tech.reliab.course.zaiko.bank.entity.*;
import tech.reliab.course.zaiko.bank.utlis.EntitiesGenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Main {

    private static final EntitiesGenerator entitiesGenerator = new EntitiesGenerator();
    private static final List<Bank> bankList = new ArrayList<>();
    private static final List<User> userList = new ArrayList<>();
    private static final Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        generateEntities();
        String unexpectedValueMessage = "Unexpected value: ";
        while (true) {
            System.out.println("""
                    Input
                    1: Show users
                    2: Show banks
                    3: Exit
                    """);
            int inputNum = getInputInt();
            switch (inputNum) {
                case 1 -> {
                    for (int i = 0; i < userList.size(); i++) {
                        System.out.println(i + "\n" + userList.get(i).toString());
                    }
                    System.out.println("Input user's number to show his info: ");
                    User selectedUser = userList.get(getInputInt());
                    System.out.println("""
                            Select detail info:
                            1: Credit accounts list
                            2: Payment accounts list
                            3: Exit <-
                            """);
                    int inputInt = getInputInt();
                    switch (inputInt) {
                        case 1 -> selectedUser.getCreditAccounts().forEach(System.out::println);
                        case 2 -> selectedUser.getPaymentAccounts().forEach(System.out::println);
                        case 3 -> System.out.println();
                        default -> throw new IllegalStateException(unexpectedValueMessage + inputNum);

                    }
                }
                case 2 -> {
                    for (int i = 0; i < bankList.size(); i++) {
                        System.out.println(i + "\n" + bankList.get(i).toString());
                    }
                    System.out.println("Input bank's number to show info:");
                    Bank selectedBank = bankList.get(getInputInt());
                    System.out.println("""
                            Select detail info:
                            1: Offices list
                            2: Employees list
                            3: ATMs list
                            4: Exit <-
                            """);
                    int inputInt = getInputInt();
                    switch (inputInt) {
                        case 1 -> selectedBank.getOffices()
                                .forEach(System.out::println);
                        case 2 -> selectedBank.getOffices()
                                .forEach(bankOffice ->
                                        bankOffice.getEmployees()
                                                .forEach(System.out::println));
                        case 3 -> selectedBank.getOffices()
                                .forEach(bankOffice -> bankOffice.getBankAtms()
                                        .forEach(System.out::println));
                        case 4 -> System.out.println();
                        default -> throw new IllegalStateException(unexpectedValueMessage + inputNum);
                    }
                }
                case 3 -> {
                    return;
                }
                default -> throw new IllegalStateException(unexpectedValueMessage + inputNum);
            }
        }
    }

    private static void generateEntities() {
        for (int k = 0; k < 5; k++) {
            bankList.add(entitiesGenerator.generateBank());
        }

        for (Bank bank : bankList) {
            for (int k = 0; k < 3; k++) {
                entitiesGenerator.generateBankOffice(bank);
            }
        }

        for (Bank bank : bankList) {
            for (BankOffice bankOffice : bank.getOffices()) {
                for (int k = 0; k < 5; k++) {
                    entitiesGenerator.generateEmployee(bankOffice);
                }
            }
        }

        for (Bank bank : bankList) {
            for (int k = 0; k < 3; k++) {
                entitiesGenerator.generateBankAtm(getRandomEmployeeOfBank(bank));
            }
        }

        for (Bank bank : bankList) {
            for (int k = 0; k < 5; k++) {
                User user = entitiesGenerator.generateUser();
                userList.add(user);
                bank.getUsers().add(user);
                user.getBanks().add(bank);
                generateAccountsForUserOfBank(bank, user);
            }
        }
    }

    private static void generateAccountsForUserOfBank(Bank bank, User user) {
        for (int j = 0; j < 2; j++) {
            PaymentAccount paymentAccount = entitiesGenerator.generatePaymentAccount(user, bank);
            entitiesGenerator.generateCreditAccount(user, getRandomEmployeeOfBank(bank), paymentAccount);
        }
    }

    private static Employee getRandomEmployeeOfBank(Bank bank) {
        Random random = new Random();
        BankOffice randomOffice = bank.getOffices().get(random.nextInt(bank.getOffices().size()));
        return randomOffice.getEmployees().get(random.nextInt(randomOffice.getEmployees().size()));
    }

    private static int getInputInt() {
        return Integer.parseInt(scanner.nextLine());
    }
}
