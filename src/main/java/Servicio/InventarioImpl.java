package Servicio;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import dominio.Inventario;
import infraestructura.InventarioFacadeLocal;
import java.util.ArrayList;
/**
 *
 * @author andre
 */
@Stateless
public class InventarioImpl implements InventarioService, InventarioServiceRemote {
        @Inject
	private InventarioFacadeLocal inventarioFacade;
        

        @Override
	public List<Inventario> listarProductos() {
		return inventarioFacade.findAll();
	}

        @Override
	public Inventario encontrarProductoPorId(Inventario inventario) {
		return inventarioFacade.find(inventario);
	}


        @Override
	public void registrarProducto(Inventario inventario) {
            List<Inventario> inv = listarProductos();
            List<Integer> indexesOcupados = new ArrayList<Integer>();
            for(Inventario inventary : inv){
                indexesOcupados.add(inventary.getIdInventario());
            }
            boolean seguro = true;
            int i=1;
            do{
                if(!indexesOcupados.contains(i)){
                    inventario.setIdInventario(i);
                    seguro = false;
                }else{
                    i++;
                }
            }while(seguro);
            
            inventario.setCantidadMaxima(inventario.getCantidadActual());
            inventario.setCantidadMinima();
            inventario.setPrioridad();
            inventarioFacade.create(inventario);
	}

        @Override
        public void modificarProducto(Inventario inventario) {
            inventarioFacade.edit(inventario);
        }

        @Override
        public void eliminarProducto(Inventario inventario) {
            inventarioFacade.remove(inventario);
        }
}
