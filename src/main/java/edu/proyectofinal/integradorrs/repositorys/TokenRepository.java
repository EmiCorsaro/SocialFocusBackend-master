package edu.proyectofinal.integradorrs.repositorys;

import edu.proyectofinal.integradorrs.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "tokens", path = "tokens")
public interface TokenRepository extends MongoRepository<Token, String> {

    
    /**
     *
     * @param email
     * @return
     */
    @Query("{ 'email' : ?0}")
    public Token findByEmail(String email);
    

}