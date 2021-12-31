package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Paciente;
import Eis.PacienteDao;
/**
 *
 * @author andre
 */
@Stateless
public class PacienteServiceImpl implements PacienteService, PacienteServiceRemote {
        @Inject
	private PacienteDao pacienteDao;

        @Override
	public List<Paciente> listarPacientes() {
		return pacienteDao.findAllPacientes();
	}

        @Override
	public Paciente encontrarPacientePorId(Paciente paciente) {
		return pacienteDao.findPacienteById(paciente);
	}


        @Override
	public void registrarPaciente(Paciente paciente) {
		pacienteDao.insertPaciente(paciente);
	}

        @Override
	public void modificarPaciente(Paciente paciente) {
		pacienteDao.updatePaciente(paciente);
	}

        @Override
	public void eliminarPaciente(Paciente paciente) {
		pacienteDao.deletePaciente(paciente);
	}    
}
