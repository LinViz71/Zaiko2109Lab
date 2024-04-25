package tech.reliab.course.zaiko.bank.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankResponseDto {

    private Long id;

    private String name;

    private Integer rating;

    private Double totalMoney;

    private Double interestRate;
}
