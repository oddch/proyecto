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
@Table(name = "registropedido")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registropedido.findAll", query = "SELECT r FROM Registropedido r")
    , @NamedQuery(name = "Registropedido.findByIdpedido", query = "SELECT r FROM Registropedido r WHERE r.idpedido = :idpedido")
    , @NamedQuery(name = "Registropedido.findByFechaPedido", query = "SELECT r FROM Registropedido r WHERE r.fechaPedido = :fechaPedido")
    , @NamedQuery(name = "Registropedido.findByEstado", query = "SELECT r FROM Registropedido r WHERE r.estado = :estado")
    , @NamedQuery(name = "Registropedido.findByInsertado", query = "SELECT r FROM Registropedido r WHERE r.insertado = :insertado")})
public class Registropedido implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idpedido")
    private Integer idpedido;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaPedido;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertado;

    public Registropedido() {
    }

    public Registropedido(Integer idpedido) {
        this.idpedido = idpedido;
    }

    public Registropedido(Integer idpedido, Date fechaPedido, String estado, Date insertado) {
        this.idpedido = idpedido;
        this.fechaPedido = fechaPedido;
        this.estado = estado;
        this.insertado = insertado;
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

    public Date getInsertado() {
        return insertado;
    }

    public void setInsertado(Date insertado) {
        this.insertado = insertado;
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
        if (!(object instanceof Registropedido)) {
            return false;
        }
        Registropedido other = (Registropedido) object;
        if ((this.idpedido == null && other.idpedido != null) || (this.idpedido != null && !this.idpedido.equals(other.idpedido))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Registropedido[ idpedido=" + idpedido + " ]";
    }
    
}
