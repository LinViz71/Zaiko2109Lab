package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankResponseDto;

import java.util.List;

public interface BankService {

    void create(BankRequestDto bankRequestDto);

    BankResponseDto getById(Long id);

    List<BankResponseDto> getAll();

    void update(BankResponseDto bankResponseDto);

    void deleteById(Long id);
}
