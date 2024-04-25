package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Getter
@Setter
@Builder
public class User {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String placeOfWork;
    private Double monthlyIncome;
    private Integer creditRating;
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String creditAccountsToString = stringBuilder
                .append(creditAccounts.stream()
                        .map(creditAccount -> "№" + creditAccount.getId())
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        stringBuilder = new StringBuilder();
        String paymentAccountsToString = stringBuilder
                .append(paymentAccounts.stream()
                        .map(paymentAccount -> "№" + paymentAccount.getId())
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        stringBuilder = new StringBuilder();
        String banksToString = stringBuilder
                .append(banks.stream()
                        .map(Bank::getName)
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        return """
                    fullName: %s,
                    dateOfBirth: %s,
                    placeOfWork: %s,
                    monthlyIncome: %.2f,
                    creditRating: %d,
                    banks: %s,
                    creditAccounts: %s,
                    paymentAccounts: %s
                """.formatted(
                fullName,
                dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                placeOfWork,
                monthlyIncome,
                creditRating,
                banksToString,
                creditAccountsToString,
                paymentAccountsToString
        );
    }
}