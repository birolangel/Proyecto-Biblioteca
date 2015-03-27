/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mx.edu.itschapala.sistemas.biblioteca.vista;

import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ActionEvent;
import mx.edu.itschapala.sistemas.biblioteca.bl.LibroBlLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Libro;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class LibroBean {
    @EJB
    private LibroBlLocal libroBL;
    
//----------------------------------------------------------------------------
    //             caracteristicas
//----------------------------------------------------------------------------
    
    private List<Libro> lista;
    private Accion accion;
    private Libro libro;
        


    /**
     * Creates a new instance of LibroBean
     */
    public LibroBean() {
        libro=new Libro();
    }
    public List<Libro> getLista(){
        lista=libroBL.getLista();
        return lista;
}

//----------------------------------------------------------------------------
    //             get y set necesarios
//----------------------------------------------------------------------------

    public Libro getLibro() {
        return libro;
    }

    public void setLibro(Libro libro) {
        this.libro = libro;
    }
//----------------------------------------------------------------------------
    //             eventos
//----------------------------------------------------------------------------

    public void prepararNuevo(ActionEvent evt){
        libro=new Libro();
        accion=Accion.NUEVO;
    }
    public void prepararEditar(ActionEvent evt){
        accion=Accion.EDITAR;
    }
    public void prepararEliminar(ActionEvent evt){
        accion=Accion.ELIMINAR;
    }
//----------------------------------------------------------------------------
    //             acciones
//----------------------------------------------------------------------------

       public String procesarPeticion(){
      switch(accion){
          case NUEVO:
              libroBL.registrar(libro);
              break;
          case EDITAR:
              libroBL.modificar(libro);
              break;
          case ELIMINAR:
              libroBL.eliminar(libro);
              break;
      }
      accion=Accion.NADA;
      return "LibroLista";
    }
     public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "LibroLista";
    }else{
       return "LibroCrearEditar"; 
    }
     }
    
}