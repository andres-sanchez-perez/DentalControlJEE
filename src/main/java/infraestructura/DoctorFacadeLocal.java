/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infraestructura;

import dominio.Doctor;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author ERDE
 */
@Local
public interface DoctorFacadeLocal {

    void create(Doctor doctor);

    void edit(Doctor doctor);

    void remove(Doctor doctor);

    Doctor find(Object id);

    List<Doctor> findAll();

    List<Doctor> findRange(int[] range);

    int count();
    
}
