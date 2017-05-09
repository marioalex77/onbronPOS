package com.maguzman.onbron.beans;

/**
 * Created by maguzman on 09/05/2017.
 */
public enum TipoRolUsuario {
    USER("USER"),
    ADMIN("ADMIN"),
    SUPER("SUPER");

    String tipoRolUsuario;

    TipoRolUsuario(String tipoRolUsuario) {
        this.tipoRolUsuario = tipoRolUsuario;
    }

    public String getTipoRolUsuario() {
        return tipoRolUsuario;
    }
}
