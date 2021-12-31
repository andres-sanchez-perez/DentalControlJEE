/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Eis;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import dominio.Doctor;
/**
 *
 * @author andre
 */

@Stateless
public class DoctorDaoImpl implements DoctorDao{
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public List<Doctor> findAllDoctores() {
        return em.createNamedQuery("Doctor.findAll").getResultList();
    }

    @Override
    public Doctor findDoctorById(Doctor doctor) {
        return em.find(Doctor.class, doctor.getIdDoctor());
    }


    @Override
    public void insertDoctor(Doctor doctor) {
        em.persist(doctor);
    }

    @Override
    public void updateDoctor(Doctor doctor) {
        em.merge(doctor);
    }

    @Override
    public void deleteDoctor(Doctor doctor) {
        em.remove(em.merge(doctor));
    }
}
