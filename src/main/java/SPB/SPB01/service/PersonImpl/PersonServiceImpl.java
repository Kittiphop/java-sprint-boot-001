package SPB.SPB01.service.PersonImpl;

import SPB.SPB01.entity.BankAccountEntity;
import SPB.SPB01.entity.PersonEntity;
import SPB.SPB01.exception.UserNotFoundException;
import SPB.SPB01.model.BankAccount;
import SPB.SPB01.model.Person;
import SPB.SPB01.repository.PersonRepository;
import SPB.SPB01.service.PersonService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

//@Primary
@Service("PersonService")
public class PersonServiceImpl implements PersonService {

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    private BankAccount convertToBackAccountDto (BankAccountEntity bankAccountEntity){
        return BankAccount.builder()
                .id(bankAccountEntity.getId())
                .accountNumber(bankAccountEntity.getAccountNumber())
                .bankName(bankAccountEntity.getBankName())
                .balance(bankAccountEntity.getBalance())
                .build();
    }

    private PersonEntity convertToEntity(Person person){

        return PersonEntity.builder()
                .id(person.getId())
                .name(person.getName())
                .age(person.getAge())
                .email(person.getEmail())
                .appointmentDate(person.getAppointmentDate())
                .build();
    }

    private Person convertToDto(PersonEntity personEntity){
        List<BankAccount> bankAccounts = personEntity.getBankAccounts()
                .stream()
                .map(this::convertToBackAccountDto)
                .collect(Collectors.toList());

        return Person.builder()
                .id(personEntity.getId())
                .name(personEntity.getName())
                .age(personEntity.getAge())
                .email(personEntity.getEmail())
                .appointmentDate(personEntity.getAppointmentDate())
                .build();
    }

    public Long createPerson(Person req) {
        PersonEntity personEntity = convertToEntity(req);
        return personRepository.save(personEntity).getId();
    }

    public List<Person> listPerson(Optional<Integer> age,
                                   Optional<String> email,
                                   Integer page,
                                   Integer size
    ) {
        Pageable pageable = PageRequest.of(page, size, Sort.by("id") .ascending());

        if (age.isPresent() && email.isPresent()) {
            Page<PersonEntity> listPerson = personRepository.findByAgeAndEmailContaining(age, email,pageable);
            return listPerson.stream()
                    .map(entity -> Person.builder()
                            .id(entity.getId())
                            .name(entity.getName())
                            .age(entity.getAge())
                            .email(entity.getEmail())
                            .appointmentDate(entity.getAppointmentDate())
                            .bankAccounts(entity.getBankAccounts())
                            .build())
                    .collect(Collectors.toList());
        }

        Page<PersonEntity> listPerson = personRepository.findByAgeOrEmailContaining(age, email,pageable);
        return listPerson.stream()
                .map(entity -> Person.builder()
                        .id(entity.getId())
                        .name(entity.getName())
                        .age(entity.getAge())
                        .email(entity.getEmail())
                        .appointmentDate(entity.getAppointmentDate())
                        .bankAccounts(entity.getBankAccounts())
                        .build())
                .collect(Collectors.toList());
    }

    public Person getPerson(Long id) {
        return personRepository.findById(id)
                .map(this::convertToDto)
                .orElseThrow(() -> new UserNotFoundException("Person with ID " + id + " not found"));
    }

    public void updatePerson(Person req) {
        PersonEntity personEntity = convertToEntity(req);
        if (personRepository.existsById(req.getId())){
            personRepository.save(personEntity);
        } else {
            throw new UserNotFoundException("Person with ID " + req.getId() + " not found");
        }

    }

    public void deletePerson(Long id) {
        if (personRepository.existsById(id)){
            personRepository.deleteById(id);
        } else {
            throw new UserNotFoundException("Person with ID " + id + " not found");
        }

    }
}
