package edu.proyectofinal.integradorrs.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import edu.proyectofinal.integradorrs.model.Usuario;
import edu.proyectofinal.integradorrs.services.usuario.UsuarioService;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import edu.proyectofinal.integradorrs.exceptions.EmptyResultException;
import edu.proyectofinal.integradorrs.model.Token;
import java.util.Collection;
import org.springframework.http.HttpHeaders;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/api/usuario")
public class LoginController extends AbstractController<Usuario> {

    @Autowired
    private UsuarioService usuarioService;

    @RequestMapping(method = RequestMethod.GET, value="/")
    public ResponseEntity<Collection<Usuario>> getAll() {

        System.out.println("getAll");

        Collection<Usuario> usuarios = usuarioService.getAllUsuarios();

        return super.collectionResult(usuarios);

    }

    // fix http://stackoverflow.com/questions/3526523/spring-mvc-pathvariable-getting-truncated
    @RequestMapping(method = RequestMethod.GET, value = "/email/{email:.+}")
    public ResponseEntity<Usuario> getByEmail(@Validated @PathVariable("email") String email) {

        System.out.println("getByEmail");
        System.out.println("Email: " + email);

        Usuario usuario = usuarioService.getByEmail(email);

        if (null == usuario) {
            throw new EmptyResultException(Usuario.class);
        }
        return super.singleResult(usuario);

    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/token/twitter/email/{email:.+}")
    public ResponseEntity<Token> getTokenByEmail(@Validated @PathVariable("email") String email, String socialnetwork) {

        Token token = new Token();
        System.out.println("getTokenByEmail");
        System.out.println("Email: " + email);
        System.out.println("Social Network: " + socialnetwork);

       Collection<Token> tokens = usuarioService.getTokenByEmail(email);
       for(Token atoken: tokens)
       {
           if(atoken.getSocialnetwork().equals(socialnetwork))
           {
               token = atoken;
           }
       }
       
        if (null == token) {
            throw new EmptyResultException(Usuario.class);
        }
        return super.singleResult(token);

    }
    


    @RequestMapping(method = RequestMethod.GET, value = "/id/{id}")
    public ResponseEntity<Usuario> getById(@Validated @PathVariable("id") String id) {

        System.out.println("getById");
        System.out.println("Id: " + id);

        Usuario usuario = usuarioService.getById(id);
        if (null == usuario) {
            throw new EmptyResultException(Usuario.class);
        }
        return super.singleResult(usuario);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Usuario> save(@RequestBody Usuario usuario) {

        usuarioService.save(usuario);

        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);

    }
    
    @RequestMapping(method = RequestMethod.POST, value="/push")
    public ResponseEntity<Token> saveToken(@RequestBody Token token) {

        usuarioService.saveToken(token);

        return new ResponseEntity<Token>(token, HttpStatus.OK);

    }
}
