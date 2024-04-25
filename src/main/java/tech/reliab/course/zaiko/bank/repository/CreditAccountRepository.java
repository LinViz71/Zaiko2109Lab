package tech.reliab.course.zaiko.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.zaiko.bank.model.entity.CreditAccount;

import java.util.List;

@Repository
public interface CreditAccountRepository extends JpaRepository<CreditAccount, Long> {

    List<CreditAccount> findAllByPaymentAccount_Id(Long payAccId);

}
