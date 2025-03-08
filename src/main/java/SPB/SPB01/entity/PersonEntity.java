package SPB.SPB01.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "persons")
public class PersonEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    protected String name;
    @Column
    protected Integer age;
    @Column
    protected String email;
    @Column
    protected LocalDate appointmentDate;

    @OneToMany(mappedBy = "person", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
//    @Builder.Default
    protected List<BankAccountEntity> bankAccounts = new ArrayList<>();

}
