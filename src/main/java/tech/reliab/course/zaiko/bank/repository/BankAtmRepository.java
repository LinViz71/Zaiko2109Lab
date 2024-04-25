package tech.reliab.course.zaiko.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tech.reliab.course.zaiko.bank.model.entity.BankAtm;

import java.util.List;

@Repository
public interface BankAtmRepository extends JpaRepository<BankAtm, Long> {

    List<BankAtm> findAllByServingEmployee_Id(Long servingEmployeeId);
}
