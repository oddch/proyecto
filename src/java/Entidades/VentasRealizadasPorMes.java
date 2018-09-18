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
public class VentasRealizadasPorMes {

    private String mes;
    private int totalFacturas;
    private int totalVentas;

    public VentasRealizadasPorMes() {
    }
    
    public VentasRealizadasPorMes(String mes, int totalFacturas, int totalVentas) {
        this.mes = mes;
        this.totalFacturas = totalFacturas;
        this.totalVentas = totalVentas;
    }

    public int getTotalVentas() {
        return totalVentas;
    }

    public void setTotalVentas(int totalVentas) {
        this.totalVentas = totalVentas;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public int getTotalFacturas() {
        return totalFacturas;
    }

    public void setTotalFacturas(int totalFacturas) {
        this.totalFacturas = totalFacturas;
    }

    @Override
    public String toString() {
        return "VentasRealizadasPorMes{" + "mes=" + mes + ", totalFacturas=" + totalFacturas + ", totalVentas=" + totalVentas + '}';
    }

}
