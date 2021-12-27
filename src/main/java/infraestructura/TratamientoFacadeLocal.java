/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infraestructura;

import dominio.Tratamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ERDE
 */
@Local
public interface TratamientoFacadeLocal {

    void create(Tratamiento tratamiento);

    void edit(Tratamiento tratamiento);

    void remove(Tratamiento tratamiento);

    Tratamiento find(Object id);

    List<Tratamiento> findAll();

    List<Tratamiento> findRange(int[] range);

    int count();
    
}
