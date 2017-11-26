package net.pvytykac.cvns.db;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;

/**
 * @author Paly
 * @since 2017-11-25
 */
@Component
public class MongoProperties {

    @NotNull
    private final String url;
    @NotNull
    private final String user;
    @NotNull
    private final String pass;
    @NotNull
    private final Integer port;
    @NotNull
    private final String db;

    public MongoProperties(@Value("${mongo.url}") String url, @Value("${mongo.user}") String user,
                           @Value("${mongo.pass}") String pass, @Value("${mongo.port}") Integer port,
                           @Value("${mongo.db}") String db) {
        this.url = url;
        this.user = user;
        this.pass = pass;
        this.port = port;
        this.db = db;
    }

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public Integer getPort() {
        return port;
    }

    public String getDb() {
        return db;
    }
}
