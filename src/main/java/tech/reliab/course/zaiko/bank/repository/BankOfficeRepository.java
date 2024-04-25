package tech.reliab.course.zaiko.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.zaiko.bank.model.entity.BankOffice;

import java.util.List;

@Repository
public interface BankOfficeRepository extends JpaRepository<BankOffice, Long> {
    List<BankOffice> findAllByBank_Id(Long bankId);
}
