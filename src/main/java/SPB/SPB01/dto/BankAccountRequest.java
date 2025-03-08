package SPB.SPB01.dto;

import jakarta.validation.constraints.*;
import lombok.*;


@Builder
@EqualsAndHashCode
@Data
@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccountRequest {

    @NotNull(message = "Person id is required")
    protected Long personId;
    @NotNull(message = "AccountNumber is required")
    protected String accountNumber;
    @NotNull(message = "BankName is required")
    protected String bankName;
    @NotNull(message = "Balance is required")
    protected Double balance;


}
