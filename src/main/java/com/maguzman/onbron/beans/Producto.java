package com.maguzman.onbron.beans;
/**
 * Created by maguzman on 27/04/2017.
 */
import java.io.Serializable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.CascadeType;

public class Producto implements Serializable{

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private int idProducto;
    private String codigo;
    private String nombre;
    private double precioUnitario;
    private double precioCompra;
    private int orden;
    private String descripcion;
    private char habilitado;
    private char visible;
    @OneToOne(cascade=CascadeType.ALL)
    @JoinColumn(name="idImagen")
    private Imagen imagen;
    @ManyToOne
    @JoinColumn(name="idCategoria")
    private Categoria categoria;
    @ManyToOne
    @JoinColumn(name="idImpuesto")
    private Impuesto impuesto;
    @ManyToOne
    @JoinColumn(name="idProveedor")
    private Proveedor proveedor;

    public Producto() {
        super();
        this.idProducto = 0;
        this.codigo = "";
        this.nombre = "";
        this.precioUnitario = 0;
        this.precioCompra = 0;
        this.orden = 0;
        this.habilitado = 0;
        this.visible = 0;
        this.imagen = null;
        this.categoria = new Categoria();
        this.impuesto = new Impuesto();
        this.proveedor = new Proveedor();
    }

    public Producto(String codigo, String nombre, double precioUnitario,
                    double precioCompra, int orden, char habilitado, char visible,
                    Categoria categoria, Impuesto impuesto, Proveedor proveedor) {
        super();
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioCompra = precioCompra;
        this.orden = orden;
        this.habilitado = habilitado;
        this.visible = visible;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
    }

    public Producto(int idProducto, String codigo, String nombre,
                    double precioUnitario, double precioCompra, int orden,
                    char habilitado, char visible, Categoria categoria,
                    Impuesto impuesto, Proveedor proveedor) {
        super();
        this.idProducto = idProducto;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precioUnitario = precioUnitario;
        this.precioCompra = precioCompra;
        this.orden = orden;
        this.habilitado = habilitado;
        this.visible = visible;
        this.categoria = categoria;
        this.impuesto = impuesto;
        this.proveedor = proveedor;
    }

    public int getIdProducto() {
        return idProducto;
    }
    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }
    public String getCodigo() {
        return codigo;
    }
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecioUnitario() {
        return precioUnitario;
    }
    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }
    public double getPrecioCompra() {
        return precioCompra;
    }
    public void setPrecioCompra(double precioCompra) {
        this.precioCompra = precioCompra;
    }
    public int getOrden() {
        return orden;
    }
    public void setOrden(int orden) {
        this.orden = orden;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public char getHabilitado() {
        return habilitado;
    }
    public void setHabilitado(char habilitado) {
        this.habilitado = habilitado;
    }
    public char getVisible() {
        return visible;
    }
    public void setVisible(char visible) {
        this.visible = visible;
    }
    public Imagen getImagen() {
        return imagen;
    }
    public void setImagen(Imagen imagen) {
        this.imagen = imagen;
    }
    public Categoria getCategoria() {
        return categoria;
    }
    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    public Impuesto getImpuesto() {
        return impuesto;
    }
    public void setImpuesto(Impuesto impuesto) {
        this.impuesto = impuesto;
    }
    public Proveedor getProveedor() {
        return proveedor;
    }
    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}