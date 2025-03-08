package SPB.SPB01.dto;

import SPB.SPB01.entity.PersonEntity;
import SPB.SPB01.model.Person;
import jakarta.validation.constraints.*;
import jdk.jfr.Frequency;
import lombok.*;

import java.time.LocalDate;

@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class PersonRequest {

    @NotNull(message = "Name is required") @Size(min = 2,max = 50, message = "invalid name format")
    protected String name;
    @Min(value = 18, message = "Age must be at least 18")
    @Max(value = 100, message = "Age must be less than 100")
    protected Integer age;

    @Email(message = "Invalid email format")
    protected String email;
    @Future
    protected LocalDate appointmentDate;


}
