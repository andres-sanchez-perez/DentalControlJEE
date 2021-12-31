package Servicio;

import java.util.List;
import javax.ejb.Local;
import dominio.Doctor;

@Local
public interface DoctorService {

    public List<Doctor> listarDoctores();

    public Doctor encontrarDoctorPorId(Doctor doctor);

    public void registrarDoctor(Doctor doctor);

    public void modificarDoctor(Doctor doctor);

    public void eliminarDoctor(Doctor doctor);
}

