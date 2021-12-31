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
}
