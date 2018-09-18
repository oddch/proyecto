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
@Table(name = "registrofactura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registrofactura.findAll", query = "SELECT r FROM Registrofactura r")
    , @NamedQuery(name = "Registrofactura.findByIdfactura", query = "SELECT r FROM Registrofactura r WHERE r.idfactura = :idfactura")
    , @NamedQuery(name = "Registrofactura.findByFecha", query = "SELECT r FROM Registrofactura r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Registrofactura.findByTotalFactura", query = "SELECT r FROM Registrofactura r WHERE r.totalFactura = :totalFactura")
    , @NamedQuery(name = "Registrofactura.findByRegistrofacturacol", query = "SELECT r FROM Registrofactura r WHERE r.registrofacturacol = :registrofacturacol")
    , @NamedQuery(name = "Registrofactura.findByInsertado", query = "SELECT r FROM Registrofactura r WHERE r.insertado = :insertado")})
public class Registrofactura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total_factura")
    private int totalFactura;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Registrofacturacol")
    private String registrofacturacol;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "INSERTADO")
    private String insertado;

    public Registrofactura() {
    }

    public Registrofactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Registrofactura(Integer idfactura, Date fecha, int totalFactura, String registrofacturacol, String insertado) {
        this.idfactura = idfactura;
        this.fecha = fecha;
        this.totalFactura = totalFactura;
        this.registrofacturacol = registrofacturacol;
        this.insertado = insertado;
    }

    public Integer getIdfactura() {
        return idfactura;
    }

    public void setIdfactura(Integer idfactura) {
        this.idfactura = idfactura;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(int totalFactura) {
        this.totalFactura = totalFactura;
    }

    public String getRegistrofacturacol() {
        return registrofacturacol;
    }

    public void setRegistrofacturacol(String registrofacturacol) {
        this.registrofacturacol = registrofacturacol;
    }

    public String getInsertado() {
        return insertado;
    }

    public void setInsertado(String insertado) {
        this.insertado = insertado;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idfactura != null ? idfactura.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registrofactura)) {
            return false;
        }
        Registrofactura other = (Registrofactura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Registrofactura[ idfactura=" + idfactura + " ]";
    }
    
}
