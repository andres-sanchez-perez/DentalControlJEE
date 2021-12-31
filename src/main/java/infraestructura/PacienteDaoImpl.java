/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package infraestructura;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.*;
import dominio.Paciente;
/**
 *
 * @author andre
 */

@Stateless
public class PacienteDaoImpl implements PacienteDao{
    @PersistenceContext(unitName = "my_persistence_unit")
    EntityManager em;

    @Override
    public List<Paciente> findAllPacientes() {
        return em.createNamedQuery("Paciente.findAll").getResultList();
    }

    @Override
    public Paciente findPacienteById(Paciente paciente) {
        return em.find(Paciente.class, paciente.getIdPaciente());
    }


    @Override
    public void insertPaciente(Paciente paciente) {
        em.persist(paciente);
    }

    @Override
    public void updatePaciente(Paciente paciente) {
        em.merge(paciente);
    }

    @Override
    public void deletePaciente(Paciente paciente) {
        em.remove(em.merge(paciente));
    }
}
