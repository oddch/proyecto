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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "promociones")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Promociones.findAll", query = "SELECT p FROM Promociones p")
    , @NamedQuery(name = "Promociones.findByIdPromociones", query = "SELECT p FROM Promociones p WHERE p.idPromociones = :idPromociones")
    , @NamedQuery(name = "Promociones.findByFecha", query = "SELECT p FROM Promociones p WHERE p.fecha = :fecha")
    , @NamedQuery(name = "Promociones.findByTitulo", query = "SELECT p FROM Promociones p WHERE p.titulo = :titulo")
    , @NamedQuery(name = "Promociones.findByDescripcion", query = "SELECT p FROM Promociones p WHERE p.descripcion = :descripcion")})
public class Promociones implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idPromociones")
    private Integer idPromociones;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Size(max = 45)
    @Column(name = "Titulo")
    private String titulo;
    @Size(max = 500)
    @Column(name = "Descripcion")
    private String descripcion;

    public Promociones() {
    }

    public Promociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }

    public Integer getIdPromociones() {
        return idPromociones;
    }

    public void setIdPromociones(Integer idPromociones) {
        this.idPromociones = idPromociones;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPromociones != null ? idPromociones.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Promociones)) {
            return false;
        }
        Promociones other = (Promociones) object;
        if ((this.idPromociones == null && other.idPromociones != null) || (this.idPromociones != null && !this.idPromociones.equals(other.idPromociones))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Promociones[ idPromociones=" + idPromociones + " ]";
    }
    
}
