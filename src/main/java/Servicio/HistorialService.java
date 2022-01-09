package Servicio;

import java.util.List;
import javax.ejb.Local;
import dominio.Historial;

@Local
public interface HistorialService {

    public List<Historial> listarHistoriales();

    public Historial encontrarHistorialPorId(Historial historial);

    public void registrarHistorial(Historial historial);

    public void modificarHistorial(Historial historial);

    public void eliminarHistorial(Historial historial);
}

