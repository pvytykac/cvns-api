package net.pvytykac.cvns.endpoints.person.dto;

import net.pvytykac.cvns.endpoints.generic.dto.LocalizedText;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.Valid;
import java.util.List;

/**
 * @author Paly
 * @since 2017-11-25
 */
public class CreatePersonDto {

    private String titlesBefore;

    @NotBlank
    private String firstname;

    @NotBlank
    private String lastname;

    private String titlesAfter;

    @Email
    private String email;

    @Valid
    private List<LocalizedText> bio;

    private String roleId;



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
