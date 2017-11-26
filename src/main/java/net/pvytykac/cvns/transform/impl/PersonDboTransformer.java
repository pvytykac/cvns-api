package net.pvytykac.cvns.transform.impl;

import net.pvytykac.cvns.model.impl.PersonDbo;
import net.pvytykac.cvns.endpoints.person.dto.PersonDto;
import net.pvytykac.cvns.transform.Transformer;
import org.springframework.stereotype.Component;

/**
 * @author Paly
 * @since 2017-11-25
 */
@Component
public class PersonDboTransformer implements Transformer<PersonDbo, PersonDto> {

    @Override
    public PersonDto transform(PersonDbo dbo) {
        PersonDto dto = new PersonDto();
        dto.setId(dbo.getId());
        dto.setFirstname(dbo.getFirstname());
        dto.setLastname(dbo.getLastname());
        dto.setEmail(dbo.getEmail());

        return dto;
    }
}
