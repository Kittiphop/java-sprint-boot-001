package SPB.SPB01.service;

import SPB.SPB01.model.Person;

import java.util.List;
import java.util.Optional;

public interface PersonService {

    Long createPerson(Person req);
    List<Person> listPerson(Optional<Integer> age,
                            Optional<String> email,
                            Integer page,
                            Integer size);
    Person getPerson(Long id);
    void  updatePerson(Person req);
    void deletePerson(Long id);

}
