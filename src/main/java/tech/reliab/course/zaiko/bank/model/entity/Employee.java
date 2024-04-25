package tech.reliab.course.zaiko.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private LocalDate dateOfBirth;

    private String position;

    private Double salary;

    private Boolean isRemote;

    private Boolean canIssueCredit;

    @ManyToOne
    @JoinColumn(name = "bank_office_id")
    private BankOffice bankOffice;

    @OneToMany(mappedBy = "servingEmployee", cascade = CascadeType.ALL)
    private List<BankAtm> servedAtms;

    @OneToMany(mappedBy = "providedEmployee", cascade = CascadeType.ALL)
    private List<CreditAccount> providedCreditAccounts;
}