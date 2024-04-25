package tech.reliab.course.zaiko.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "banks")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private Integer rating;

    private Double totalMoney;

    private Double interestRate;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<BankOffice> offices;

    @OneToMany(mappedBy = "bank", cascade = CascadeType.ALL)
    private List<PaymentAccount> paymentAccounts;

}