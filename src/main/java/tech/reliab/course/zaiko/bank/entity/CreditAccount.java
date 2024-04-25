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
    private User user;
    private String bankName;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer monthsOfCreditAmount;
    private Double creditSum;
    private Double monthlyPayment;
    private Double interestRate;
    private Employee providedEmployee;
    private PaymentAccount paymentAccount;

    @Override
    public String toString() {
        return "CreditAccount {" +
                "\nid=" + id +
                ", \nuser's id=" + user.getId() +
                ", \nbankName='" + bankName + '\'' +
                ", \nstartDate=" + startDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nendDate=" + endDate.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nmonthsOfCreditAmount=" + monthsOfCreditAmount +
                ", \ncreditSum=" + creditSum +
                ", \nmonthlyPayment=" + monthlyPayment +
                ", \ninterestRate=" + interestRate +
                ", \nprovidedEmployee's id=" + providedEmployee.getId() +
                ", \npaymentAccount's id=" + paymentAccount.getId() +
                "\n}";
    }
}