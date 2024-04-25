package tech.reliab.course.zaiko.bank.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PaymentAccount {

    private Long id;
    private Double balance;
    private User user;
    private Bank bank;

    @Override
    public String toString() {
        return """
                    № %d,
                    balance: %.2f,
                    user: %s,
                    bank: %s
                """.formatted(
                id,
                balance,
                user.getFullName(),
                bank.getName()
        );
    }
}