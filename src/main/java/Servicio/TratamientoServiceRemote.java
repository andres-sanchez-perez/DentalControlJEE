package Servicio;

import dominio.Tratamiento;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface TratamientoServiceRemote {

    public List<Tratamiento> listarTratamientos();
    
    public List<Tratamiento> ObtenerTratamientosHisBuscado(int id);

    public Tratamiento encontrarTratamientoPorId(Tratamiento tratamiento);

    public void registrarTratamiento(Tratamiento tratamiento);

    public void modificarTratamiento(Tratamiento tratamiento);
}
