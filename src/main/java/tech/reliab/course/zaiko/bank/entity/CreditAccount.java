package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class CreditAccount {

    private Long id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthsOfCreditAmount;
    private Double creditSum;
    private Double monthlyPayment;
    private Double interestRate;
    private User user;
    private Bank bank;
    private Employee providedEmployee;
    private PaymentAccount paymentAccount;

    @Override
    public String toString() {
        return """
                     № %d,
                     startDate: %s,
                     endDate: %s,
                     monthsOfCreditAmount: %d,
                     creditSum: %.2f,
                     monthlyPayment: %.2f,
                     interestRate: %.2f,
                     user: %s,
                     bank: %s,
                     providedEmployee: %s,
                     paymentAccount: %s
                """.formatted(
                id,
                startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                monthsOfCreditAmount,
                creditSum,
                monthlyPayment,
                interestRate,
                user.getFullName(),
                bank.getName(),
                providedEmployee.getFullName(),
                paymentAccount.getId()
        );
    }
}