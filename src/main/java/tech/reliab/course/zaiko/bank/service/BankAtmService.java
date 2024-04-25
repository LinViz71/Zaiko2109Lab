package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.BankAtmRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankAtmResponseDto;

import java.util.List;

public interface BankAtmService {

    void create(BankAtmRequestDto bankAtmRequestDto,
                Long servingEmployeeId);

    BankAtmResponseDto getById(Long id);

    List<BankAtmResponseDto> getAllByServingEmployeeId(Long servingEmployeeId);

    void update(BankAtmResponseDto bankAtmResponseDto,
                Long servingEmployeeId);

    void deleteById(Long id);
}
