package Beans;

import Servicio.HistorialService;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import Servicio.TratamientoService;
import dominio.Historial;
import dominio.Tratamiento;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;

@Named("TratamientoBean")
@RequestScoped
public class TratamientoBean {

    @Inject
    private TratamientoService tratamientoService;
    @Inject
    private HistorialService historialService;

    private Tratamiento tratamientoSeleccionado;

    List<Tratamiento> tratamientos;
    
    List<Historial> historiales;
       
    private int idBuscar;
    
    private int idHistorial;
    
    private String tratamiento;
    
    private String tipo;
    
    private Date fecha;
    
    private double presupuesto;
    
    private String namePersona;

    public TratamientoBean() {
    }

    
    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        Map<String, String> params = FacesContext.getCurrentInstance()
                .getExternalContext().getRequestParameterMap();
        this.fecha = setDate(new Date());
        if(params.get("id") != null){
            idBuscar = Integer.parseInt(params.get("id"));
            tratamientos = tratamientoService.ObtenerTratamientosHisBuscado(idBuscar);
            if(!tratamientos.isEmpty()){
                for(int i = 0; i < 1; i++){
                    namePersona ="Tratamientos del paciente " +tratamientos.get(i).getIdHistorial().getIdPaciente().getNombre() +" " +tratamientos.get(i).getIdHistorial().getIdPaciente().getApellido();
                }
            }
        }
        tratamiento ="";
        tipo="";
        historiales = historialService.listarHistoriales();
        tratamientoSeleccionado = new Tratamiento();
    }

    public String getNamePersona() {
        return namePersona;
    }

    public void setNamePersona(String NamePersona) {
        this.namePersona = NamePersona;
    }

    
    
    
    public HistorialService getHistorialService() {
        return historialService;
    }

    public void setHistorialService(HistorialService historialService) {
        this.historialService = historialService;
    }

    public List<Historial> getHistoriales() {
        return historiales;
    }

    public void setHistoriales(List<Historial> historiales) {
        this.historiales = historiales;
    }

    public int getIdHistorial() {
        return idHistorial;
    }
    
    public void setIdHistorial(int idHistorial) {
        this.idHistorial = idHistorial;
    }

    public String getTratamiento() {
        return tratamiento;
    }

    public void setTratamiento(String Tratamiento) {
        this.tratamiento = Tratamiento;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(double presupuesto) {
        this.presupuesto = presupuesto;
    }

    
    public Date setDate(Date date){
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DATE);
        calendar.set(year,month,day);
        return calendar.getTime();
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
        Tratamiento trat = new Tratamiento();
        List<Historial> listaHistoriales = historialService.listarHistoriales();
        Historial historial = new Historial();
        for(Historial historia : listaHistoriales){
            if(historia.getIdHistorial() == this.idHistorial){
                historial = historia;
                break;
            }
        }
        
        trat.setNombre(this.tratamiento);
        trat.setTipo(this.tipo);
        trat.setFecha(this.fecha);
        trat.setPresupuesto(this.presupuesto);
        trat.setIdHistorial(historial);
        tratamientoService.registrarTratamiento(trat);        
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
