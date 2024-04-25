package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class BankOffice {

    private Long id;
    private String name;
    private String address;
    private Double totalMoney;
    private Double rentCost;
    private Boolean isWorking;
    private Boolean canPlaceAtm;
    private Boolean canIssueCredit;
    private Boolean canDispenseMoney;
    private Boolean canAcceptMoney;
    private List<BankAtm> bankAtms;
    private List<Employee> employees;
    private Bank bank;

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        String bankAtmsToString = stringBuilder
                .append(bankAtms.stream()
                        .map(BankAtm::getName)
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        stringBuilder = new StringBuilder();
        String employeesToString = stringBuilder
                .append(employees.stream()
                        .map(employee -> "\n\t" + employee.getFullName())
                        .toList()
                )
                .substring(1, stringBuilder.length() - 1);
        return """
                    name: %s,
                    address: %s,
                    totalMoney: %.2f,
                    rentCost: %.2f,
                    isWorking: %b,
                    canPlaceAtm: %b,
                    canIssueCredit: %b,
                    canDispenseMoney: %b,
                    canAcceptMoney: %b,
                    bankAtms: %s,
                    employees: %s,
                    bank: %s
                """.formatted(
                name,
                address,
                totalMoney,
                rentCost,
                isWorking,
                canPlaceAtm,
                canIssueCredit,
                canDispenseMoney,
                canAcceptMoney,
                bankAtmsToString,
                employeesToString,
                bank.getName()
        );
    }
}