/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "factura")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Factura.findAll", query = "SELECT f FROM Factura f")
    , @NamedQuery(name = "Factura.findByIdfactura", query = "SELECT f FROM Factura f WHERE f.idfactura = :idfactura")
    , @NamedQuery(name = "Factura.findByFecha", query = "SELECT f FROM Factura f WHERE f.fecha = :fecha")
    , @NamedQuery(name = "Factura.findByTotalFactura", query = "SELECT f FROM Factura f WHERE f.totalFactura = :totalFactura")})
public class Factura implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idfactura")
    private Integer idfactura;
    @Column(name = "fecha")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    @Column(name = "total_factura")
    private Integer totalFactura;
    @JoinColumn(name = "cliente_Id", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario clienteId;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "facturaIdfactura", fetch = FetchType.EAGER)
    private List<Pedido> pedidoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idfactura", fetch = FetchType.EAGER)
    private List<FacturaHasProducto> facturaHasProductoList;

    public Factura() {
    }

    public Factura(Integer idfactura) {
        this.idfactura = idfactura;
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

    public Integer getTotalFactura() {
        return totalFactura;
    }

    public void setTotalFactura(Integer totalFactura) {
        this.totalFactura = totalFactura;
    }

    public Usuario getClienteId() {
        return clienteId;
    }

    public void setClienteId(Usuario clienteId) {
        this.clienteId = clienteId;
    }

    @XmlTransient
    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }

    @XmlTransient
    public List<FacturaHasProducto> getFacturaHasProductoList() {
        return facturaHasProductoList;
    }

    public void setFacturaHasProductoList(List<FacturaHasProducto> facturaHasProductoList) {
        this.facturaHasProductoList = facturaHasProductoList;
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
        if (!(object instanceof Factura)) {
            return false;
        }
        Factura other = (Factura) object;
        if ((this.idfactura == null && other.idfactura != null) || (this.idfactura != null && !this.idfactura.equals(other.idfactura))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Factura[ idfactura=" + idfactura + " ]";
    }
    
}
