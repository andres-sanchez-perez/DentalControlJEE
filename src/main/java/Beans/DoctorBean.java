package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import dominio.Doctor;
import Servicio.DoctorService;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("DoctorBean")
@RequestScoped
public class DoctorBean {

    @Inject
    private DoctorService doctorService;

    private Doctor doctorSeleccionado;

    List<Doctor> doctores;

    public DoctorBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        doctores = doctorService.listarDoctores();
        doctorSeleccionado = new Doctor();
    }

    public void editListener(RowEditEvent event) {
        Doctor Doctor = (Doctor) event.getObject();
        doctorService.modificarDoctor(Doctor);
    }

    public List<Doctor> getDoctores() {
        return doctores;
    }

    public void setDoctores(List<Doctor> doctores) {
        this.doctores = doctores;
    }

    public Doctor getDoctorSeleccionado() {
        return doctorSeleccionado;
    }

    public void setDoctorSeleccionado(Doctor DoctorSeleccionado) {
        this.doctorSeleccionado = DoctorSeleccionado;
    }

    public void reiniciarDoctorSeleccionado() {
        this.doctorSeleccionado = new Doctor();
    }

    public void agregarDoctor() {
        doctorService.registrarDoctor(doctorSeleccionado);
        this.doctorSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarDoctor() {
        doctorService.eliminarDoctor(doctorSeleccionado);
        this.doctorSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public DoctorService getDoctorService() {
        return doctorService;
    }

    public void setDoctorService(DoctorService doctorService) {
        this.doctorService = doctorService;
    }
}
