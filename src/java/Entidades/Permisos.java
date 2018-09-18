/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author DELL
 */
@Entity
@Table(name = "permisos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Permisos.findAll", query = "SELECT p FROM Permisos p")
    , @NamedQuery(name = "Permisos.findByIdPermiso", query = "SELECT p FROM Permisos p WHERE p.idPermiso = :idPermiso")
    , @NamedQuery(name = "Permisos.findByNombre", query = "SELECT p FROM Permisos p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Permisos.findByNombreIngles", query = "SELECT p FROM Permisos p WHERE p.nombreIngles = :nombreIngles")
    , @NamedQuery(name = "Permisos.findByIcon", query = "SELECT p FROM Permisos p WHERE p.icon = :icon")})
public class Permisos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "Id_Permiso")
    private Integer idPermiso;
    @Size(max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Size(max = 45)
    @Column(name = "nombre_ingles")
    private String nombreIngles;
    @Lob
    @Size(max = 65535)
    @Column(name = "Url")
    private String url;
    @Size(max = 45)
    @Column(name = "Icon")
    private String icon;
    @JoinTable(name = "rol_has_permisos", joinColumns = {
        @JoinColumn(name = "permisos_Id_Permiso", referencedColumnName = "Id_Permiso")}, inverseJoinColumns = {
        @JoinColumn(name = "rol_Id_Rol", referencedColumnName = "Id_Rol")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Rol> rolList;
    @OneToMany(mappedBy = "permisoPadre", fetch = FetchType.EAGER)
    private List<Permisos> permisosList;
    @JoinColumn(name = "Permiso_Padre", referencedColumnName = "Id_Permiso")
    @ManyToOne(fetch = FetchType.EAGER)
    private Permisos permisoPadre;

    public Permisos() {
    }

    public Permisos(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public Integer getIdPermiso() {
        return idPermiso;
    }

    public void setIdPermiso(Integer idPermiso) {
        this.idPermiso = idPermiso;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNombreIngles() {
        return nombreIngles;
    }

    public void setNombreIngles(String nombreIngles) {
        this.nombreIngles = nombreIngles;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    @XmlTransient
    public List<Rol> getRolList() {
        return rolList;
    }

    public void setRolList(List<Rol> rolList) {
        this.rolList = rolList;
    }

    @XmlTransient
    public List<Permisos> getPermisosList() {
        return permisosList;
    }

    public void setPermisosList(List<Permisos> permisosList) {
        this.permisosList = permisosList;
    }

    public Permisos getPermisoPadre() {
        return permisoPadre;
    }

    public void setPermisoPadre(Permisos permisoPadre) {
        this.permisoPadre = permisoPadre;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPermiso != null ? idPermiso.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Permisos)) {
            return false;
        }
        Permisos other = (Permisos) object;
        if ((this.idPermiso == null && other.idPermiso != null) || (this.idPermiso != null && !this.idPermiso.equals(other.idPermiso))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Permisos[ idPermiso=" + idPermiso + " ]";
    }
    
}
