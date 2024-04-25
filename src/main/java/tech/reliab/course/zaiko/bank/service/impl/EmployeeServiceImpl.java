package tech.reliab.course.zaiko.bank.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tech.reliab.course.zaiko.bank.exception.CustomNotFoundException;
import tech.reliab.course.zaiko.bank.model.dto.request.EmployeeRequestDto;
import tech.reliab.course.zaiko.bank.model.dto.response.EmployeeResponseDto;
import tech.reliab.course.zaiko.bank.model.entity.BankOffice;
import tech.reliab.course.zaiko.bank.model.entity.Employee;
import tech.reliab.course.zaiko.bank.repository.BankOfficeRepository;
import tech.reliab.course.zaiko.bank.repository.EmployeeRepository;
import tech.reliab.course.zaiko.bank.service.EmployeeService;
import tech.reliab.course.zaiko.bank.utlis.MappingUtils;

import java.util.List;

@Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class EmployeeServiceImpl implements EmployeeService {


    private final BankOfficeRepository bankOfficeRepository;
    private final EmployeeRepository employeeRepository;
    private final MappingUtils mappingUtils;


    @Transactional
    @Override
    public void create(EmployeeRequestDto employeeRequestDto,
                       Long bankOfficeId) {
        Employee employee = mappingUtils.mapToEmployeeEntity(employeeRequestDto);
        employee.setBankOffice(bankOfficeRepository
                .findById(bankOfficeId)
                .orElseThrow(() -> new CustomNotFoundException(BankOffice.class, bankOfficeId)));
        employeeRepository.save(employee);
    }

    @Override
    public EmployeeResponseDto getById(Long id) {
        return mappingUtils.
                mapToEmployeeResponseDto(employeeRepository
                        .findById(id)
                        .orElseThrow(() -> new CustomNotFoundException(Employee.class, id))
                );
    }

    @Override
    public List<EmployeeResponseDto> getAllByBankOfficeId(Long bankOfficeId) {
        if (!bankOfficeRepository.existsById(bankOfficeId)) {
            throw new CustomNotFoundException(BankOffice.class, bankOfficeId);
        }
        return employeeRepository
                .findAllByBankOffice_Id(bankOfficeId)
                .stream()
                .map(mappingUtils::mapToEmployeeResponseDto)
                .toList();
    }

    @Transactional
    @Override
    public void update(EmployeeResponseDto employeeResponseDto, Long bankOfficeId) {
        Employee employee = mappingUtils.mapToEmployeeEntity(employeeResponseDto);
        employee.setBankOffice(
                bankOfficeRepository
                        .findById(bankOfficeId)
                        .orElseThrow(() -> new CustomNotFoundException(BankOffice.class, bankOfficeId)));
        employeeRepository.save(employee);
    }

    @Transactional
    @Override
    public void deleteById(Long id) {
        if (!employeeRepository.existsById(id)) {
            throw new CustomNotFoundException(Employee.class, id);
        }
        employeeRepository.deleteById(id);
    }
}
