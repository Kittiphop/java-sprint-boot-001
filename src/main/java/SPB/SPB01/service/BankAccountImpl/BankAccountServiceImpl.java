package SPB.SPB01.service.BankAccountImpl;

import SPB.SPB01.entity.BankAccountEntity;
import SPB.SPB01.entity.PersonEntity;
import SPB.SPB01.exception.UserNotFoundException;
import SPB.SPB01.model.BankAccount;
import SPB.SPB01.model.Person;
import SPB.SPB01.repository.BankAccountRepository;
import SPB.SPB01.repository.PersonRepository;
import SPB.SPB01.service.BankAccountService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service("BankAccountService")
public class BankAccountServiceImpl implements BankAccountService {

    private final BankAccountRepository bankAccountRepository;
    private final PersonRepository personRepository;

    public BankAccountServiceImpl(BankAccountRepository bankAccountRepository, PersonRepository personRepository) {
        this.bankAccountRepository = bankAccountRepository;
        this.personRepository = personRepository;
    }

    private BankAccountEntity convertToEntity(BankAccount bankAccount){
        return BankAccountEntity.builder()
                .id(bankAccount.getId())
                .accountNumber(bankAccount.getAccountNumber())
                .bankName(bankAccount.getBankName())
                .balance(bankAccount.getBalance())
                .build();
    }

    @Override
    public void createBankAccount(BankAccount req) {
        BankAccountEntity bankAccountEntity = convertToEntity(req);
        bankAccountRepository.save(bankAccountEntity);
    }
}
