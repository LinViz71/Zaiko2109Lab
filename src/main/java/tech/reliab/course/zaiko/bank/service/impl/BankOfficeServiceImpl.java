package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.BankOfficeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankOfficeResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.Bank;
import tech.reliab.course.zaiko.bank.model.entity.BankOffice;
import tech.reliab.course.zaiko.bank.repository.BankOfficeRepository;
import tech.reliab.course.zaiko.bank.repository.BankRepository;
import tech.reliab.course.zaiko.bank.service.BankOfficeService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BankOfficeServiceImpl implements BankOfficeService {

    private final BankRepository bankRepository;
    private final BankOfficeRepository bankOfficeRepository;
    private final MappingUtils mappingUtils;

    @Override
    @Transactional
    public void create(BankOfficeRequestDto bankOfficeRequestDto,
                       Long bankId) {
        BankOffice bankOffice = mappingUtils.mapToBankOfficeEntity(bankOfficeRequestDto);
        bankOffice.setBank(bankRepository
                .findById(bankId)
                .orElseThrow(() -> new CustomNotFoundException(Bank.class, bankId)));
        bankOfficeRepository.save(bankOffice);
    }

    @Override
    public BankOfficeResponseDto getById(Long id) {
        return mappingUtils.
                mapToBankOfficeResponseDto(bankOfficeRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(BankOffice.class, id)));
    }

    @Override
    public List<BankOfficeResponseDto> getAllByBankId(Long bankId) {
        if (!bankRepository.existsById(bankId)) {
            throw new CustomNotFoundException(Bank.class, bankId);
        }
        return bankOfficeRepository
                .findAllByBank_Id(bankId)
                .stream()
                .map(mappingUtils::mapToBankOfficeResponseDto)
                .toList();
    }

    @Override
    @Transactional
    public void update(BankOfficeResponseDto bankOfficeResponseDto, Long bankId) {
        BankOffice bankOffice = mappingUtils.mapToBankOfficeEntity(bankOfficeResponseDto);
        bankOffice.setBank(bankRepository
                .findById(bankId)
                .orElseThrow(() -> new CustomNotFoundException(Bank.class, bankId)));
        bankOfficeRepository.save(bankOffice);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        if (!bankOfficeRepository.existsById(id)) {
            throw new CustomNotFoundException(Bank.class, id);
        }
        bankOfficeRepository.deleteById(id);
    }
}
