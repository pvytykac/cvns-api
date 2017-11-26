package net.pvytykac.cvns.endpoints.person;

import net.pvytykac.cvns.endpoints.person.dto.CreatePersonDto;
import net.pvytykac.cvns.endpoints.person.dto.PersonDto;
import net.pvytykac.cvns.endpoints.person.dto.UpdatePersonDto;
import net.pvytykac.cvns.service.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Paly
 * @since 2017-11-25
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/person")
public class PersonResource {

    private static final Logger LOG = LoggerFactory.getLogger(PersonResource.class);

    private final PersonService ps;

    @Autowired
    public PersonResource(PersonService ps) {
        this.ps = ps;
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public PersonDto getPerson(@PathVariable("uuid") String uuid) {
        return ps.getPerson(uuid).orElse(null);
    }

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public List<PersonDto> getPersonList() {
        return ps.listUsers();
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
    public PersonDto createPerson(@Valid @RequestBody CreatePersonDto createRequest) {
        return ps.savePerson(createRequest);
    }

    @RequestMapping(value = "/{uuid}", method = RequestMethod.PATCH, produces = "application/json", consumes = "application/json")
    public PersonDto updatePerson(@PathVariable("uuid") String uuid,
                                  @Valid @RequestBody UpdatePersonDto updateRequest) {
        return ps.updatePerson(uuid, updateRequest);
    }

}
