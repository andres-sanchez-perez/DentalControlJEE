package Servicio;

import dominio.Historial;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface HistorialServiceRemote {

    public List<Historial> listarHistoriales();

    public Historial encontrarHistorialPorId(Historial historial);

    public void registrarHistorial(Historial historial);

    public void modificarHistorial(Historial historial);

    public void eliminarHistorial(Historial historial);
}
