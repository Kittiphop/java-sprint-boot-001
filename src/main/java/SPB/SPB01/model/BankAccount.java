package SPB.SPB01.model;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@RequiredArgsConstructor
public class BankAccount {
    protected Long id;
    protected String accountNumber;
    protected String bankName;
    protected Double balance;
    protected Long personId;
}
