package net.pvytykac.cvns.service;

import net.pvytykac.cvns.endpoints.person.dto.CreatePersonDto;
import net.pvytykac.cvns.endpoints.person.dto.PersonDto;
import net.pvytykac.cvns.endpoints.person.dto.UpdatePersonDto;

import java.util.List;
import java.util.Optional;

/**
 * @author Paly
 * @since 2017-11-25
 */
public interface PersonService {

    Optional<PersonDto> getPerson(String uuid);

    List<PersonDto> listUsers();

    PersonDto savePerson(CreatePersonDto person);

    PersonDto updatePerson(String uuid, UpdatePersonDto update);

}
