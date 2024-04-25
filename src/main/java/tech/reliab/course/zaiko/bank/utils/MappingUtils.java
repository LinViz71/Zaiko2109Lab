package tech.reliab.course.zaiko.bank.utlis;

import org.springframework.stereotype.Service;
import tech.reliab.course.zaiko.bank.model.dto.request.*;
import tech.reliab.course.zaiko.bank.model.dto.response.*;
import tech.reliab.course.zaiko.bank.model.entity.*;

@Service
public class MappingUtils {

    public BankResponseDto mapToBankResponseDto(Bank bank) {
        return BankMapper.mapToBankResponseDto(bank);
    }

    public Bank mapToBankEntity(BankResponseDto bankResponseDto) {
        return BankMapper.mapToBankEntity(bankResponseDto);
    }

    public Bank mapToBankEntity(BankRequestDto bankRequestDto) {
        return BankMapper.mapToBankEntity(bankRequestDto);
    }

    public BankOfficeResponseDto mapToBankOfficeResponseDto(BankOffice bankOffice) {
        return BankOfficeMapper.mapToBankOfficeResponseDto(bankOffice);
    }

    public BankOffice mapToBankOfficeEntity(BankOfficeResponseDto bankOfficeResponseDto) {
        return BankOfficeMapper.mapToBankOfficeEntity(bankOfficeResponseDto);
    }

    public BankOffice mapToBankOfficeEntity(BankOfficeRequestDto bankOfficeRequestDto) {
        return BankOfficeMapper.mapToBankOfficeEntity(bankOfficeRequestDto);
    }

    public EmployeeResponseDto mapToEmployeeResponseDto(Employee employee) {
        return EmployeeMapper.mapToEmployeeResponseDto(employee);
    }

    public Employee mapToEmployeeEntity(EmployeeResponseDto employeeResponseDto) {
        return EmployeeMapper.mapToEmployeeEntity(employeeResponseDto);
    }

    public Employee mapToEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
        return EmployeeMapper.mapToEmployeeEntity(employeeRequestDto);
    }

    public BankAtmResponseDto mapToBankAtmResponseDto(BankAtm bankAtm) {
        return BankAtmMapper.mapToBankAtmResponseDto(bankAtm);
    }

    public BankAtm mapToBankAtmEntity(BankAtmResponseDto bankAtmResponseDto) {
        return BankAtmMapper.mapToBankAtmEntity(bankAtmResponseDto);
    }

    public BankAtm mapToBankAtmEntity(BankAtmRequestDto bankAtmRequestDto) {
        return BankAtmMapper.mapToBankAtmEntity(bankAtmRequestDto);
    }

    public UserResponseDto mapToUserResponseDto(User user) {
        return UserMapper.mapToUserResponseDto(user);
    }

    public User mapToUserEntity(UserResponseDto userResponseDto) {
        return UserMapper.mapToUserEntity(userResponseDto);
    }

    public User mapToUserEntity(UserRequestDto userRequestDto) {
        return UserMapper.mapToUserEntity(userRequestDto);
    }

    public PaymentAccountResponseDto mapToPaymentAccountResponseDto(PaymentAccount paymentAccount) {
        return PaymentAccountMapper.mapToPaymentAccountResponseDto(paymentAccount);
    }

    public PaymentAccount mapToPaymentAccountEntity(PaymentAccountResponseDto paymentAccountResponseDto) {
        return PaymentAccountMapper.mapToPaymentAccountEntity(paymentAccountResponseDto);
    }

    public PaymentAccount mapToPaymentAccountEntity(PaymentAccountRequestDto paymentAccountRequestDto) {
        return PaymentAccountMapper.mapToPaymentAccountEntity(paymentAccountRequestDto);
    }

    public CreditAccountResponseDto mapToCreditAccountResponseDto(CreditAccount creditAccount) {
        return CreditAccountMapper.mapToCreditAccountResponseDto(creditAccount);
    }

    public CreditAccount mapToCreditAccountEntity(CreditAccountResponseDto creditAccountResponseDto) {
        return CreditAccountMapper.mapToCreditAccountEntity(creditAccountResponseDto);
    }

    public CreditAccount mapToCreditAccountEntity(CreditAccountRequestDto creditAccountRequestDto) {
        return CreditAccountMapper.mapToCreditAccountEntity(creditAccountRequestDto);
    }

    private static class BankMapper {

        private static BankResponseDto mapToBankResponseDto(Bank bank) {
            return BankResponseDto.builder()
                    .id(bank.getId())
                    .interestRate(bank.getInterestRate())
                    .name(bank.getName())
                    .rating(bank.getRating())
                    .totalMoney(bank.getTotalMoney())
                    .build();
        }

        private static Bank mapToBankEntity(BankResponseDto bankResponseDto) {
            return Bank.builder()
                    .id(bankResponseDto.getId())
                    .interestRate(bankResponseDto.getInterestRate())
                    .name(bankResponseDto.getName())
                    .rating(bankResponseDto.getRating())
                    .totalMoney(bankResponseDto.getTotalMoney())
                    .build();
        }

        private static Bank mapToBankEntity(BankRequestDto bankRequestDto) {
            return Bank.builder()
                    .name(bankRequestDto.getName())
                    .build();
        }
    }


    private static class BankOfficeMapper {

        private static BankOfficeResponseDto mapToBankOfficeResponseDto(BankOffice bankOffice) {
            return BankOfficeResponseDto.builder()
                    .id(bankOffice.getId())
                    .name(bankOffice.getName())
                    .address(bankOffice.getAddress())
                    .totalMoney(bankOffice.getTotalMoney())
                    .rentCost(bankOffice.getRentCost())
                    .isWorking(bankOffice.getIsWorking())
                    .canPlaceAtm(bankOffice.getCanPlaceAtm())
                    .canIssueCredit(bankOffice.getCanIssueCredit())
                    .canDispenseMoney(bankOffice.getCanDispenseMoney())
                    .canAcceptMoney(bankOffice.getCanAcceptMoney())
                    .build();
        }

        private static BankOffice mapToBankOfficeEntity(BankOfficeResponseDto bankOfficeResponseDto) {
            return BankOffice.builder()
                    .id(bankOfficeResponseDto.getId())
                    .name(bankOfficeResponseDto.getName())
                    .address(bankOfficeResponseDto.getAddress())
                    .totalMoney(bankOfficeResponseDto.getTotalMoney())
                    .rentCost(bankOfficeResponseDto.getRentCost())
                    .isWorking(bankOfficeResponseDto.getIsWorking())
                    .canPlaceAtm(bankOfficeResponseDto.getCanPlaceAtm())
                    .canIssueCredit(bankOfficeResponseDto.getCanIssueCredit())
                    .canDispenseMoney(bankOfficeResponseDto.getCanDispenseMoney())
                    .canAcceptMoney(bankOfficeResponseDto.getCanAcceptMoney())
                    .build();
        }

        private static BankOffice mapToBankOfficeEntity(BankOfficeRequestDto bankOfficeRequestDto) {
            return BankOffice.builder()
                    .name(bankOfficeRequestDto.getName())
                    .address(bankOfficeRequestDto.getAddress())
                    .totalMoney(bankOfficeRequestDto.getTotalMoney())
                    .rentCost(bankOfficeRequestDto.getRentCost())
                    .isWorking(bankOfficeRequestDto.getIsWorking())
                    .canPlaceAtm(bankOfficeRequestDto.getCanPlaceAtm())
                    .canIssueCredit(bankOfficeRequestDto.getCanIssueCredit())
                    .canDispenseMoney(bankOfficeRequestDto.getCanDispenseMoney())
                    .canAcceptMoney(bankOfficeRequestDto.getCanAcceptMoney())
                    .build();
        }
    }


    private static class EmployeeMapper {

        private static EmployeeResponseDto mapToEmployeeResponseDto(Employee employee) {
            return EmployeeResponseDto.builder()
                    .id(employee.getId())
                    .fullName(employee.getFullName())
                    .dateOfBirth(employee.getDateOfBirth())
                    .position(employee.getPosition())
                    .salary(employee.getSalary())
                    .isRemote(employee.getIsRemote())
                    .canIssueCredit(employee.getCanIssueCredit())
                    .build();
        }

        private static Employee mapToEmployeeEntity(EmployeeResponseDto employeeResponseDto) {
            return Employee.builder()
                    .id(employeeResponseDto.getId())
                    .fullName(employeeResponseDto.getFullName())
                    .dateOfBirth(employeeResponseDto.getDateOfBirth())
                    .position(employeeResponseDto.getPosition())
                    .salary(employeeResponseDto.getSalary())
                    .isRemote(employeeResponseDto.getIsRemote())
                    .canIssueCredit(employeeResponseDto.getCanIssueCredit())
                    .build();
        }

        private static Employee mapToEmployeeEntity(EmployeeRequestDto employeeRequestDto) {
            return Employee.builder()
                    .fullName(employeeRequestDto.getFullName())
                    .dateOfBirth(employeeRequestDto.getDateOfBirth())
                    .position(employeeRequestDto.getPosition())
                    .salary(employeeRequestDto.getSalary())
                    .isRemote(employeeRequestDto.getIsRemote())
                    .canIssueCredit(employeeRequestDto.getCanIssueCredit())
                    .build();
        }
    }


    private static class BankAtmMapper {

        private static BankAtmResponseDto mapToBankAtmResponseDto(BankAtm bankAtm) {
            return BankAtmResponseDto.builder()
                    .id(bankAtm.getId())
                    .name(bankAtm.getName())
                    .address(bankAtm.getAddress())
                    .status(bankAtm.getStatus())
                    .totalMoney(bankAtm.getTotalMoney())
                    .maintenanceCost(bankAtm.getMaintenanceCost())
                    .canDispenseMoney(bankAtm.getCanDispenseMoney())
                    .canAcceptMoney(bankAtm.getCanAcceptMoney())
                    .build();
        }

        private static BankAtm mapToBankAtmEntity(BankAtmResponseDto bankAtmResponseDto) {
            return BankAtm.builder()
                    .id(bankAtmResponseDto.getId())
                    .name(bankAtmResponseDto.getName())
                    .address(bankAtmResponseDto.getAddress())
                    .status(bankAtmResponseDto.getStatus())
                    .totalMoney(bankAtmResponseDto.getTotalMoney())
                    .maintenanceCost(bankAtmResponseDto.getMaintenanceCost())
                    .canDispenseMoney(bankAtmResponseDto.getCanDispenseMoney())
                    .canAcceptMoney(bankAtmResponseDto.getCanAcceptMoney())
                    .build();
        }

        private static BankAtm mapToBankAtmEntity(BankAtmRequestDto bankAtmRequestDto) {
            return BankAtm.builder()
                    .name(bankAtmRequestDto.getName())
                    .address(bankAtmRequestDto.getAddress())
                    .status(bankAtmRequestDto.getStatus())
                    .totalMoney(bankAtmRequestDto.getTotalMoney())
                    .maintenanceCost(bankAtmRequestDto.getMaintenanceCost())
                    .canDispenseMoney(bankAtmRequestDto.getCanDispenseMoney())
                    .canAcceptMoney(bankAtmRequestDto.getCanAcceptMoney())
                    .build();
        }
    }


    private static class UserMapper {

        private static UserResponseDto mapToUserResponseDto(User user) {
            return UserResponseDto.builder()
                    .id(user.getId())
                    .fullName(user.getFullName())
                    .dateOfBirth(user.getDateOfBirth())
                    .placeOfWork(user.getPlaceOfWork())
                    .monthlyIncome(user.getMonthlyIncome())
                    .creditRating(user.getCreditRating())
                    .build();
        }

        private static User mapToUserEntity(UserResponseDto userResponseDto) {
            return User.builder()
                    .id(userResponseDto.getId())
                    .fullName(userResponseDto.getFullName())
                    .dateOfBirth(userResponseDto.getDateOfBirth())
                    .placeOfWork(userResponseDto.getPlaceOfWork())
                    .monthlyIncome(userResponseDto.getMonthlyIncome())
                    .creditRating(userResponseDto.getCreditRating())
                    .build();
        }

        private static User mapToUserEntity(UserRequestDto userRequestDto) {
            return User.builder()
                    .fullName(userRequestDto.getFullName())
                    .dateOfBirth(userRequestDto.getDateOfBirth())
                    .placeOfWork(userRequestDto.getPlaceOfWork())
                    .build();
        }
    }


    private static class PaymentAccountMapper {

        private static PaymentAccountResponseDto mapToPaymentAccountResponseDto(PaymentAccount paymentAccount) {
            return PaymentAccountResponseDto.builder()
                    .id(paymentAccount.getId())
                    .balance(paymentAccount.getBalance())
                    .bankId(paymentAccount.getBank().getId())
                    .build();
        }

        private static PaymentAccount mapToPaymentAccountEntity(PaymentAccountResponseDto paymentAccountResponseDto) {
            return PaymentAccount.builder()
                    .id(paymentAccountResponseDto.getId())
                    .balance(paymentAccountResponseDto.getBalance())
                    .build();
        }

        private static PaymentAccount mapToPaymentAccountEntity(PaymentAccountRequestDto paymentAccountRequestDto) {
            return PaymentAccount.builder()
                    .balance(paymentAccountRequestDto.getBalance())
                    .build();
        }
    }


    private static class CreditAccountMapper {

        private static CreditAccountResponseDto mapToCreditAccountResponseDto(CreditAccount creditAccount) {
            return CreditAccountResponseDto.builder()
                    .id(creditAccount.getId())
                    .startDate(creditAccount.getStartDate())
                    .endDate(creditAccount.getEndDate())
                    .creditSum(creditAccount.getCreditSum())
                    .monthlyPayment(creditAccount.getMonthlyPayment())
                    .interestRate(creditAccount.getInterestRate())
                    .providedEmployeeName(creditAccount.getProvidedEmployee().getFullName())
                    .build();
        }

        private static CreditAccount mapToCreditAccountEntity(CreditAccountResponseDto creditAccountResponseDto) {
            return CreditAccount.builder()
                    .id(creditAccountResponseDto.getId())
                    .startDate(creditAccountResponseDto.getStartDate())
                    .endDate(creditAccountResponseDto.getEndDate())
                    .creditSum(creditAccountResponseDto.getCreditSum())
                    .monthlyPayment(creditAccountResponseDto.getMonthlyPayment())
                    .interestRate(creditAccountResponseDto.getInterestRate())
                    .build();
        }

        private static CreditAccount mapToCreditAccountEntity(CreditAccountRequestDto creditAccountRequestDto) {
            return CreditAccount.builder()
                    .startDate(creditAccountRequestDto.getStartDate())
                    .endDate(creditAccountRequestDto.getEndDate())
                    .creditSum(creditAccountRequestDto.getCreditSum())
                    .build();
        }
    }
}
