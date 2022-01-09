package Servicio;

import java.util.List;
import javax.ejb.Local;
import dominio.Tratamiento;

@Local
public interface TratamientoService {

    public List<Tratamiento> listarTratamientos();
    
    public List<Tratamiento> ObtenerTratamientosHisBuscado(int id);

    public Tratamiento encontrarTratamientoPorId(Tratamiento tratamiento);

    public void registrarTratamiento(Tratamiento tratamiento);

    public void modificarTratamiento(Tratamiento tratamiento);
}

