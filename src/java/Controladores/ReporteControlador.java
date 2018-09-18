/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;


import Entidades.PromocionReporte;
import Entidades.ReporteProductos;
import Entidades.ReporteUsuarios;
import Entidades.VentasRealizadasPorMes;
import Facades.FacturaFacade;
import Facades.ProductoFacade;
import Facades.PromocionesFacade;
import Facades.UsuarioFacade;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Asus
 */
@Named(value = "rp")
@SessionScoped
public class ReporteControlador implements Serializable {

    @EJB
    FacturaFacade facturaFacade;
    private VentasRealizadasPorMes ventasRealizadasPorMes = new VentasRealizadasPorMes();
    private List<VentasRealizadasPorMes> listaVentasRealizadasPorMes;
    private JasperPrint jasperPrintVentasRealizadasPorMes;

    @EJB
    ProductoFacade productoFacade;
    private ReporteProductos reporteProductos = new ReporteProductos();
    private List<ReporteProductos> listaReporteProductos;
    private JasperPrint jasperPrintReporteProductos;

    @EJB
    UsuarioFacade usuarioFacade;
    private ReporteUsuarios reporteUsuarios = new ReporteUsuarios();
    private List<ReporteUsuarios> listaReporteUsuarios;
    private JasperPrint jasperPrintReporteUsuarios;
    
    @EJB
    PromocionesFacade promocionesFacade;
    private PromocionReporte promocionReporte = new PromocionReporte();
    private List<PromocionReporte> listaPromocionReporte;
    private JasperPrint jasperPrintPromocionReporte;

    public ReporteControlador() {
    }
    //----------------------------------------------------------------------------------------------------------------

    //  metodo de reprteVentasRealizadasPorMes
    public void listarVentasRealizadasPorMes() {
        listaVentasRealizadasPorMes = new ArrayList<>();
        List<Object[]> lista = facturaFacade.ventasRealizadasPorMes();
        for (Object[] item : lista) {
            ventasRealizadasPorMes = new VentasRealizadasPorMes();
            ventasRealizadasPorMes.setMes(item[0].toString());
            ventasRealizadasPorMes.setTotalFacturas(Integer.parseInt(item[1].toString()));
            ventasRealizadasPorMes.setTotalVentas(Integer.parseInt(item[2].toString()));
            listaVentasRealizadasPorMes.add(ventasRealizadasPorMes);
        }
    }

    public void reprteVentasRealizadasPorMes() throws JRException, IOException {

        listarVentasRealizadasPorMes();
        JRBeanCollectionDataSource origen = new JRBeanCollectionDataSource(listaVentasRealizadasPorMes);
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
        jasperPrintVentasRealizadasPorMes = JasperFillManager.fillReport(ruta + "//VentasRealizadasPorMes.jasper", new HashMap(), origen);
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.addHeader("Content-disposition", "attachment; filename=VentasRealizadasPorMes.pdf");
        ServletOutputStream sos = hsr.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrintVentasRealizadasPorMes, sos);
        FacesContext.getCurrentInstance().responseComplete();
    }

    //----------------------------------------------------------------------------------------------------------------
    //  metodo de ReporteProductos
    public void listarReporteProductos() {
        listaReporteProductos = new ArrayList<>();
        List<Object[]> lista = productoFacade.reporteProductos();
        for (Object[] item : lista) {
            reporteProductos = new ReporteProductos();
            reporteProductos.setId(Integer.parseInt(item[0].toString()));
            reporteProductos.setNombre(item[1].toString());
            reporteProductos.setTipoProducto(item[2].toString());
            reporteProductos.setPrecio(Integer.parseInt(item[3].toString()));
            reporteProductos.setCantidad(Integer.parseInt(item[4].toString()));
            listaReporteProductos.add(reporteProductos);
            reporteProductos = new ReporteProductos();
        }
    }

    public void reporteProductos() throws JRException, IOException {

        listarReporteProductos();
        JRBeanCollectionDataSource origen = new JRBeanCollectionDataSource(listaReporteProductos);
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
        jasperPrintReporteProductos = JasperFillManager.fillReport(ruta + "//ReporteProductos.jasper", new HashMap(), origen);
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.addHeader("Content-disposition", "attachment; filename=ReporteProductos.pdf");
        ServletOutputStream sos = hsr.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrintReporteProductos, sos);
        FacesContext.getCurrentInstance().responseComplete();
    }

    //----------------------------------------------------------------------------------------------------------------
    public void listaReporteUsuarios() {
        listaReporteUsuarios = new ArrayList<>();
        List<Object[]> lista = usuarioFacade.reporteUsuarios();
        for (Object[] item : lista) {
            reporteUsuarios = new ReporteUsuarios();
            reporteUsuarios.setIdUsuario(Integer.parseInt(item[0].toString()));
            reporteUsuarios.setDocumento(Integer.parseInt(item[1].toString()));
            reporteUsuarios.setNombres(item[2].toString());
            reporteUsuarios.setApellidos(item[3].toString());
            reporteUsuarios.setDireccion(item[4].toString());
            reporteUsuarios.setTelefono(Integer.parseInt(item[5].toString()));
            reporteUsuarios.setEstado(Integer.parseInt(item[6].toString()));
            reporteUsuarios.setEmail(item[7].toString());
            reporteUsuarios.setClave(item[8].toString());
            listaReporteUsuarios.add(reporteUsuarios);
        }
    }

    public void reporteUsuarios() throws JRException, IOException {

        listaReporteUsuarios();
        JRBeanCollectionDataSource origen = new JRBeanCollectionDataSource(listaReporteUsuarios);
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
        jasperPrintReporteUsuarios = JasperFillManager.fillReport(ruta + "//ReporteUsuarios.jasper", new HashMap(), origen);
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.addHeader("Content-disposition", "attachment; filename=ReporteUsuarios.pdf");
        ServletOutputStream sos = hsr.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrintReporteUsuarios, sos);
        FacesContext.getCurrentInstance().responseComplete();
    }
    

    
      public void listarPromocionReporte() {
        listaPromocionReporte = new ArrayList<>();
        List<Object[]> lista = promocionesFacade.reportePromociones();
        for (Object[] item : lista) {
            promocionReporte = new PromocionReporte();
            promocionReporte.setTitulo(item[0].toString());
            promocionReporte.setDescripcion(item[1].toString());
           listaPromocionReporte.add(promocionReporte);
        }
    }

    public void PromocionReporte() throws JRException, IOException {

        listarPromocionReporte();
        JRBeanCollectionDataSource origen = new JRBeanCollectionDataSource(listaPromocionReporte);
        String ruta = FacesContext.getCurrentInstance().getExternalContext().getRealPath("//Reportes//");
        jasperPrintPromocionReporte = JasperFillManager.fillReport(ruta + "//PromocionReporte.jasper", new HashMap(), origen);
        HttpServletResponse hsr = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        hsr.addHeader("Content-disposition", "attachment; filename=PromocionReporte.pdf");
        ServletOutputStream sos = hsr.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrintPromocionReporte, sos);
        FacesContext.getCurrentInstance().responseComplete();
    }
  

    public ReporteProductos getReporteProductos() {
        return reporteProductos;
    }

    public void setReporteProductos(ReporteProductos reporteProductos) {
        this.reporteProductos = reporteProductos;
    }

    public List<ReporteProductos> getListaReporteProductos() {
        return listaReporteProductos;
    }

    public void setListaReporteProductos(List<ReporteProductos> listaReporteProductos) {
        this.listaReporteProductos = listaReporteProductos;
    }

    public JasperPrint getJasperPrintReporteProductos() {
        return jasperPrintReporteProductos;
    }

    public void setJasperPrintReporteProductos(JasperPrint jasperPrintReporteProductos) {
        this.jasperPrintReporteProductos = jasperPrintReporteProductos;
    }

    public ReporteUsuarios getReporteUsuarios() {
        return reporteUsuarios;
    }

    public void setReporteUsuarios(ReporteUsuarios reporteUsuarios) {
        this.reporteUsuarios = reporteUsuarios;
    }

    public List<ReporteUsuarios> getListaReporteUsuarios() {
        return listaReporteUsuarios;
    }

    public void setListaReporteUsuarios(List<ReporteUsuarios> listaReporteUsuarios) {
        this.listaReporteUsuarios = listaReporteUsuarios;
    }

    public JasperPrint getJasperPrintReporteUsuarios() {
        return jasperPrintReporteUsuarios;
    }

    public void setJasperPrintReporteUsuarios(JasperPrint jasperPrintReporteUsuarios) {
        this.jasperPrintReporteUsuarios = jasperPrintReporteUsuarios;
    }

    public VentasRealizadasPorMes getVentasRealizadasPorMes() {
        return ventasRealizadasPorMes;
    }

    public void setVentasRealizadasPorMes(VentasRealizadasPorMes ventasRealizadasPorMes) {
        this.ventasRealizadasPorMes = ventasRealizadasPorMes;
    }

    public List<VentasRealizadasPorMes> getListaVentasRealizadasPorMes() {
        return listaVentasRealizadasPorMes;
    }

    public void setListaVentasRealizadasPorMes(List<VentasRealizadasPorMes> listaVentasRealizadasPorMes) {
        this.listaVentasRealizadasPorMes = listaVentasRealizadasPorMes;
    }

    public JasperPrint getJasperPrintVentasRealizadasPorMes() {
        return jasperPrintVentasRealizadasPorMes;
    }

    public void setJasperPrintVentasRealizadasPorMes(JasperPrint jasperPrintVentasRealizadasPorMes) {
        this.jasperPrintVentasRealizadasPorMes = jasperPrintVentasRealizadasPorMes;
    }

    public PromocionReporte getPromocionReporte() {
        return promocionReporte;
    }

    public void setPromocionReporte(PromocionReporte promocionReporte) {
        this.promocionReporte = promocionReporte;
    }

    public List<PromocionReporte> getListaPromocionReporte() {
        return listaPromocionReporte;
    }

    public void setListaPromocionReporte(List<PromocionReporte> listaPromocionReporte) {
        this.listaPromocionReporte = listaPromocionReporte;
    }

    public JasperPrint getJasperPrintPromocionReporte() {
        return jasperPrintPromocionReporte;
    }

    public void setJasperPrintPromocionReporte(JasperPrint jasperPrintPromocionReporte) {
        this.jasperPrintPromocionReporte = jasperPrintPromocionReporte;
    }

}
