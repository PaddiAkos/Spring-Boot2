package hu.akos.demo.mapper;

import hu.akos.demo.dto.PersonDTO;
import hu.akos.demo.dto.PersonResponseDTO;
import hu.akos.demo.mapper.base.PersonMapperBase;
import hu.akos.demo.model.Person;
import org.mapstruct.InheritConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;

import java.time.Instant;

@Mapper(uses = {PersonMapperBase.class}, imports = {Instant.class})
public interface PersonMapper
{
    @Mappings({
            @Mapping(target = "personId", ignore = true)
    })
    Person toEntity(PersonDTO personDTO);

    @Mappings({})
    PersonDTO toDTO(Person person);

    @InheritConfiguration(name = "toDTO")
    @Mappings({
            @Mapping(target = "name", source = "person", qualifiedByName = "toName"),
            @Mapping(target = "active", constant = "true"),
            @Mapping(target = "date", expression = "java(Instant.now())"),
    })
    PersonResponseDTO toPersonResponseDTO(Person person);

    @Mappings({
            @Mapping(target = "personId", ignore = true)
    })
    void enrichEntity(@MappingTarget Person person, PersonDTO personDTO);
}
