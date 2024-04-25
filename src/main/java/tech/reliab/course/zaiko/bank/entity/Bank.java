package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Bank {

    private Long id;
    private String name;
    private Integer officesAmount;
    private Integer atmsAmount;
    private Integer employeesAmount;
    private Integer customersAmount;
    private Integer rating;
    private Double totalMoney;
    private Double interestRate;

    @Override
    public String toString() {
        return "Bank {" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \nofficesAmount=" + officesAmount +
                ", \natmsAmount=" + atmsAmount +
                ", \nemployeesAmount=" + employeesAmount +
                ", \ncustomersAmount=" + customersAmount +
                ", \nrating=" + rating +
                ", \ntotalMoney=" + totalMoney +
                ", \ninterestRate=" + interestRate +
                "\n}";
    }
}