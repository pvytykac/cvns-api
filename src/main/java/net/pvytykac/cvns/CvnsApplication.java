package net.pvytykac.cvns;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import net.pvytykac.cvns.db.MongoProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.rest.RepositoryRestMvcAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Collection;
import java.util.Collections;

/**
 * @author Paly
 * @since 2017-11-25
 */
@SpringBootApplication(scanBasePackages = {"net.pvytykac.cvns"})
@Configuration
@EnableMongoRepositories
@EnableAutoConfiguration(exclude = RepositoryRestMvcAutoConfiguration.class)
public class CvnsApplication extends AbstractMongoConfiguration {

    private final MongoProperties mongo;

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CvnsApplication.class, args);
    }

    @Autowired
    public CvnsApplication(MongoProperties mongo) {
        this.mongo = mongo;
    }

    @Override
    protected String getDatabaseName() {
        return mongo.getDb();
    }

    @Override
    public Mongo mongo() throws Exception {
        MongoClientURI uri = new MongoClientURI("mongodb://" + mongo.getUser() + ":" + mongo.getPass() + "@" + mongo.getUrl() + ":" + mongo.getPort() + "/" + mongo.getDb());
        return new MongoClient(uri);
    }

    @Override
    protected Collection<String> getMappingBasePackages() {
        return Collections.singleton("net.pvytykac.cvns.model.*");
    }
}
