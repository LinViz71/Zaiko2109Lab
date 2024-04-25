package tech.reliab.course.zaiko.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "credit_accounts")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreditAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate startDate;

    private LocalDate endDate;

    private Double creditSum;

    private Double monthlyPayment;

    private Double interestRate;

    @ManyToOne
    @JoinColumn(name = "provided_employee_id")
    private Employee providedEmployee;

    @ManyToOne
    @JoinColumn(name = "payment_account_id")
    private PaymentAccount paymentAccount;
}