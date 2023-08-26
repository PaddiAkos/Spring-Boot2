package hu.akos.demo.mapper.base;

import hu.akos.demo.model.Person;
import org.mapstruct.Mapper;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public abstract class PersonMapperBase
{
    @Named("toName")
    public String toName(Person person) {
        return String.format("%s %s", person.getFirstName(), person.getLastName());
    }
}
