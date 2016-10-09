package edu.proyectofinal.integradorrs.model;

import org.springframework.data.annotation.Id;

/**
 * Created by mariano on 25/03/16.
 */
public abstract class AbstractModel {

    @Id
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}