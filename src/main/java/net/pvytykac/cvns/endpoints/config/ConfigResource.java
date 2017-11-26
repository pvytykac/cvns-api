package net.pvytykac.cvns.endpoints.config;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Paly
 * @since 2017-11-26
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping(value = "/config")
public class ConfigResource {

}
