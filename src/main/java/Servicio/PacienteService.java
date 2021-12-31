package Servicio;

import java.util.List;
import javax.ejb.Local;
import dominio.Paciente;

@Local
public interface PacienteService {

    public List<Paciente> listarPacientes();

    public Paciente encontrarPacientePorId(Paciente paciente);

    public void registrarPaciente(Paciente paciente);

    public void modificarPaciente(Paciente paciente);

    public void eliminarPaciente(Paciente paciente);
}

