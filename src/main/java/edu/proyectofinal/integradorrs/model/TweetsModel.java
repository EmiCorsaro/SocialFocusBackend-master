/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.proyectofinal.integradorrs.model;


import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;
/**
 *
 * @author MarianoAndres
 */
@Document(collection = "tweets")
public class TweetsModel {
 
    @Id
    private String id;
    @Field
    private String menciones;
    @Field
    private Date fechaTweet;

    public TweetsModel(String id, String menciones, Date fechaTweet) {
        this.id = id;
        this.menciones = menciones;
        this.fechaTweet = fechaTweet;
    }

    @Override
    public String toString() {
        return "TweetsModel{" + "id=" + id + ", menciones=" + menciones + ", fechaTweet=" + fechaTweet + '}';
    }

    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMenciones() {
        return menciones;
    }

    public void setMenciones(String menciones) {
        this.menciones = menciones;
    }

    public Date getFechaTweet() {
        return fechaTweet;
    }

    public void setFechaTweet(Date fechaTweet) {
        this.fechaTweet = fechaTweet;
    }
    
    
    
}
