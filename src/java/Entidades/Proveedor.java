/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "proveedor")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Proveedor.findAll", query = "SELECT p FROM Proveedor p")
    , @NamedQuery(name = "Proveedor.findByIdproveedor", query = "SELECT p FROM Proveedor p WHERE p.idproveedor = :idproveedor")
    , @NamedQuery(name = "Proveedor.findByNombreProveedor", query = "SELECT p FROM Proveedor p WHERE p.nombreProveedor = :nombreProveedor")
    , @NamedQuery(name = "Proveedor.findByDireccionComercial", query = "SELECT p FROM Proveedor p WHERE p.direccionComercial = :direccionComercial")
    , @NamedQuery(name = "Proveedor.findByTelefonoComercial", query = "SELECT p FROM Proveedor p WHERE p.telefonoComercial = :telefonoComercial")
    , @NamedQuery(name = "Proveedor.findByCorreoComercial", query = "SELECT p FROM Proveedor p WHERE p.correoComercial = :correoComercial")})
public class Proveedor implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idproveedor")
    private Integer idproveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nombreProveedor")
    private String nombreProveedor;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccionComercial")
    private String direccionComercial;
    @Basic(optional = false)
    @NotNull
    @Column(name = "telefonoComercial")
    private int telefonoComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "correoComercial")
    private String correoComercial;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "observacion")
    private String observacion;
    @JoinColumn(name = "producto_idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto productoIdproducto;

    public Proveedor() {
    }

    public Proveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public Proveedor(Integer idproveedor, String nombreProveedor, String direccionComercial, int telefonoComercial, String correoComercial, String observacion) {
        this.idproveedor = idproveedor;
        this.nombreProveedor = nombreProveedor;
        this.direccionComercial = direccionComercial;
        this.telefonoComercial = telefonoComercial;
        this.correoComercial = correoComercial;
        this.observacion = observacion;
    }

    public Integer getIdproveedor() {
        return idproveedor;
    }

    public void setIdproveedor(Integer idproveedor) {
        this.idproveedor = idproveedor;
    }

    public String getNombreProveedor() {
        return nombreProveedor;
    }

    public void setNombreProveedor(String nombreProveedor) {
        this.nombreProveedor = nombreProveedor;
    }

    public String getDireccionComercial() {
        return direccionComercial;
    }

    public void setDireccionComercial(String direccionComercial) {
        this.direccionComercial = direccionComercial;
    }

    public int getTelefonoComercial() {
        return telefonoComercial;
    }

    public void setTelefonoComercial(int telefonoComercial) {
        this.telefonoComercial = telefonoComercial;
    }

    public String getCorreoComercial() {
        return correoComercial;
    }

    public void setCorreoComercial(String correoComercial) {
        this.correoComercial = correoComercial;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Producto getProductoIdproducto() {
        return productoIdproducto;
    }

    public void setProductoIdproducto(Producto productoIdproducto) {
        this.productoIdproducto = productoIdproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idproveedor != null ? idproveedor.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Proveedor)) {
            return false;
        }
        Proveedor other = (Proveedor) object;
        if ((this.idproveedor == null && other.idproveedor != null) || (this.idproveedor != null && !this.idproveedor.equals(other.idproveedor))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Proveedor[ idproveedor=" + idproveedor + " ]";
    }
    
}
