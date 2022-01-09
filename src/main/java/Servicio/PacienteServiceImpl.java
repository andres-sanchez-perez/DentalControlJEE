package Servicio;


import dominio.Historial;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Paciente;
import dominio.Tratamiento;
import infraestructura.HistorialFacadeLocal;
import infraestructura.PacienteFacadeLocal;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
@Stateless
public class PacienteServiceImpl implements PacienteService, PacienteServiceRemote {
        @Inject
	private PacienteFacadeLocal pacienteFacade;

        @Inject
        private HistorialFacadeLocal historialFacade;
        
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
                List<Paciente> pacientes = listarPacientes();
                Paciente encontrado = new Paciente();
                for(Paciente paci : pacientes){
                    if(paci.getCedula() == null ? paciente.getCedula() == null : paci.getCedula().equals(paciente.getCedula())){
                        encontrado = paci;
                        break;
                    }
                }
                List<Tratamiento> lista = new ArrayList<>();
                Historial historia = new Historial();
                historia.setIdPaciente(encontrado);
                historia.setTratamientosList(lista);
                historialFacade.create(historia);
	}

        @Override
	public void modificarPaciente(Paciente paciente) {
		pacienteFacade.edit(paciente);
                List<Historial> historiales = historialFacade.findAll();
                for(Historial historia : historiales){
                    if(historia.getIdPaciente().getIdPaciente() == paciente.getIdPaciente()){
                        historia.setIdPaciente(paciente);
                        historialFacade.edit(historia);
                        break;
                    }
                }
	}

        @Override
	public void eliminarPaciente(Paciente paciente) {
		pacienteFacade.remove(paciente);
	}    
}
