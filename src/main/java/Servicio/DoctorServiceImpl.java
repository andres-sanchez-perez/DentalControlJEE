package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Doctor;
import infraestructura.DoctorDao;
/**
 *
 * @author andre
 */
@Stateless
public class DoctorServiceImpl implements DoctorService, DoctorServiceRemote {
        @Inject
	private DoctorDao doctorDao;

        @Override
	public List<Doctor> listarDoctores() {
		return doctorDao.findAllDoctores();
	}

        @Override
	public Doctor encontrarDoctorPorId(Doctor doctor) {
		return doctorDao.findDoctorById(doctor);
	}


        @Override
	public void registrarDoctor(Doctor doctor) {
		doctorDao.insertDoctor(doctor);
	}

        @Override
	public void modificarDoctor(Doctor doctor) {
		doctorDao.updateDoctor(doctor);
	}

        @Override
	public void eliminarDoctor(Doctor doctor) {
		doctorDao.deleteDoctor(doctor);
	}    
}
