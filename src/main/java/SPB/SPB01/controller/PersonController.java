package SPB.SPB01.controller;

import SPB.SPB01.dto.PersonRequest;
import SPB.SPB01.dto.PersonResponse;
import SPB.SPB01.dto.Views;
import SPB.SPB01.model.Person;
import SPB.SPB01.service.PersonService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(@Qualifier("PersonService") PersonService personService) {
        this.personService = personService;
    }

    private Person convertToModel(PersonRequest reqPerson) {
        return Person.builder()
                .name(reqPerson.getName())
                .age(reqPerson.getAge())
                .email(reqPerson.getEmail())
                .appointmentDate(reqPerson.getAppointmentDate())
                .build();
    }

    private PersonResponse convertToResponse(Person person) {
        return new PersonResponse(person.getId(),
                person.getName(),
                person.getAge(),
                person.getEmail(),
                person.getAppointmentDate());
    }

    @PostMapping
    public ResponseEntity<Long> createPerson(@Valid @RequestBody PersonRequest reqPerson){
        Person person = convertToModel(reqPerson);
        Long id = personService.createPerson(person);
        return ResponseEntity.ok(id);
    }

    @GetMapping
    @JsonView(Views.List.class)
    public ResponseEntity<List<PersonResponse>> listPerson(
            @RequestParam(required = false) Optional<Integer> age,
            @RequestParam(required = false) Optional<String> email,
            @RequestParam(required = false, defaultValue = "0") Integer page,
            @RequestParam(required = false, defaultValue = "5") Integer size
    ){

        return ResponseEntity.ok(personService.listPerson(age, email, page, size).stream()
                .map(this::convertToResponse)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PersonResponse> getPerson(@PathVariable Long id){
        Person person = personService.getPerson(id);
        PersonResponse res = convertToResponse(person);
        return ResponseEntity.ok(res);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable Long id, @RequestBody PersonRequest reqPerson){
        Person person = convertToModel(reqPerson);
        person.setId(id);
        personService.updatePerson(person);
        return ResponseEntity.ok("Updated");
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return ResponseEntity.ok("Deleted");
    }
}
