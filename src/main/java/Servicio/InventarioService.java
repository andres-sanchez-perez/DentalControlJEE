package Servicio;

import java.util.List;
import javax.ejb.Local;
import dominio.Inventario;

@Local
public interface InventarioService {

    public List<Inventario> listarProductos();

    public Inventario encontrarProductoPorId(Inventario inventario);

    public void registrarProducto(Inventario inventario);

    public void modificarProducto(Inventario inventario);

    public void eliminarProducto(Inventario inventario);
}

