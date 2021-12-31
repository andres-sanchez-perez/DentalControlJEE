/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Eis;
import java.util.List;
import dominio.Doctor;

public interface DoctorDao {

	public List<Doctor> findAllDoctores();

	public Doctor findDoctorById(Doctor doctor);

	public void insertDoctor(Doctor doctor);

	public void updateDoctor(Doctor doctor);

	public void deleteDoctor(Doctor doctor);
}
