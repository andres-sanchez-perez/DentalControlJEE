package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import dominio.Paciente;
import Servicio.PacienteService;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("PacienteBean")
@RequestScoped
public class PacienteBean {
    @Inject
    private PacienteService pacienteService;

    private Paciente pacienteSeleccionado;

    List<Paciente> pacientes;

    public PacienteBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        pacientes = pacienteService.listarPacientes();
        pacienteSeleccionado = new Paciente();
    }

    public void editListener(RowEditEvent event) {
        Paciente Doctor = (Paciente) event.getObject();
        pacienteService.modificarPaciente(Doctor);
    }

    public List<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<Paciente> pacientes) {
        this.pacientes = pacientes;
    }

    public Paciente getPacienteSeleccionado() {
        return pacienteSeleccionado;
    }

    public void setPacienteSeleccionado(Paciente pacienteSeleccionado) {
        this.pacienteSeleccionado = pacienteSeleccionado;
    }

    public void reiniciarPacienteSeleccionado() {
        this.pacienteSeleccionado = new Paciente();
    }

    public void agregarPaciente() {
        pacienteService.registrarPaciente(pacienteSeleccionado);
        this.pacienteSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarPaciente() {
        pacienteService.eliminarPaciente(pacienteSeleccionado);
        this.pacienteSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public PacienteService getPacienteService() {
        return pacienteService;
    }

    public void setPacienteService(PacienteService pacienteService) {
        this.pacienteService = pacienteService;
    }
}
