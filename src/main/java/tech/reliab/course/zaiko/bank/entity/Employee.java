package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class Employee {

    private Long id;
    private String fullName;
    private LocalDate dateOfBirth;
    private String position;
    private Bank bank;
    private Boolean isRemote;
    private BankOffice bankOffice;
    private Boolean canIssueCredit;
    private Double salary;

    @Override
    public String toString() {
        return "Employee {" +
                "\nid=" + id +
                ", \nfullName='" + fullName + '\'' +
                ", \ndateOfBirth=" + dateOfBirth.format(DateTimeFormatter.ofPattern("dd.MM.yyyy")) +
                ", \nposition='" + position + '\'' +
                ", \nbank's id=" + bank.getId() +
                ", \nisRemote=" + isRemote +
                ", \nbankOffice's id=" + bankOffice.getId() +
                ", \ncanIssueCredit=" + canIssueCredit +
                ", \nsalary=" + salary +
                "\n}";
    }
}