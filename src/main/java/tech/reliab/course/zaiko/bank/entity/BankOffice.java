package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankOffice {

    private Long id;
    private String name;
    private String address;
    private Boolean isWorking;
    private Boolean canPlaceAtm;
    private Integer atmsAmount;
    private Boolean canIssueCredit;
    private Boolean canDispenseMoney;
    private Boolean canAcceptMoney;
    private Double totalMoney;
    private Double rentCost;

    @Override
    public String toString() {
        return "BankOffice {" +
                "\nid=" + id +
                ", \nname='" + name + '\'' +
                ", \naddress='" + address + '\'' +
                ", \nisWorking=" + isWorking +
                ", \ncanPlaceAtm=" + canPlaceAtm +
                ", \natmsAmount=" + atmsAmount +
                ", \ncanIssueCredit=" + canIssueCredit +
                ", \ncanDispenseMoney=" + canDispenseMoney +
                ", \ncanAcceptMoney=" + canAcceptMoney +
                ", \ntotalMoney=" + totalMoney +
                ", \nrentCost=" + rentCost +
                "\n}";
    }
}