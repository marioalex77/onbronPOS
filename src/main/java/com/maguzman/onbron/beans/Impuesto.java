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
import javax.validation.constraints.Digits;
import javax.validation.constraints.Size;

@Entity
public class Impuesto implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue
    private int idImpuesto;
    @Size(min=3,max=50, message = "Descripcion no puede ser mayor a 50 caracteres")
    private String descripcion;
    @Digits(integer = 2, fraction = 3, message = "El valor no puede ser mayor a 99.999")
    private double porcentaje;
    private char habilitado;

    public Impuesto() {
        this.descripcion = "";
        this.porcentaje = 0;
        this.habilitado = 0;
    }

    public Impuesto(int idImpuesto, String descripcion, double porcentaje,
                    char habilitado) {
        super();
        this.idImpuesto = idImpuesto;
        this.descripcion = descripcion;
        this.porcentaje = porcentaje;
        this.habilitado = habilitado;
    }

    public int getIdImpuesto() {
        return idImpuesto;
    }

    public void setIdImpuesto(int idImpuesto) {
        this.idImpuesto = idImpuesto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    public char getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(char habilitado) {
        this.habilitado = habilitado;
    }
}
