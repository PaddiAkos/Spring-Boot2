package hu.akos.demo.service.impl;

import com.querydsl.core.types.dsl.BooleanExpression;
import hu.akos.demo.dto.PersonDTO;
import hu.akos.demo.dto.PersonResponseDTO;
import hu.akos.demo.exception.EntityNotFoundException;
import hu.akos.demo.mapper.PersonMapper;
import hu.akos.demo.model.Person;
import hu.akos.demo.repository.PersonRepository;
import hu.akos.demo.service.PersonService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.IterableUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Transactional
@Slf4j
public class PersonServiceImpl implements PersonService
{
//    @Autowired
//

//    @Autowired
//    public void setPersonRepository(PersonRepository personRepository)
//    {
//        this.personRepository = personRepository;
//    }

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;


    public PersonServiceImpl(PersonRepository personRepository, PersonMapper personMapper)
    {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }

    @Override
    public PersonResponseDTO findDTOById(Long personId)
    {
        log.trace("Find person DTO by id {}", personId);
        Person person = findById(personId);
        return personMapper.toPersonResponseDTO(person);
    }

    @Override
    public Person findById(Long personId)
    {
        log.trace("Find person by id {}", personId);
        return personRepository.findById(personId)
                .orElseThrow(() -> new EntityNotFoundException(Person.class, Map.of("personId", personId.toString())));
    }

    @Override
    public List<PersonResponseDTO> findAllDTO()
    {
        log.trace("Find all person DTO");
        List<Person> personList = personRepository.findAll();
        return personList.stream()
                .map(personMapper::toPersonResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void createPerson(PersonDTO personDTO)
    {
        log.trace("Create person {}", personDTO);
        Person person = personMapper.toEntity(personDTO);
        personRepository.save(person);
    }

    @Override
    public void deletePerson(Long personId)
    {
        log.trace("Delete person with id {}", personId);
        personRepository.deleteById(personId);
        ;
    }

    @Override
    public void updatePerson(PersonDTO personDTO, Long personId)
    {
        log.trace("Update person with id {}", personId);
        Person person = findById(personId);
        personMapper.enrichEntity(person, personDTO);
        personRepository.save(person);
    }

  

}
