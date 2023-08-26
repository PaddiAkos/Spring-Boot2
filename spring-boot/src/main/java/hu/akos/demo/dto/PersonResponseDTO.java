package hu.akos.demo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.Instant;

@Data
@EqualsAndHashCode(callSuper = true)
public class PersonResponseDTO extends PersonDTO
{
    private String name;
    private Instant date;
    private Boolean active;
}
