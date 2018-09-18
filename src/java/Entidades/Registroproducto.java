/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "registroproducto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroproducto.findAll", query = "SELECT r FROM Registroproducto r")
    , @NamedQuery(name = "Registroproducto.findByIdproducto", query = "SELECT r FROM Registroproducto r WHERE r.idproducto = :idproducto")
    , @NamedQuery(name = "Registroproducto.findByNombre", query = "SELECT r FROM Registroproducto r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Registroproducto.findByTipoProducto", query = "SELECT r FROM Registroproducto r WHERE r.tipoProducto = :tipoProducto")
    , @NamedQuery(name = "Registroproducto.findByPrecio", query = "SELECT r FROM Registroproducto r WHERE r.precio = :precio")
    , @NamedQuery(name = "Registroproducto.findByCantidad", query = "SELECT r FROM Registroproducto r WHERE r.cantidad = :cantidad")
    , @NamedQuery(name = "Registroproducto.findByInsertado", query = "SELECT r FROM Registroproducto r WHERE r.insertado = :insertado")})
public class Registroproducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproducto")
    private Integer idproducto;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "tipo_producto")
    private String tipoProducto;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private int precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertado;

    public Registroproducto() {
    }

    public Registroproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public Registroproducto(Integer idproducto, String nombre, String imagen, String tipoProducto, int precio, int cantidad, Date insertado) {
        this.idproducto = idproducto;
        this.nombre = nombre;
        this.imagen = imagen;
        this.tipoProducto = tipoProducto;
        this.precio = precio;
        this.cantidad = cantidad;
        this.insertado = insertado;
    }

    public Integer getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Integer idproducto) {
        this.idproducto = idproducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public Date getInsertado() {
        return insertado;
    }

    public void setInsertado(Date insertado) {
        this.insertado = insertado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproducto != null ? idproducto.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroproducto)) {
            return false;
        }
        Registroproducto other = (Registroproducto) object;
        if ((this.idproducto == null && other.idproducto != null) || (this.idproducto != null && !this.idproducto.equals(other.idproducto))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Registroproducto[ idproducto=" + idproducto + " ]";
    }
    
}
