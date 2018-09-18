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
@Table(name = "ruta")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Ruta.findAll", query = "SELECT r FROM Ruta r")
    , @NamedQuery(name = "Ruta.findByIdruta", query = "SELECT r FROM Ruta r WHERE r.idruta = :idruta")
    , @NamedQuery(name = "Ruta.findByLocalidad", query = "SELECT r FROM Ruta r WHERE r.localidad = :localidad")
    , @NamedQuery(name = "Ruta.findByDireccion", query = "SELECT r FROM Ruta r WHERE r.direccion = :direccion")
    , @NamedQuery(name = "Ruta.findByTelefono", query = "SELECT r FROM Ruta r WHERE r.telefono = :telefono")
    , @NamedQuery(name = "Ruta.findByObservacion", query = "SELECT r FROM Ruta r WHERE r.observacion = :observacion")})
public class Ruta implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "idruta")
    private Integer idruta;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "localidad")
    private String localidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "telefono")
    private String telefono;
    @Lob
    @Size(max = 65535)
    @Column(name = "imagen")
    private String imagen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Observacion")
    private String observacion;
    @JoinColumn(name = "pedido_idpedido", referencedColumnName = "idpedido")
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Pedido pedidoIdpedido;

    public Ruta() {
    }

    public Ruta(Integer idruta) {
        this.idruta = idruta;
    }

    public Ruta(Integer idruta, String localidad, String direccion, String telefono, String observacion) {
        this.idruta = idruta;
        this.localidad = localidad;
        this.direccion = direccion;
        this.telefono = telefono;
        this.observacion = observacion;
    }

    public Integer getIdruta() {
        return idruta;
    }

    public void setIdruta(Integer idruta) {
        this.idruta = idruta;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Pedido getPedidoIdpedido() {
        return pedidoIdpedido;
    }

    public void setPedidoIdpedido(Pedido pedidoIdpedido) {
        this.pedidoIdpedido = pedidoIdpedido;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idruta != null ? idruta.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ruta)) {
            return false;
        }
        Ruta other = (Ruta) object;
        if ((this.idruta == null && other.idruta != null) || (this.idruta != null && !this.idruta.equals(other.idruta))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Ruta[ idruta=" + idruta + " ]";
    }
    
}
