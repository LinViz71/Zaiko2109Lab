package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Bank {

    private Long id;
    private String name;
    private Integer rating;
    private Double totalMoney;
    private Double interestRate;
    private List<BankOffice> offices;
    private List<User> users;
    private List<PaymentAccount> paymentAccounts;


    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String usersToString = stringBuilder
                .append(users.stream()
                        .map(user -> "\n\t" + user.getFullName())
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
        String bankOfficesToString = stringBuilder
                .append(offices.stream()
                        .map(BankOffice::getName)
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        return """
                    name: %s,
                    rating: %d,
                    totalMoney: %.2f,
                    interestRate: %.2f,
                    offices: %s,
                    users: %s,
                    paymentAccounts: %s
                """.formatted(
                name,
                rating,
                totalMoney,
                interestRate,
                bankOfficesToString,
                usersToString,
                paymentAccountsToString
        );
    }
}