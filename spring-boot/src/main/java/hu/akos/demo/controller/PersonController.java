package hu.akos.demo.controller;

import hu.akos.demo.dto.PersonDTO;
import hu.akos.demo.dto.PersonResponseDTO;
import hu.akos.demo.service.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/v1/person")
@RequiredArgsConstructor
public class PersonController
{
    private final PersonService personService;

    @GetMapping("/{personId}")
    public ResponseEntity<PersonResponseDTO> getPersonById(@PathVariable(name = "personId") Long personId) {
        return ResponseEntity.ok(personService.findDTOById(personId));
    }

    @GetMapping
    public ResponseEntity<List<PersonResponseDTO>> getAllPersons() {
        return ResponseEntity.ok(personService.findAllDTO());
    }

    @PostMapping
    public ResponseEntity<Void> createPerson(@RequestBody @Valid PersonDTO personDTO) {
        personService.createPerson(personDTO);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/{personId}")
    public ResponseEntity<Void> updatePerson(
            @RequestBody @Valid PersonDTO personDTO,
            @PathVariable(name = "personId") Long personId
    ) {
        personService.updatePerson(personDTO, personId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{personId}")
    public ResponseEntity<Void> deletePerson(@PathVariable(name = "personId") Long personId) {
        personService.deletePerson(personId);
        return ResponseEntity.ok().build();
    }

    }
