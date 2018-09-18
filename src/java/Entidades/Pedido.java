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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "pedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Pedido.findAll", query = "SELECT p FROM Pedido p")
    , @NamedQuery(name = "Pedido.findByIdpedido", query = "SELECT p FROM Pedido p WHERE p.idpedido = :idpedido")
    , @NamedQuery(name = "Pedido.findByFechaPedido", query = "SELECT p FROM Pedido p WHERE p.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Pedido.findByEstado", query = "SELECT p FROM Pedido p WHERE p.estado = :estado")})
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Size(max = 45)
    @Column(name = "estado")
    private String estado;
    @JoinTable(name = "asignaciones", joinColumns = {
        @JoinColumn(name = "pedido_id", referencedColumnName = "idpedido")}, inverseJoinColumns = {
        @JoinColumn(name = "usuario_Id", referencedColumnName = "Id_Usuario")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Usuario> usuarioList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoId", fetch = FetchType.EAGER)
    private List<Calificacion> calificacionList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pedidoIdpedido", fetch = FetchType.EAGER)
    private List<Ruta> rutaList;
    @JoinColumn(name = "factura_idfactura", referencedColumnName = "idfactura")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Factura facturaIdfactura;
    @JoinColumn(name = "cliente_Id", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario clienteId;

    public Pedido() {
    }

    public Pedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Integer getIdpedido() {
        return idpedido;
    }

    public void setIdpedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Date getFechaPedido() {
        return fechaPedido;
    }

    public void setFechaPedido(Date fechaPedido) {
        this.fechaPedido = fechaPedido;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @XmlTransient
    public List<Usuario> getUsuarioList() {
        return usuarioList;
    }

    public void setUsuarioList(List<Usuario> usuarioList) {
        this.usuarioList = usuarioList;
    }

    @XmlTransient
    public List<Calificacion> getCalificacionList() {
        return calificacionList;
    }

    public void setCalificacionList(List<Calificacion> calificacionList) {
        this.calificacionList = calificacionList;
    }

    @XmlTransient
    public List<Ruta> getRutaList() {
        return rutaList;
    }

    public void setRutaList(List<Ruta> rutaList) {
        this.rutaList = rutaList;
    }

    public Factura getFacturaIdfactura() {
        return facturaIdfactura;
    }

    public void setFacturaIdfactura(Factura facturaIdfactura) {
        this.facturaIdfactura = facturaIdfactura;
    }

    public Usuario getClienteId() {
        return clienteId;
    }

    public void setClienteId(Usuario clienteId) {
        this.clienteId = clienteId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idpedido != null ? idpedido.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Pedido)) {
            return false;
        }
        Pedido other = (Pedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Pedido[ idpedido=" + idpedido + " ]";
    }
    
}
