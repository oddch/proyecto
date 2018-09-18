/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controladores;



import Facades.ProductoFacade;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import org.primefaces.model.chart.PieChartModel;

/**
 *
 * @author Asus
 */
@Named(value = "graficasControlador")
@SessionScoped
public class GraficasControlador implements Serializable {

    /**
     * Creates a new instance of GraficasControlador
     */
    public GraficasControlador() {
    }
    
  
    private PieChartModel pieModel1;
    @EJB
    ProductoFacade productoFacade;
    @PostConstruct
    public void init(){
        createPieModels();
    }
    
    public PieChartModel getPieModel1() {
        return pieModel1;
    }
    
     private void createPieModels() {
        createPieModel1();
    }
     
        private void createPieModel1() {
        pieModel1 = new PieChartModel();
        List<Object[]> lista=productoFacade.reporteProducto();
        
        for (Object[] pedido : lista) {
            pieModel1.set(pedido[0].toString(), Integer.parseInt(pedido[1].toString()));
        } 
        
        pieModel1.setTitle("Productos mas vendidos");
        pieModel1.setLegendPosition("w");
        pieModel1.setShowDataLabels(true);
        
    }

}
