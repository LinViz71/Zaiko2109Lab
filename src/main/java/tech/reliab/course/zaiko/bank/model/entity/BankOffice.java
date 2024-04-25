package tech.reliab.course.zaiko.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "bank_offices")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankOffice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Double totalMoney;

    private Double rentCost;

    private Boolean isWorking;

    private Boolean canPlaceAtm;

    private Boolean canIssueCredit;

    private Boolean canDispenseMoney;

    private Boolean canAcceptMoney;

    @OneToMany(mappedBy = "bankOffice", cascade = CascadeType.ALL)
    private List<Employee> employees;

    @ManyToOne
    @JoinColumn(name = "bank_id")
    private Bank bank;

}