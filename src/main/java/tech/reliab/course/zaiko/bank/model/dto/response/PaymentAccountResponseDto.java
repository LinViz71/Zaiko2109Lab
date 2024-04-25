package tech.reliab.course.zaiko.bank.model.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccountResponseDto {

    private Long id;

    private Double balance;

    private Long bankId;
}
