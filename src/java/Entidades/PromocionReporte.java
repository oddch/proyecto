/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.util.Date;

/**
 *
 * @author Asus
 */
public class PromocionReporte {
    private String Titulo;
    private String Descripcion;
    
    public PromocionReporte(){
        
    }

    public PromocionReporte(String Titulo, String Descripcion) {
        this.Titulo = Titulo;
        this.Descripcion = Descripcion;
    }


    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String Titulo) {
        this.Titulo = Titulo;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }
    
    @Override
    public String toString() {
        return "PromocionReporte{" + "Titulo=" + Titulo + ", Descripcion=" + Descripcion + '}';
    }
 
}
