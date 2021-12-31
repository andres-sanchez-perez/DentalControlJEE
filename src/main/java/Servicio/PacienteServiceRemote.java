package Servicio;

import java.util.List;
import dominio.Paciente;
import javax.ejb.Remote;

@Remote
public interface PacienteServiceRemote {

    public List<Paciente> listarPacientes();

    public Paciente encontrarPacientePorId(Paciente paciente);

    public void registrarPaciente(Paciente paciente);

    public void modificarPaciente(Paciente paciente);

    public void eliminarPaciente(Paciente paciente);
}
