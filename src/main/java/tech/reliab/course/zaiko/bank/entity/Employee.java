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
public class Employee {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String position;
    private Double salary;
    private Boolean isRemote;
    private Boolean canIssueCredit;
    private BankOffice bankOffice;
    private List<BankAtm> servedAtms;
    private List<CreditAccount> providedCreditAccounts;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String servedAtmsToString = stringBuilder
                .append(servedAtms.stream()
                        .map(BankAtm::getName)
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        stringBuilder = new StringBuilder();
        String providedCreditAccountsToString = stringBuilder
                .append(providedCreditAccounts.stream()
                        .map(creditAccount -> "№" + creditAccount.getId())
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        return """
                    fullName: %s,
                    dateOfBirth: %s,
                    position: %s,
                    salary: %.2f,
                    isRemote: %b,
                    canIssueCredit: %b,
                    bankOffice: %s,
                    servedAtms: %s,
                    providedCreditAccounts: %s
                """.formatted(
                fullName,
                dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")),
                position,
                salary,
                isRemote,
                canIssueCredit,
                bankOffice.getName(),
                servedAtmsToString,
                providedCreditAccountsToString
        );
    }


}