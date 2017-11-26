package net.pvytykac.cvns.service.impl;

import net.pvytykac.cvns.dao.PersonDao;
import net.pvytykac.cvns.endpoints.person.dto.CreatePersonDto;
import net.pvytykac.cvns.endpoints.person.dto.UpdatePersonDto;
import net.pvytykac.cvns.model.impl.PersonDbo;
import net.pvytykac.cvns.endpoints.person.dto.PersonDto;
import net.pvytykac.cvns.service.PersonService;
import net.pvytykac.cvns.transform.Transformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * @author Paly
 * @since 2017-11-25
 */
@Service
public class PersonServiceImpl implements PersonService {

    private final PersonDao dao;
    private final Transformer<PersonDbo, PersonDto> dboToDto;
    private final Transformer<CreatePersonDto, PersonDbo> createToDbo;


    @Autowired
    public PersonServiceImpl(PersonDao dao, Transformer<PersonDbo, PersonDto> dboToDto,
                             Transformer<CreatePersonDto, PersonDbo> createToDbo) {
        this.dao = dao;
        this.dboToDto = dboToDto;
        this.createToDbo = createToDbo;
    }

    @Override
    public Optional<PersonDto> getPerson(String uuid) {
        PersonDbo person = dao.findOne(uuid);
        return Optional.ofNullable(person).map(dboToDto::transform);
    }

    @Override
    public List<PersonDto> listUsers() {
        return dao.findAll()
                .stream()
                .map(dboToDto::transform)
                .collect(Collectors.toList());
    }

    @Override
    public PersonDto savePerson(CreatePersonDto person) {
        return dboToDto.transform(dao.save(createToDbo.transform(person)));
    }

    @Override
    public PersonDto updatePerson(String uuid, UpdatePersonDto update) {
        return null;
    }
}
