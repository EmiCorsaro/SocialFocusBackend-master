package edu.proyectofinal.integradorrs.model;

import java.util.Date;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.index.Indexed;

@Document(collection = "usuarios")
public class Usuario {

    @Id
    private String id;
    @Field
    @Indexed(unique = true)
    private String email;
    @Field
    private String clave;
    @Field
    private Date creationDate;
    @Field
    private String telefono;
    @Field
    private Date fechaNacimiento;
    @Field
    private String pais;
    @Field
    private String provincia;
    @Field
    private String ciudad;
    @Field
    private String calle;

    public Usuario() {
        super();
    }

    public Usuario(String id, String email, String clave, Date creationDate, String telefono,
            Date fechaNacimiento, String pais, String provincia, String ciudad, String calle) {
        super();
        this.id = id;
        this.email = email;
        this.clave = clave;
        this.creationDate = creationDate;
        this.telefono = telefono;
        this.fechaNacimiento = fechaNacimiento;
        this.pais = pais;
        this.provincia = provincia;
        this.ciudad = ciudad;
        this.calle = calle;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

//    @Override
//    @JsonIgnore
//    public boolean isAnErrorResponse() {
//        return false;
//    }
    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append(" id:- ").append(this.getId());
        str.append(" email:- ").append(this.getEmail());
        str.append(" creationDate:- ").append(this.getCreationDate());
        str.append(" telefono:- ").append(this.getTelefono() );
        str.append(" fechaNacimiento:- ").append( this.getFechaNacimiento());
        str.append(" pais:- ").append(this.getPais());
        str.append(" provincia:- ").append(this.getProvincia());
        str.append(" ciudad:- ").append(this.getCiudad());
        str.append(" calle:- ").append(this.getCalle());

         return str.toString();
    }
}
