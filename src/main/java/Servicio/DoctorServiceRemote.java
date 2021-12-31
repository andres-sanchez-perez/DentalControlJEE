package Servicio;

import java.util.List;
import dominio.Doctor;
import javax.ejb.Remote;

@Remote
public interface DoctorServiceRemote {

    public List<Doctor> listarDoctores();

    public Doctor encontrarDoctorPorId(Doctor doctor);

    public void registrarDoctor(Doctor doctor);

    public void modificarDoctor(Doctor doctor);

    public void eliminarDoctor(Doctor doctor);
}
