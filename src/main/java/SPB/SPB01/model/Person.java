package SPB.SPB01.model;

import SPB.SPB01.entity.BankAccountEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
//@RequiredArgsConstructor
public class Person {
    protected Long id;
    protected String name;
    protected Integer age;
    protected String email;
    protected LocalDate appointmentDate;

    protected List<BankAccountEntity> bankAccounts;


//    @ToString.Exclude @EqualsAndHashCode.Exclude @JsonIgnore
//    protected String password;

//    @EqualsAndHashCode.Exclude
//    final String abc;

}
