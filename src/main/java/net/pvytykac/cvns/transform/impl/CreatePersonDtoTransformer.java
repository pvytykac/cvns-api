package net.pvytykac.cvns.transform.impl;

import net.pvytykac.cvns.endpoints.person.dto.CreatePersonDto;
import net.pvytykac.cvns.endpoints.person.dto.PersonDto;
import net.pvytykac.cvns.model.impl.PersonDbo;
import net.pvytykac.cvns.transform.Transformer;
import org.springframework.stereotype.Component;

/**
 * @author Paly
 * @since 2017-11-25
 */
@Component
public class CreatePersonDtoTransformer implements Transformer<CreatePersonDto, PersonDbo> {

    @Override
    public PersonDbo transform(CreatePersonDto dto) {
        PersonDbo dbo = new PersonDbo();
        dbo.setFirstname(dto.getFirstname());
        dbo.setLastname(dto.getLastname());
        dbo.setEmail(dto.getEmail());

        return dbo;
    }
}
