package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Historial;
import dominio.Paciente;
import dominio.Tratamiento;
import infraestructura.HistorialFacadeLocal;
import infraestructura.PacienteFacadeLocal;
import infraestructura.TratamientoFacadeLocal;
/**
 *
 * @author andre
 */
@Stateless
public class HistorialServiceImpl implements HistorialService, HistorialServiceRemote {
        @Inject
	private HistorialFacadeLocal historialFacade;
        
        @Inject
        private PacienteFacadeLocal pacienteFacade;
        @Inject
        private TratamientoFacadeLocal tratamientoFacade;

        @Override
	public List<Historial> listarHistoriales() {
		return historialFacade.findAll();
	}

        @Override
	public Historial encontrarHistorialPorId(Historial historial) {
		return historialFacade.find(historial);
	}


        @Override
	public void registrarHistorial(Historial historial) {
		historialFacade.create(historial);
	}

        @Override
	public void modificarHistorial(Historial historial) {
		historialFacade.edit(historial);
	}

        @Override
	public void eliminarHistorial(Historial historial) {
                Paciente paciente = historial.getIdPaciente();
		historialFacade.remove(historial);
                pacienteFacade.remove(paciente);
	}    
}
