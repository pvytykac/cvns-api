package net.pvytykac.cvns.dao;

import net.pvytykac.cvns.model.impl.PersonDbo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

/**
 * @author Paly
 * @since 2017-11-25
 */
@RepositoryRestResource(exported = false, collectionResourceRel = "person")
public interface PersonDao extends MongoRepository<PersonDbo, String> {
}
