/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Beans;

import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import dominio.Inventario;
import Servicio.InventarioService;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.primefaces.event.RowEditEvent;
import javax.enterprise.context.RequestScoped;

@Named("InventarioBean")
@RequestScoped
public class InventarioBean {
    @Inject
    private InventarioService inventarioService;

    private Inventario inventarioSeleccionado;
    
    private Inventario searchSeleccionado;
    
    List<Inventario> inventarios;
    
    private String message;
    
    private boolean add;
    
    private String select;
    
    private int cantidad;
    
    private int selector;

    public InventarioBean() {
    }

    @PostConstruct
    public void inicializar() {
        //Iniciamos las variables
        inventarios = inventarioService.listarProductos();
        inventarioSeleccionado = new Inventario();
        searchSeleccionado = new Inventario();
        cantidad = 0;
        add=false;
        message ="";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    
    
    public int getSelector() {
        return selector;
    }

    public void setSelector(int selector) {
        this.selector = selector;
    }

    public boolean isAdd() {
        return add;
    }

    public void setAdd(boolean add) {
        this.add = add;
    }

    public String getSelect() {
        return select;
    }

    public void setSelect(String select) {
        this.select = select;
    }
    
    
    
    public void editListener(RowEditEvent event) {
        Inventario inventario = (Inventario) event.getObject();
        inventarioService.modificarProducto(inventario);
    }

    public List<Inventario> getInventarios() {
        return inventarios;
    }

    public void setInventarios(List<Inventario> inventarios) {
        this.inventarios = inventarios;
    }

    public Inventario getInventarioSeleccionado() {
        return inventarioSeleccionado;
    }

    
    public void setInventarioSeleccionado(Inventario inventarioSeleccionado) {
        this.inventarioSeleccionado = inventarioSeleccionado;
    }
    
    public void reiniciarInventarioSeleccionado() {
        this.inventarioSeleccionado = new Inventario();
    }

    public Inventario getSearchSeleccionado() {
        if(inventarioSeleccionado.getIdInventario() !=null){
            for(int i=0;i<inventarios.size();i++){
                if(inventarios.get(i).getIdInventario() == inventarioSeleccionado.getIdInventario()){
                    searchSeleccionado = inventarios.get(i);
                    break;
                }
            }
        }
        return searchSeleccionado;
    }

    public List<String> AutoCompletar(String query){
        String queryLowerCase = query.toLowerCase();
        List<String> nombresInventarios = new ArrayList<>();
        for(Inventario inv : inventarios){
            nombresInventarios.add(inv.getNombre());
        }
        
        return nombresInventarios.stream().filter(t -> t.toLowerCase().startsWith(queryLowerCase)).collect(Collectors.toList());
    }
    
    public void setSearchSeleccionado(Inventario searchSeleccionado) {
        this.searchSeleccionado = searchSeleccionado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    
    
    public void agregarProducto() {
        
        for(Inventario inv : inventarios){
            String nombre = inv.getNombre().toLowerCase();
            String nombreAIng = inventarioSeleccionado.getNombre().toLowerCase();
            if(nombre == null ? nombreAIng == null : nombre.equals(nombreAIng)){
                message = "Ya existe un producto con ese nombre";
                return;
            }
        }
        message ="";
        inventarioService.registrarProducto(inventarioSeleccionado);
        this.inventarioSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public void eliminarProducto() {
        inventarioService.eliminarProducto(inventarioSeleccionado);
        this.inventarioSeleccionado = null;
        //actualizamos la lista
        this.inicializar();
    }

    public InventarioService getInventarioService() {
        return inventarioService;
    }

    public void setinventarioService(InventarioService inventarioService) {
        this.inventarioService = inventarioService;
    }
    
    public void actualizarElementos(){
        if(inventarioSeleccionado.getIdInventario() !=null){
            for(int i=0;i<inventarios.size();i++){
                if(inventarios.get(i).getIdInventario() == inventarioSeleccionado.getIdInventario()){
                    searchSeleccionado = inventarios.get(i);
                    break;
                }
            }
        }
        if(isAdd()){
            selector=1;
            searchSeleccionado.actualizarCantidades(cantidad, selector);
            inventarioService.modificarProducto(searchSeleccionado);
            System.out.println("hey sume");
        }
        else{
            selector=2;
            searchSeleccionado.actualizarCantidades(cantidad, selector);
            inventarioService.modificarProducto(searchSeleccionado);
            System.out.println("hey reste");
        }
    }
}

