package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.CreditAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.CreditAccountResponseDto;

import java.util.List;

public interface CreditAccountService {

    void create(CreditAccountRequestDto creditAccountRequestDto,
                Long payAccId);

    CreditAccountResponseDto getById(Long id);

    List<CreditAccountResponseDto> getAllByPayAccId(Long payAccId);

    void update(CreditAccountResponseDto bankAtmResponseDto);

    void deleteById(Long id);
}
