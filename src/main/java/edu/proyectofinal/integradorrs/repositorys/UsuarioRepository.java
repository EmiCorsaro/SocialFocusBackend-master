package edu.proyectofinal.integradorrs.repositorys;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.proyectofinal.integradorrs.model.Usuario;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "usuarios", path = "usuarios")
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

    
    /**
     *
     * @param email
     * @return
     */
    @Query("{ 'email' : ?0}")
    public Usuario findByEmail(String email);
    

}
