/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectofinal.integradorrs.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 *
 * @author adrianromero
 */
public class Token {

    @Id
    private String id;
    @Field
    private Date creationDate;
    @Field
    private Date modDate;
    @Field
    private String email;
    @Field
    private String socialnetwork;
    @Field
    private String token;
    @Field
    private String secret;

    /*public Token(String email, String socialnetwork){
        this.id = 1;
        this.email = email;
        this.socialnetwork = socialnetwork;
        this.token = "d2ue3ue3beudjdb333enufis8";
        this.secret = "njsbfsbfsbfhsdfbjscscwjdcsjcbscs";
    }*/
    public Token() {
        super();
    }

    public Token(String id, String email, String socialnetwork, String token, String secret) {
        super();
        this.id = id;
        this.email = email;
        this.socialnetwork = socialnetwork;
        this.token = token;
        this.secret = secret;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Date getModDate() {
        return modDate;
    }

    public void setModDate(Date modDate) {
        this.modDate = modDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSocialnetwork() {
        return socialnetwork;
    }

    public void setSocialnetwork(String socialnetwork) {
        this.socialnetwork = socialnetwork;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    
    
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" id:- ").append(this.id);
        str.append(" token:- ").append(this.token);
        str.append(" secret:- ").append(this.secret);
        return str.toString();
    }
}
