package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.EmployeeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.EmployeeResponseDto;

import java.util.List;

public interface EmployeeService {

    void create(EmployeeRequestDto employeeRequestDto,
                Long bankOfficeId);

    EmployeeResponseDto getById(Long id);

    List<EmployeeResponseDto> getAllByBankOfficeId(Long bankOfficeId);

    void update(EmployeeResponseDto employeeResponseDto, Long bankOfficeId);

    void deleteById(Long id);

}
