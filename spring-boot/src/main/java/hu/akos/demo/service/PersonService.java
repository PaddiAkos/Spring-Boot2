package hu.akos.demo.service;

import hu.akos.demo.dto.PersonDTO;
import hu.akos.demo.dto.PersonResponseDTO;
import hu.akos.demo.model.Person;

import java.time.LocalDate;
import java.util.List;

public interface PersonService
{
    PersonResponseDTO findDTOById(Long personId);
    Person findById(Long personId);
    List<PersonResponseDTO> findAllDTO();
    void createPerson(PersonDTO personDTO);
    void deletePerson(Long personId);
    void updatePerson(PersonDTO personDTO, Long personId);

}
