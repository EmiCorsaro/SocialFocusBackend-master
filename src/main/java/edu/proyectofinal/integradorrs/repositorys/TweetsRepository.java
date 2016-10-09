/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectofinal.integradorrs.repositorys;

import edu.proyectofinal.integradorrs.model.TweetsModel;
import edu.proyectofinal.integradorrs.model.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 *
 * @author MarianoAndres
 */
@RepositoryRestResource(collectionResourceRel = "tweets", path = "tweets")
public interface TweetsRepository extends MongoRepository<TweetsModel, String> {
    
    
}
