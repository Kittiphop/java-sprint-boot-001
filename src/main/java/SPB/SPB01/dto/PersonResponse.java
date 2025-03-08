package SPB.SPB01.dto;

import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor

public class PersonResponse {
    @JsonView(Views.List.class)
    protected Long id;
    @JsonView(Views.List.class)
    protected String name;
    protected Integer age;
    protected String email;
    protected LocalDate appointmentDate;

}
