package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.BankAtmRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.BankAtmResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.BankAtm;
import tech.reliab.course.zaiko.bank.model.entity.Employee;
import tech.reliab.course.zaiko.bank.repository.BankAtmRepository;
import tech.reliab.course.zaiko.bank.repository.EmployeeRepository;
import tech.reliab.course.zaiko.bank.service.BankAtmService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class BankAtmServiceImpl implements BankAtmService {

    private final EmployeeRepository employeeRepository;
    private final BankAtmRepository bankAtmRepository;
    private final MappingUtils mappingUtils;

    @Transactional
    @Override
    public void create(BankAtmRequestDto bankAtmRequestDto,
                       Long servingEmployeeId) {
        BankAtm bankAtm = mappingUtils.mapToBankAtmEntity(bankAtmRequestDto);
        bankAtm.setServingEmployee(employeeRepository
                .findById(servingEmployeeId)
                .orElseThrow(() -> new CustomNotFoundException(Employee.class, servingEmployeeId)));
        bankAtmRepository.save(bankAtm);
    }

    @Override
    public BankAtmResponseDto getById(Long id) {
        return mappingUtils
                .mapToBankAtmResponseDto(
                        bankAtmRepository
                                .findById(id)
                                .orElseThrow(() -> new CustomNotFoundException(BankAtm.class, id))
                );
    }


    @Override
    public List<BankAtmResponseDto> getAllByServingEmployeeId(Long servingEmployeeId) {
        if (!employeeRepository.existsById(servingEmployeeId)) {
            throw new CustomNotFoundException(Employee.class, servingEmployeeId);
        }
        return bankAtmRepository
                .findAllByServingEmployee_Id(servingEmployeeId)
                .stream()
                .map(mappingUtils::mapToBankAtmResponseDto)
                .toList();
    }

    @Transactional
    @Override
    public void update(BankAtmResponseDto bankAtmResponseDto,
                       Long servingEmployeeId) {
        BankAtm bankAtm = mappingUtils.mapToBankAtmEntity(bankAtmResponseDto);
        bankAtm.setServingEmployee(
                employeeRepository
                        .findById(servingEmployeeId)
                        .orElseThrow(() -> new CustomNotFoundException(Employee.class, servingEmployeeId))
        );
        bankAtmRepository.save(bankAtm);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!bankAtmRepository.existsById(id)) {
            throw new CustomNotFoundException(BankAtm.class, id);
        }
        bankAtmRepository.deleteById(id);
    }
}
