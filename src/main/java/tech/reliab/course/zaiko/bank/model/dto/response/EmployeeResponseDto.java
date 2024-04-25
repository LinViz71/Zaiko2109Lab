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
public class EmployeeResponseDto {

    private Long id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String position;

    private Double salary;

    private Boolean isRemote;

    private Boolean canIssueCredit;
}
