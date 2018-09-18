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
@Table(name = "registroasistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Registroasistencia.findAll", query = "SELECT r FROM Registroasistencia r")
    , @NamedQuery(name = "Registroasistencia.findByIdasistencia", query = "SELECT r FROM Registroasistencia r WHERE r.idasistencia = :idasistencia")
    , @NamedQuery(name = "Registroasistencia.findByFecha", query = "SELECT r FROM Registroasistencia r WHERE r.fecha = :fecha")
    , @NamedQuery(name = "Registroasistencia.findByHoraEntrada", query = "SELECT r FROM Registroasistencia r WHERE r.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Registroasistencia.findByHoraSalida", query = "SELECT r FROM Registroasistencia r WHERE r.horaSalida = :horaSalida")
    , @NamedQuery(name = "Registroasistencia.findByInsertado", query = "SELECT r FROM Registroasistencia r WHERE r.insertado = :insertado")})
public class Registroasistencia implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idasistencia")
    private Integer idasistencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "horaEntrada")
    private String horaEntrada;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "horaSalida")
    private String horaSalida;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 65535)
    @Column(name = "Observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Column(name = "INSERTADO")
    @Temporal(TemporalType.TIMESTAMP)
    private Date insertado;

    public Registroasistencia() {
    }

    public Registroasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Registroasistencia(Integer idasistencia, Date fecha, String horaEntrada, String horaSalida, String observaciones, Date insertado) {
        this.idasistencia = idasistencia;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.observaciones = observaciones;
        this.insertado = insertado;
    }

    public Integer getIdasistencia() {
        return idasistencia;
    }

    public void setIdasistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(String horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public String getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(String horaSalida) {
        this.horaSalida = horaSalida;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
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
        hash += (idasistencia != null ? idasistencia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Registroasistencia)) {
            return false;
        }
        Registroasistencia other = (Registroasistencia) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Registroasistencia[ idasistencia=" + idasistencia + " ]";
    }
    
}
