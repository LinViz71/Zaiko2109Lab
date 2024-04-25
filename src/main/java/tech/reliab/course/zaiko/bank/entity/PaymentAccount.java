package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentAccount {

    private Long id;
    private User user;
    private String bankName;
    private Double balance;

    @Override
    public String toString() {
        return "PaymentAccount {" +
                "\nid=" + id +
                ", \nuser's id=" + user.getId() +
                ", \nbankName='" + bankName + '\'' +
                ", \nbalance=" + balance +
                "\n}";
    }
}