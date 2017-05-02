package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
public class Proveedor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idProveedor;
    @Size(min=3, max=15, message = "El numero de registro de contribuyente no puede ser mayor a 15 caracteres")
    private String nrc;// Numero de registro de contribuyente
    @Size(min=3, max=255, message = "El nombre del proveedor no puede ser mayor a 15 caracteres")
    private String nombre;
    @Size(min=3, max=17, message = "El NIT del proveedor no puede ser mayor a 17 caracteres")
    private String nit;

    public Proveedor() {
        this.nrc = "";
        this.nombre = "";
    }

    public Proveedor(int idProveedor, String nrc, String nombre) {
        super();
        this.idProveedor = idProveedor;
        this.nrc = nrc;
        this.nombre = nombre;
    }

    public Proveedor(String nrc, String nombre) {
        super();
        this.nrc = nrc;
        this.nombre = nombre;
    }

    public int getIdProveedor() {
        return idProveedor;
    }

    public void setIdProveedor(int idProveedor) {
        this.idProveedor = idProveedor;
    }

    public String getNrc() {
        return nrc;
    }

    public void setNrc(String nrc) {
        this.nrc = nrc;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }
}
