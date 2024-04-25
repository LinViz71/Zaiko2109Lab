package tech.reliab.course.zaiko.bank.service;

import tech.reliab.course.zaiko.bank.model.dto.request.PaymentAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.PaymentAccountResponseDto;

import java.util.List;

public interface PaymentAccountService {

    void create(PaymentAccountRequestDto paymentAccountRequestDto,
                Long userId);

    PaymentAccountResponseDto getById(Long id);

    List<PaymentAccountResponseDto> getAllByUserId(Long userId);

    void update(PaymentAccountResponseDto paymentAccountResponseDto,
                Long userId);

    void deleteById(Long id);
}
