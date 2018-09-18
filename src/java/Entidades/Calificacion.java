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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "calificacion")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Calificacion.findAll", query = "SELECT c FROM Calificacion c")
    , @NamedQuery(name = "Calificacion.findByIdcalificacion", query = "SELECT c FROM Calificacion c WHERE c.idcalificacion = :idcalificacion")
    , @NamedQuery(name = "Calificacion.findByCalificacion", query = "SELECT c FROM Calificacion c WHERE c.calificacion = :calificacion")
    , @NamedQuery(name = "Calificacion.findByDescripcion", query = "SELECT c FROM Calificacion c WHERE c.descripcion = :descripcion")
    , @NamedQuery(name = "Calificacion.findByCalificado", query = "SELECT c FROM Calificacion c WHERE c.calificado = :calificado")})
public class Calificacion implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcalificacion")
    private Integer idcalificacion;
    @Size(max = 45)
    @Column(name = "calificacion")
    private String calificacion;
    @Size(max = 45)
    @Column(name = "descripcion")
    private String descripcion;
    @Size(max = 45)
    @Column(name = "calificado")
    private String calificado;
    @JoinColumn(name = "pedido_id", referencedColumnName = "idpedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedidoId;

    public Calificacion() {
    }

    public Calificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public Integer getIdcalificacion() {
        return idcalificacion;
    }

    public void setIdcalificacion(Integer idcalificacion) {
        this.idcalificacion = idcalificacion;
    }

    public String getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(String calificacion) {
        this.calificacion = calificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCalificado() {
        return calificado;
    }

    public void setCalificado(String calificado) {
        this.calificado = calificado;
    }

    public Pedido getPedidoId() {
        return pedidoId;
    }

    public void setPedidoId(Pedido pedidoId) {
        this.pedidoId = pedidoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idcalificacion != null ? idcalificacion.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calificacion)) {
            return false;
        }
        Calificacion other = (Calificacion) object;
        if ((this.idcalificacion == null && other.idcalificacion != null) || (this.idcalificacion != null && !this.idcalificacion.equals(other.idcalificacion))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Calificacion[ idcalificacion=" + idcalificacion + " ]";
    }
    
}
