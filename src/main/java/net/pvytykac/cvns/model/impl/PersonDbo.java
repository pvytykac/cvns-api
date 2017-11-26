package net.pvytykac.cvns.model.impl;

import net.pvytykac.cvns.model.Dbo;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * @author Paly
 * @since 2017-11-25
 */
@Document(collection = "person")
public class PersonDbo implements Dbo<String> {

    @Id
    private String id;
    private String firstname;
    private String lastname;
    private String email;

    @Override
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
