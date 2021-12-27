/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infraestructura;

import dominio.Historial;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ERDE
 */
@Local
public interface HistorialFacadeLocal {

    void create(Historial historial);

    void edit(Historial historial);

    void remove(Historial historial);

    Historial find(Object id);

    List<Historial> findAll();

    List<Historial> findRange(int[] range);

    int count();
    
}
