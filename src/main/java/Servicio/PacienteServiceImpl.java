package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Paciente;
import infraestructura.PacienteFacadeLocal;
/**
 *
 * @author andre
 */
@Stateless
public class PacienteServiceImpl implements PacienteService, PacienteServiceRemote {
        @Inject
	private PacienteFacadeLocal pacienteFacade;

        @Override
	public List<Paciente> listarPacientes() {
		return pacienteFacade.findAll();
	}

        @Override
	public Paciente encontrarPacientePorId(Paciente paciente) {
		return pacienteFacade.find(paciente);
	}


        @Override
	public void registrarPaciente(Paciente paciente) {
		pacienteFacade.create(paciente);
	}

        @Override
	public void modificarPaciente(Paciente paciente) {
		pacienteFacade.edit(paciente);
	}

        @Override
	public void eliminarPaciente(Paciente paciente) {
		pacienteFacade.remove(paciente);
	}    
}
