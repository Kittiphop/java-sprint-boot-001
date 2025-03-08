package SPB.SPB01.entity;

import SPB.SPB01.model.Person;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bank_accounts")
public class BankAccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;
    @Column
    protected String accountNumber;
    @Column
    protected String bankName;
    @Column
    protected Double balance;

    @ManyToOne
    @JoinColumn(name = "person_id")
    protected PersonEntity person;

}
