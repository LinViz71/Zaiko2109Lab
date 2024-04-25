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
    private List<Bank> banks;
    private List<CreditAccount> creditAccounts;
    private List<PaymentAccount> paymentAccounts;
    private Integer creditRating;

    @Override
    public String toString() {
        return "User {" +
                "\nid=" + id +
                ", \nfullName='" + fullName + '\'' +
                ", \ndateOfBirth=" + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nplaceOfWork='" + placeOfWork + '\'' +
                ", \nmonthlyIncome=" + monthlyIncome +
                ", \nbanks' ids=" + banks.stream().map(Bank::getId).toList() +
                ", \ncreditAccounts' ids=" + creditAccounts.stream().map(CreditAccount::getId).toList() +
                ", \npaymentAccounts' ids=" + paymentAccounts.stream().map(PaymentAccount::getId).toList() +
                ", \ncreditRating=" + creditRating +
                "\n}";
    }
}