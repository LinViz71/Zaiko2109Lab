package tech.reliab.course.zaiko.bank.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "bank_atms")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAtm {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private String status;

    private Double totalMoney;

    private Double maintenanceCost;

    private Boolean canDispenseMoney;

    private Boolean canAcceptMoney;

    @ManyToOne
    @JoinColumn(name = "serving_employee_id")
    private Employee servingEmployee;
}