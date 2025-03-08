package SPB.SPB01.repository;

import SPB.SPB01.entity.BankAccountEntity;
import SPB.SPB01.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccountEntity, Long> {
}
