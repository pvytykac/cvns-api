package net.pvytykac.cvns.endpoints.generic.dto;

import net.pvytykac.cvns.model.Locale;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author Paly
 * @since 2017-11-26
 */
public class LocalizedText {

    @NotBlank
    private String text;

    @NotNull
    private Locale locale;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Locale getLocale() {
        return locale;
    }

    public void setLocale(Locale locale) {
        this.locale = locale;
    }
}
