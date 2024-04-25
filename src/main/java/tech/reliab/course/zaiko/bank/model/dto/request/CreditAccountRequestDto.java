package tech.reliab.course.zaiko.bank.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CreditAccountRequestDto {

    private LocalDate startDate;

    private LocalDate endDate;

    private Double creditSum;

    private Long bankId;
}
