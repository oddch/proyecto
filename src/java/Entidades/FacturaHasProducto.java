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
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "factura_has_producto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaHasProducto.findAll", query = "SELECT f FROM FacturaHasProducto f")
    , @NamedQuery(name = "FacturaHasProducto.findById", query = "SELECT f FROM FacturaHasProducto f WHERE f.id = :id")
    , @NamedQuery(name = "FacturaHasProducto.findByCantidad", query = "SELECT f FROM FacturaHasProducto f WHERE f.cantidad = :cantidad")})
public class FacturaHasProducto implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Column(name = "cantidad")
    private Integer cantidad;
    @JoinColumn(name = "idfactura", referencedColumnName = "idfactura")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Factura idfactura;
    @JoinColumn(name = "idproducto", referencedColumnName = "idproducto")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Producto idproducto;

    public FacturaHasProducto() {
    }

    public FacturaHasProducto(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Factura getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Factura idfactura) {
        this.idfactura = idfactura;
    }

    public Producto getIdproducto() {
        return idproducto;
    }

    public void setIdproducto(Producto idproducto) {
        this.idproducto = idproducto;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaHasProducto)) {
            return false;
        }
        FacturaHasProducto other = (FacturaHasProducto) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.FacturaHasProducto[ id=" + id + " ]";
    }
    
}
