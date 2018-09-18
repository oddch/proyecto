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
@Table(name = "asistencia")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Asistencia.findAll", query = "SELECT a FROM Asistencia a")
    , @NamedQuery(name = "Asistencia.findByIdasistencia", query = "SELECT a FROM Asistencia a WHERE a.idasistencia = :idasistencia")
    , @NamedQuery(name = "Asistencia.findByFecha", query = "SELECT a FROM Asistencia a WHERE a.fecha = :fecha")
    , @NamedQuery(name = "Asistencia.findByHoraEntrada", query = "SELECT a FROM Asistencia a WHERE a.horaEntrada = :horaEntrada")
    , @NamedQuery(name = "Asistencia.findByHoraSalida", query = "SELECT a FROM Asistencia a WHERE a.horaSalida = :horaSalida")})
public class Asistencia implements Serializable {

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
    @Size(max = 45)
    @Column(name = "horaEntrada")
    private String horaEntrada;
    @Size(max = 45)
    @Column(name = "horaSalida")
    private String horaSalida;
    @Lob
    @Size(max = 65535)
    @Column(name = "Observaciones")
    private String observaciones;
    @JoinColumn(name = "usuario_Id_Usuario", referencedColumnName = "Id_Usuario")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Usuario usuarioIdUsuario;

    public Asistencia() {
    }

    public Asistencia(Integer idasistencia) {
        this.idasistencia = idasistencia;
    }

    public Asistencia(Integer idasistencia, Date fecha) {
        this.idasistencia = idasistencia;
        this.fecha = fecha;
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

    public Usuario getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(Usuario usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
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
        if (!(object instanceof Asistencia)) {
            return false;
        }
        Asistencia other = (Asistencia) object;
        if ((this.idasistencia == null && other.idasistencia != null) || (this.idasistencia != null && !this.idasistencia.equals(other.idasistencia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Asistencia[ idasistencia=" + idasistencia + " ]";
    }
    
}
