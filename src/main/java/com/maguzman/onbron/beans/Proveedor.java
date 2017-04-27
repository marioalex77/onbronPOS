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

@Entity
@Table(name="proveedor")
public class Proveedor implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private int idProveedor;
    @Column(name="ncr",nullable=false)
    private String nrc;
    @Column(name="nombre",nullable=false)
    private String nombre;

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
}
