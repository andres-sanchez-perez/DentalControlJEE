package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import Servicio.HistorialService;
import dominio.Historial;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("HistorialBean")
@RequestScoped
public class HistorialBean {

    @Inject
    private HistorialService historialService;

    private Historial historialSeleccionado;

    List<Historial> historiales;
    
    private int idBuscar;
    
    public HistorialBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        historiales = historialService.listarHistoriales();
        historialSeleccionado = new Historial();
        idBuscar = 0;
    }

    public int getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(int idBuscar) {
        this.idBuscar = idBuscar;
    }

    
    
    
    public void editListener(RowEditEvent event) {
        Historial historial = (Historial) event.getObject();
        historialService.modificarHistorial(historial);
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public Historial getHistorialSeleccionado() {
        return historialSeleccionado;
    }

    public void setHistorialSeleccionado(Historial HistorialSeleccionado) {
        this.historialSeleccionado = HistorialSeleccionado;
    }

    public void reiniciarHistorialSeleccionado() {
        this.historialSeleccionado = new Historial();
    }

    public void agregarHistorial() {
        historialService.registrarHistorial(historialSeleccionado);
        this.historialSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarHistorial() {
        historialService.eliminarHistorial(historialSeleccionado);
        this.historialSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public HistorialService getHistorialService() {
        return historialService;
    }

    public void setHistorialService(HistorialService historialService) {
        this.historialService = historialService;
    }
    
    public Object navegarATratamientos(){
        return "Tratamientos?faces-redirect=true&id=" + idBuscar;
    }
}
