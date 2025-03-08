package SPB.SPB01.service.PersonImpl;

import SPB.SPB01.model.Person;
import SPB.SPB01.service.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@Service("PersonServiceMem")
public class PersonServiceMemImpl implements PersonService {

    protected HashMap<Long,Person> mapPerson = new HashMap<>();

    public Long createPerson(Person req){
        mapPerson.put(req.getId(), req);
        return req.getId();
    }

    public List<Person> listPerson(Optional<Integer> age, Optional<String> email, Integer page, Integer size){
        List<Person> listPerson = new ArrayList<>(mapPerson.values());
        return listPerson;
    }

    public Person getPerson(Long id){
        Person person = mapPerson.get(id);
        return person;
    }

    public void updatePerson(Person req){
        mapPerson.replace(req.getId(), req);
    }

    public void deletePerson(Long id){
        mapPerson.remove(id);
    }
}
