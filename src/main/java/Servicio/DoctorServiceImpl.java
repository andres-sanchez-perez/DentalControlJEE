package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Doctor;
import infraestructura.DoctorFacadeLocal;
/**
 *
 * @author andre
 */
@Stateless
public class DoctorServiceImpl implements DoctorService, DoctorServiceRemote {
        @Inject
	private DoctorFacadeLocal doctorFacade;

        
        
        
        @Override
	public List<Doctor> listarDoctores() {
            return doctorFacade.findAll();
	}

        @Override
	public Doctor encontrarDoctorPorId(Doctor doctor) {
            return doctorFacade.find(doctor);
	}


        @Override
	public void registrarDoctor(Doctor doctor) {
            doctor.setNombre(upperCaseFirst(doctor.getNombre()));
            doctor.setApellido(upperCaseFirst(doctor.getApellido()));
            doctor.setEspecialidad(upperCaseFirst(doctor.getEspecialidad()));
            doctorFacade.create(doctor);
	}

        @Override
	public void modificarDoctor(Doctor doctor) {
            doctorFacade.edit(doctor);
	}

        @Override
	public void eliminarDoctor(Doctor doctor) {
            doctorFacade.remove(doctor);
	}  
        
        private String upperCaseFirst(String val) {
            char[] arr = val.toCharArray();
            arr[0] = Character.toUpperCase(arr[0]);
            return new String(arr);
        }
}
