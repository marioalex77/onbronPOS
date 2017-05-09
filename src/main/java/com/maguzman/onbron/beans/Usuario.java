package com.maguzman.onbron.beans;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by maguzman on 09/05/2017.
 */
@Entity
@Table(name="usuario")
public class Usuario implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Email
    @NotEmpty
    @Size(min=3, max=255)
    @Column(name="correo")
    private String correo;

    @NotEmpty
    @Size(min=3, max=255)
    @Column(name="password")
    private String password;

    @NotEmpty
    @Size(min=3, max=100)
    @Column(name="nombres")
    private String nombres;

    @NotEmpty
    @Size(min=3, max=45)
    @Column(name="primerApellido")
    private String primerApellido;

    @Size(min=3, max=45)
    @Column(name="segundoApellido")
    private String segundoApellido;

    @NotEmpty
    @Size(min=1,max = 1)
    @Column(name="genero")
    private String genero;

    @NotEmpty
    @Size(min=1,max = 1)
    @Column(name="habilitado")
    private String habilitado;

    @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="usuariorolusuario",
            joinColumns = {@JoinColumn(name="idUsuario")},
            inverseJoinColumns = {@JoinColumn(name="idRolUsuario")})
    private Set<RolUsuario> rolUsuario = new HashSet<RolUsuario>();

    public Usuario() {
        this.idUsuario = 0;
        this.correo = "";
        this.password = "";
        this.nombres = "";
        this.primerApellido = "";
        this.segundoApellido = "";
        this.genero = "";
        this.habilitado = "";
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getHabilitado() {
        return habilitado;
    }

    public void setHabilitado(String habilitado) {
        this.habilitado = habilitado;
    }

    public Set<RolUsuario> getRolUsuario() {
        return rolUsuario;
    }

    public void setRolUsuario(Set<RolUsuario> rolUsuario) {
        this.rolUsuario = rolUsuario;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (!(obj instanceof Usuario))
            return false;
        Usuario other = (Usuario) obj;
        if (idUsuario == null) {
            if (other.idUsuario != null)
                return false;
        } else if (!idUsuario.equals(other.idUsuario))
            return false;
        if (correo == null) {
            if (other.correo != null)
                return false;
        } else if (!correo.equals(other.correo))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((idUsuario == null) ? 0 : idUsuario.hashCode());
        result = prime * result + ((correo == null) ? 0 : correo.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", correo='" + correo + '\'' +
                ", password='" + password + '\'' +
                ", nombres='" + nombres + '\'' +
                ", primerApellido='" + primerApellido + '\'' +
                ", segundoApellido='" + segundoApellido + '\'' +
                ", genero='" + genero + '\'' +
                ", habilitado='" + habilitado + '\'' +
                ", rolUsuario=" + rolUsuario +
                '}';
    }
}
