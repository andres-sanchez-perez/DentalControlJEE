/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package infraestructura;
import java.util.List;
import dominio.Paciente;

public interface PacienteDao {

	public List<Paciente> findAllPacientes();

	public Paciente findPacienteById(Paciente paciente);

	public void insertPaciente(Paciente paciente);

	public void updatePaciente(Paciente paciente);

	public void deletePaciente(Paciente paciente);
}
