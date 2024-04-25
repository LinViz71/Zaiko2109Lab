package tech.reliab.course.zaiko.bank.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAtmRequestDto {

    private String name;

    private String address;

    private String status;

    private Double totalMoney;

    private Double maintenanceCost;

    private Boolean canDispenseMoney;

    private Boolean canAcceptMoney;

}
