package SPB.SPB01.repository;

import SPB.SPB01.entity.PersonEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<PersonEntity, Long> {
    List<PersonEntity> findByAgeOrEmailContaining(Optional<Integer> age, Optional<String> email);
    List<PersonEntity> findByAgeAndEmailContaining(Optional<Integer> age, Optional<String> email);

    Page<PersonEntity> findByAgeOrEmailContaining(Optional<Integer> age, Optional<String> email, Pageable pageable);
    Page<PersonEntity> findByAgeAndEmailContaining(Optional<Integer> age, Optional<String> email,Pageable pageable);
}
