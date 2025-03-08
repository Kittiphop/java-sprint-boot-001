package SPB.SPB01.controller;

import SPB.SPB01.dto.BankAccountRequest;
import SPB.SPB01.dto.BankAccountRequest;
import SPB.SPB01.model.BankAccount;
import SPB.SPB01.model.BankAccount;
import SPB.SPB01.model.Person;
import SPB.SPB01.service.BankAccountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bankAccounts")
public class BankAccountController {
    private final BankAccountService bankAccountService;

    @Autowired
    public BankAccountController(@Qualifier("BankAccountService") BankAccountService bankAccountService) {
        this.bankAccountService = bankAccountService;
    }

    private BankAccount convertToModel(BankAccountRequest reqBankAccount) {
        return BankAccount.builder()
                .accountNumber(reqBankAccount.getAccountNumber())
                .bankName(reqBankAccount.getBankName())
                .balance(reqBankAccount.getBalance())
                .personId(reqBankAccount.getPersonId())
                .build();
    }

    @PostMapping
    public ResponseEntity<String> createBankAccount(@Valid @RequestBody BankAccountRequest reqBankAccount){
        BankAccount bankAccount = convertToModel(reqBankAccount);

        bankAccountService.createBankAccount(bankAccount);
        return ResponseEntity.ok("Created");
    }
}
