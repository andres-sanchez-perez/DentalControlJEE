package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Tratamiento;
import infraestructura.TratamientoFacadeLocal;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
@Stateless
public class TratamientoServiceImpl implements TratamientoService, TratamientoServiceRemote {
        @Inject
	private TratamientoFacadeLocal tratamientoFacade;

        @Override
	public List<Tratamiento> listarTratamientos() {
		return tratamientoFacade.findAll();
	}
        
        @Override
        public List<Tratamiento> ObtenerTratamientosHisBuscado(int id){
            List<Tratamiento> tratamientos = listarTratamientos();
            List<Tratamiento> historialBuscado = new ArrayList<>();
            for(Tratamiento trat : tratamientos){
                if(trat.getIdHistorial().getIdHistorial() == id){
                    historialBuscado.add(trat);
                }
            }
            return historialBuscado;
        }
        
        

        @Override
	public Tratamiento encontrarTratamientoPorId(Tratamiento tratamiento) {
		return tratamientoFacade.find(tratamiento);
	}


        @Override
	public void registrarTratamiento(Tratamiento tratamiento) {
		tratamientoFacade.create(tratamiento);
	}

        @Override
	public void modificarTratamiento(Tratamiento tratamiento) {
		tratamientoFacade.edit(tratamiento);
	}
    
}
