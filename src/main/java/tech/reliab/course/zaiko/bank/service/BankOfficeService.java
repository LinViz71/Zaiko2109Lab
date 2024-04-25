package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.BankOfficeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankOfficeResponseDto;

import java.util.List;

public interface BankOfficeService {

    void create(BankOfficeRequestDto bankOfficeRequestDto,
                Long bankId);

    BankOfficeResponseDto getById(Long id);

    List<BankOfficeResponseDto> getAllByBankId(Long bankId);

    void update(BankOfficeResponseDto bankOfficeResponseDto, Long bankId);

    void deleteById(Long id);
}
