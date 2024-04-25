package tech.reliab.course.zaiko.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tech.reliab.course.zaiko.bank.model.entity.Bank;

@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {

    @Query("SELECT b.interestRate from Bank b WHERE b.id = ?1")
    Double getInterestRateById(Long id);
}
