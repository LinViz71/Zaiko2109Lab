package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class BankAtm {

    private Long id;
    private String name;
    private String address;
    private String status;
    private Double totalMoney;
    private Double maintenanceCost;
    private Boolean canDispenseMoney;
    private Boolean canAcceptMoney;
    private BankOffice bankOffice;
    private Employee servingEmployee;

    @Override
    public String toString() {
        return """
                    name: %s,
                    address: %s,
                    status: %s,
                    totalMoney: %.2f,
                    maintenanceCost: %.2f,
                    canDispenseMoney: %b,
                    canAcceptMoney: %b,
                    bankOffice: %s,
                    servingEmployee: %s
                """.formatted(
                name,
                address,
                status,
                totalMoney,
                maintenanceCost,
                canDispenseMoney,
                canAcceptMoney,
                bankOffice.getName(),
                servingEmployee.getFullName());
    }
}