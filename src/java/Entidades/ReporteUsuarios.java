/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

/**
 *
 * @author Asus
 */
public class ReporteUsuarios {

    private int idUsuario;
    private int documento;
    private String nombres;
    private String apellidos;
    private String direccion;
    private int telefono;
    private int estado;
    private String email;
    private String clave;

    public ReporteUsuarios() {

    }

    public ReporteUsuarios(int idUsuario, int documento, String nombres, String apellidos, String direccion, int telefono, int estado, String email, String clave) {
        this.idUsuario = idUsuario;
        this.documento = documento;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
        this.estado = estado;
        this.email = email;
        this.clave = clave;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getDocumento() {
        return documento;
    }

    public void setDocumento(int documento) {
        this.documento = documento;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "ReporteUsuarios{" + "idUsuario=" + idUsuario + ", documento=" + documento + ", nombres=" + nombres + ", apellidos=" + apellidos + ", direccion=" + direccion + ", telefono=" + telefono + ", estado=" + estado + ", email=" + email + ", clave=" + clave + '}';
    }

}
