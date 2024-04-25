package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.CreditAccountRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.CreditAccountResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.*;
import tech.reliab.course.zaiko.bank.repository.BankOfficeRepository;
import tech.reliab.course.zaiko.bank.repository.BankRepository;
import tech.reliab.course.zaiko.bank.repository.CreditAccountRepository;
import tech.reliab.course.zaiko.bank.repository.PaymentAccountRepository;
import tech.reliab.course.zaiko.bank.service.CreditAccountService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CreditAccountServiceImpl implements CreditAccountService {

    private static final Random random = new Random();
    private final PaymentAccountRepository paymentAccountRepository;
    private final CreditAccountRepository creditAccountRepository;
    private final BankOfficeRepository bankOfficeRepository;
    private final BankRepository bankRepository;
    private final MappingUtils mappingUtils;


    @Transactional
    @Override
    public void create(CreditAccountRequestDto creditAccountRequestDto, Long payAccId) {
        CreditAccount creditAccount = mappingUtils.mapToCreditAccountEntity(creditAccountRequestDto);
        Long bankId = creditAccountRequestDto.getBankId();
        creditAccount.setProvidedEmployee(
                findRandomEmployeeByBankId(bankId)
                        .orElseThrow(() -> new CustomNotFoundException(Employee.class, null)));
        creditAccount.setPaymentAccount(paymentAccountRepository
                .findById(payAccId)
                .orElseThrow(() -> new CustomNotFoundException(PaymentAccount.class, payAccId)));
        creditAccount.setInterestRate(bankRepository.getInterestRateById(bankId));
        creditAccount.setMonthlyPayment(
                Math.round((
                        creditAccount.getCreditSum() * (1 + creditAccount.getInterestRate() / 100) /
                                ChronoUnit.MONTHS.between(
                                        creditAccount.getStartDate(),
                                        creditAccount.getEndDate())
                ) * 100) / 100.0
        );
        creditAccountRepository.save(creditAccount);
    }

    @Override
    public CreditAccountResponseDto getById(Long id) {
        return mappingUtils.mapToCreditAccountResponseDto(
                creditAccountRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(CreditAccount.class, id))
        );
    }

    @Override
    public List<CreditAccountResponseDto> getAllByPayAccId(Long payAccId) {
        if (!paymentAccountRepository.existsById(payAccId)) {
            throw new CustomNotFoundException(PaymentAccount.class, payAccId);
        }
        return creditAccountRepository
                .findAllByPaymentAccount_Id(payAccId)
                .stream()
                .map(mappingUtils::mapToCreditAccountResponseDto)
                .toList();
    }

    @Transactional
    @Override
    public void update(CreditAccountResponseDto creditAccountResponseDto) {
        CreditAccount creditAccountDb =
                creditAccountRepository
                        .findById(creditAccountResponseDto.getId())
                        .orElseThrow(() -> new CustomNotFoundException(CreditAccount.class, creditAccountResponseDto.getId()));
        CreditAccount creditAccount = mappingUtils.mapToCreditAccountEntity(creditAccountResponseDto);
        creditAccount.setMonthlyPayment(
                Math.round((
                        creditAccount.getCreditSum() * (1 + creditAccount.getInterestRate() / 100) /
                                ChronoUnit.MONTHS.between(
                                        creditAccount.getStartDate(),
                                        creditAccount.getEndDate())
                ) * 100) / 100.0
        );
        creditAccount.setProvidedEmployee(creditAccountDb.getProvidedEmployee());
        creditAccount.setPaymentAccount(creditAccountDb.getPaymentAccount());
        creditAccountRepository.save(creditAccount);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!creditAccountRepository.existsById(id)) {
            throw new CustomNotFoundException(User.class, id);
        }
        creditAccountRepository.deleteById(id);
    }

    private Optional<Employee> findRandomEmployeeByBankId(Long bankId) {
        List<BankOffice> bankOffices = bankOfficeRepository.findAllByBank_Id(bankId);
        BankOffice randomBankOffice = bankOffices.get(random.nextInt(bankOffices.size()));
        List<Employee> bankOfficeEmployees = randomBankOffice.getEmployees();
        if (bankOfficeEmployees.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(bankOfficeEmployees.get(random.nextInt(bankOfficeEmployees.size())));
    }
}
