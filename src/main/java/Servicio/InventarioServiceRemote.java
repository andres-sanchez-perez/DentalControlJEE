package Servicio;

import dominio.Inventario;
import java.util.List;
import javax.ejb.Remote;

@Remote
public interface InventarioServiceRemote {

    public List<Inventario> listarProductos();

    public Inventario encontrarProductoPorId(Inventario inventario);

    public void registrarProducto(Inventario inventario);

    public void modificarProducto(Inventario inventario);

    public void eliminarProducto(Inventario inventario);
}
