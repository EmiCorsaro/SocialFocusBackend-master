package edu.proyectofinal.integradorrs.configurations;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

@Configuration
public class SpringMongoConfig extends AbstractMongoConfiguration {

    @Override
    @Bean
    public Mongo mongo() throws Exception {
        return new MongoClient("127.0.0.1" + ":" + 27017);
    }
    @Override
    protected String getDatabaseName(){
        return "test";
    }
}

