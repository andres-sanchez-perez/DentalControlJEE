package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import Servicio.TratamientoService;
import dominio.Tratamiento;
import java.util.Map;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.ManagedProperty;
import javax.faces.context.FacesContext;

@Named("TratamientoBean")
@RequestScoped
public class TratamientoBean {

    @Inject
    private TratamientoService tratamientoService;

    private Tratamiento tratamientoSeleccionado;

    List<Tratamiento> tratamientos;
       
    private int idBuscar;

    public TratamientoBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        idBuscar = Integer.parseInt(params.get("id"));
        tratamientos = tratamientoService.ObtenerTratamientosHisBuscado(idBuscar);
        tratamientoSeleccionado = new Tratamiento();
    }

    public int getIdBuscar() {
        return idBuscar;
    }

    public void setIdBuscar(int idBuscar) {
        this.idBuscar = idBuscar;
    }
    
    

    public void editListener(RowEditEvent event) {
        Tratamiento tratamiento = (Tratamiento) event.getObject();
        tratamientoService.modificarTratamiento(tratamiento);
    }

    public List<Tratamiento> getTratamientos() {
        return tratamientos;
    }

    public void setTratamientos(List<Tratamiento> tratamiento) {
        this.tratamientos = tratamiento;
    }

    public Tratamiento getTratamientoSeleccionado() {
        return tratamientoSeleccionado;
    }

    public void setTratamientoSeleccionado(Tratamiento tratamientoSeleccionado) {
        this.tratamientoSeleccionado = tratamientoSeleccionado;
    }

    public void reiniciaTratamientoSeleccionado() {
        this.tratamientoSeleccionado = new Tratamiento();
    }

    public void agregarTratamiento() {
        tratamientoService.registrarTratamiento(tratamientoSeleccionado);
        this.tratamientoSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }


    public TratamientoService getTratamientoService() {
        return tratamientoService;
    }

    public void setTratamientoService(TratamientoService tratamientoService) {
        this.tratamientoService = tratamientoService;
    }
}
