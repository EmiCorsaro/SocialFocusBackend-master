package edu.proyectofinal.integradorrs.services.usuario.impl;

import edu.proyectofinal.integradorrs.model.Token;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.proyectofinal.integradorrs.model.Usuario;
import edu.proyectofinal.integradorrs.repositorys.TokenRepository;
import edu.proyectofinal.integradorrs.repositorys.UsuarioRepository;
import edu.proyectofinal.integradorrs.services.usuario.UsuarioService;
import java.util.Date;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioRepository repository;
    @Autowired
    private TokenRepository tokenrepository;

    @Override
    public Collection<Usuario> getAllUsuarios() {
        Collection<Usuario> result = (Collection<Usuario>) repository.findAll();
        return result;
    }

    @Override
    public Usuario getById(String id) {
        return repository.findOne(id);
    }

    @Override
    public Usuario getByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Usuario save(Usuario usuario) {

        usuario.setCreationDate(new Date());
        repository.save(usuario);
        return usuario;
    }

    @Override
    public Collection<Token> getTokenByEmail(String email) {
        Collection<Token> result = (Collection<Token>) tokenrepository.findAll();
        return result;
    }

    @Override
    public Token saveToken(Token t) {
        Date aDate = new Date();
        t.setCreationDate(aDate);
        t.setModDate(aDate);
        tokenrepository.save(t);
        return t;
    }

}

