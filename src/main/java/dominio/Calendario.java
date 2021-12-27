/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

/**
 *
 * @author ERDE
 */
@Entity
@Table(name = "calendario")
@NamedQueries({
    @NamedQuery(name = "Calendario.findAll", query = "SELECT c FROM Calendario c"),
    @NamedQuery(name = "Calendario.findByIdCalendario", query = "SELECT c FROM Calendario c WHERE c.idCalendario = :idCalendario"),
    @NamedQuery(name = "Calendario.findByFechasDisponibles", query = "SELECT c FROM Calendario c WHERE c.fechasDisponibles = :fechasDisponibles"),
    @NamedQuery(name = "Calendario.findByHorasDisponibles", query = "SELECT c FROM Calendario c WHERE c.horasDisponibles = :horasDisponibles")})
public class Calendario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id_calendario")
    private Integer idCalendario;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fechasDisponibles")
    @Temporal(TemporalType.DATE)
    private Date fechasDisponibles;
    @Basic(optional = false)
    @NotNull
    @Column(name = "horasDisponibles")
    @Temporal(TemporalType.TIME)
    private Date horasDisponibles;
    @JoinTable(name = "calendariodoctor", joinColumns = {
        @JoinColumn(name = "id_calendario", referencedColumnName = "id_calendario")}, inverseJoinColumns = {
        @JoinColumn(name = "id_doctor", referencedColumnName = "id_doctor")})
    @ManyToMany
    private List<Doctor> doctorList;

    public Calendario() {
    }

    public Calendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Calendario(Integer idCalendario, Date fechasDisponibles, Date horasDisponibles) {
        this.idCalendario = idCalendario;
        this.fechasDisponibles = fechasDisponibles;
        this.horasDisponibles = horasDisponibles;
    }

    public Integer getIdCalendario() {
        return idCalendario;
    }

    public void setIdCalendario(Integer idCalendario) {
        this.idCalendario = idCalendario;
    }

    public Date getFechasDisponibles() {
        return fechasDisponibles;
    }

    public void setFechasDisponibles(Date fechasDisponibles) {
        this.fechasDisponibles = fechasDisponibles;
    }

    public Date getHorasDisponibles() {
        return horasDisponibles;
    }

    public void setHorasDisponibles(Date horasDisponibles) {
        this.horasDisponibles = horasDisponibles;
    }

    public List<Doctor> getDoctorList() {
        return doctorList;
    }

    public void setDoctorList(List<Doctor> doctorList) {
        this.doctorList = doctorList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idCalendario != null ? idCalendario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Calendario)) {
            return false;
        }
        Calendario other = (Calendario) object;
        if ((this.idCalendario == null && other.idCalendario != null) || (this.idCalendario != null && !this.idCalendario.equals(other.idCalendario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Calendario[ idCalendario=" + idCalendario + " ]";
    }
    
}
