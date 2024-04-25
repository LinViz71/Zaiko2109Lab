package tech.reliab.course.zaiko.bank.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountResponseDto {

    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double creditSum;

    private Double monthlyPayment;

    private Double interestRate;

    private String providedEmployeeName;
}
