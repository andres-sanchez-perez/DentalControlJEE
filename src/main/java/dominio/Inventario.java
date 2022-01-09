/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dominio;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author ERDE
 */
@Entity
@Table(name = "inventario")
@NamedQueries({
    @NamedQuery(name = "Inventario.findAll", query = "SELECT i FROM Inventario i"),
    @NamedQuery(name = "Inventario.findByIdInventario", query = "SELECT i FROM Inventario i WHERE i.idInventario = :idInventario"),
    @NamedQuery(name = "Inventario.findByCantidadActual", query = "SELECT i FROM Inventario i WHERE i.cantidadActual = :cantidadActual"),
    @NamedQuery(name = "Inventario.findByCantidadMinima", query = "SELECT i FROM Inventario i WHERE i.cantidadMinima = :cantidadMinima"),
    @NamedQuery(name = "Inventario.findByPrioridad", query = "SELECT i FROM Inventario i WHERE i.prioridad = :prioridad")})
public class Inventario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @NotNull
    @Column(name = "id_inventario")
    private Integer idInventario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "Nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Precio")
    private double precio;
    @Size(max = 45)
    @Column(name = "Tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantidadActual")
    private int cantidadActual;
    @Basic(optional = false)
    @NotNull
    @Column(name = "CantidadMinima")
    private int cantidadMinima;
    @Column(name = "Prioridad")
    private Integer prioridad;
    /*
    @JoinColumn(name = "id_producto", referencedColumnName = "id_producto")
    @ManyToOne
    private Producto idProducto;
    */
    @Column(name = "CantidadMaxima")
    private int cantidadMaxima;
   
    
    public Inventario() {
    }

    public Inventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public Inventario(Integer idInventario, String nombre, double precio, String tipo ,int cantidadActual) {
        this.idInventario = idInventario;
        this.nombre=nombre;
        this.precio=precio;
        this.tipo=tipo;
        this.cantidadActual = cantidadActual;
        setCantidadMaxima(cantidadActual);
        setCantidadMinima();
        setPrioridad();
    }

    public Integer getIdInventario() {
        return idInventario;
    }

    public void setIdInventario(Integer idInventario) {
        this.idInventario = idInventario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidadActual() {
        return cantidadActual;
    }

    public void setCantidadActual(int cantidadActual) {
        this.cantidadActual = cantidadActual;
    }
    
    public void actualizarCantidades(int cantidad, int selector){
        if(selector == 1){
            this.cantidadActual += cantidad;
            if(cantidadActual > cantidadMaxima){
                setCantidadMaxima(cantidadActual);
            }
            setPrioridad();
        }
        else if(selector == 2){
            if(cantidad <= cantidadActual){
                this.cantidadActual -= cantidad;
            }
            setPrioridad();
        }
    }
    
    public int getCantidadMaxima() {
        return cantidadMaxima;
    }

    public void setCantidadMaxima(int CantMax) {
        if(getCantidadActual()>this.cantidadMaxima){
            this.cantidadMaxima = CantMax;
            setCantidadMinima();
        }
    }

    public int getCantidadMinima() {
        return cantidadMinima;
    }

    public void setCantidadMinima() {
        this.cantidadMinima =this.cantidadActual/2;
    }

    public Integer getPrioridad() {
        return prioridad;
    }

    public void setPrioridad() {
        double PrioL=cantidadMaxima*0.75,CantAc=cantidadActual;
        
        if(cantidadActual<=cantidadMaxima &&CantAc>PrioL){
            prioridad = 3;
        }else if(CantAc<PrioL&&cantidadActual>cantidadMinima){
            prioridad = 2;
        }else{
            prioridad = 1;
        }
    }
/*
    public Producto getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Producto idProducto) {
        this.idProducto = idProducto;
    }
*/
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idInventario != null ? idInventario.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Inventario)) {
            return false;
        }
        Inventario other = (Inventario) object;
        if ((this.idInventario == null && other.idInventario != null) || (this.idInventario != null && !this.idInventario.equals(other.idInventario))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dominio.Inventario[ idInventario=" + idInventario + " ]";
    }
    
}
