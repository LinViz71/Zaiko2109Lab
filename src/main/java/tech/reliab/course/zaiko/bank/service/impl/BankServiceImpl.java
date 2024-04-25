package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.BankRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.Bank;
import tech.reliab.course.zaiko.bank.repository.BankRepository;
import tech.reliab.course.zaiko.bank.service.BankService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BankServiceImpl implements BankService {

    private static final Random random = new Random();
    private final BankRepository bankRepository;
    private final MappingUtils mappingUtils;

    @Override
    @Transactional
    public void create(BankRequestDto bankRequestDto) {
        Bank bank = mappingUtils.mapToBankEntity(bankRequestDto);
        bank.setRating(random.nextInt(101));
        bank.setTotalMoney(Math.round(random.nextDouble(1_000_000) * 100.0) / 100.0);
        bank.setInterestRate(Math.round((20 - bank.getRating() * 0.2) * 100.0) / 100.0);
        bankRepository.save(bank);
    }

    @Override
    public BankResponseDto getById(Long id) {
        return mappingUtils.mapToBankResponseDto(
                bankRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(Bank.class, id))
        );
    }

    @Override
    public List<BankResponseDto> getAll() {
        return bankRepository.findAll()
                .stream()
                .map(mappingUtils::mapToBankResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public void update(BankResponseDto bankResponseDto) {
        Bank bank = mappingUtils.mapToBankEntity(bankResponseDto);
        bankRepository.save(bank);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!bankRepository.existsById(id)) {
            throw new CustomNotFoundException(Bank.class, id);
        }
        bankRepository.deleteById(id);
    }
}
