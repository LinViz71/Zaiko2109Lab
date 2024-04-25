package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.PaymentAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.PaymentAccountResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.Bank;
import tech.reliab.course.zaiko.bank.model.entity.PaymentAccount;
import tech.reliab.course.zaiko.bank.model.entity.User;
import tech.reliab.course.zaiko.bank.repository.BankRepository;
import tech.reliab.course.zaiko.bank.repository.PaymentAccountRepository;
import tech.reliab.course.zaiko.bank.repository.UserRepository;
import tech.reliab.course.zaiko.bank.service.PaymentAccountService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class PaymentAccountServiceImpl implements PaymentAccountService {

    private final PaymentAccountRepository paymentAccountRepository;
    private final UserRepository userRepository;
    private final BankRepository bankRepository;
    private final MappingUtils mappingUtils;

    @Transactional
    @Override
    public void create(PaymentAccountRequestDto paymentAccountRequestDto, Long userId) {
        PaymentAccount paymentAccount = mappingUtils.mapToPaymentAccountEntity(paymentAccountRequestDto);
        Long bankId = paymentAccountRequestDto.getBankId();
        paymentAccount.setUser(userRepository
                .findById(userId)
                .orElseThrow(() -> new CustomNotFoundException(User.class, userId)));
        paymentAccount.setBank(bankRepository
                .findById(bankId)
                .orElseThrow(() -> new CustomNotFoundException(Bank.class, bankId)));
        paymentAccountRepository.save(paymentAccount);
    }

    @Override
    public PaymentAccountResponseDto getById(Long id) {
        return mappingUtils.mapToPaymentAccountResponseDto(
                paymentAccountRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(PaymentAccount.class, id))
        );
    }

    @Override
    public List<PaymentAccountResponseDto> getAllByUserId(Long userId) {
        return paymentAccountRepository
                .findAllByUser_Id(userId)
                .stream()
                .map(mappingUtils::mapToPaymentAccountResponseDto)
                .toList();
    }

    @Transactional
    @Override
    public void update(PaymentAccountResponseDto paymentAccountResponseDto, Long userId) {
        PaymentAccount paymentAccount = mappingUtils.mapToPaymentAccountEntity(paymentAccountResponseDto);
        Long bankId = paymentAccountResponseDto.getBankId();
        paymentAccount.setBank(bankRepository
                .findById(bankId)
                .orElseThrow(() -> new CustomNotFoundException(Bank.class, bankId)));
        paymentAccount.setUser(userRepository
                .findById(userId)
                .orElseThrow(() -> new CustomNotFoundException(User.class, userId)));
        paymentAccountRepository.save(paymentAccount);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!paymentAccountRepository.existsById(id)) {
            throw new CustomNotFoundException(PaymentAccount.class, id);
        }
        paymentAccountRepository.deleteById(id);
    }
}
