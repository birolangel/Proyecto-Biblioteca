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
import mx.edu.itschapala.sistemas.biblioteca.bl.AutorBLLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Autor;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class AutorBean {
    @EJB
    private AutorBLLocal autorBL;
    
    
//----------------------------------------------------------------------------
    //             caracteristicas
//----------------------------------------------------------------------------
    private List<Autor> lista;
    private Accion accion;//variable para saber que se va a realizar
    private Autor autor;//objeto no autoadministrado
        
    

    /**
     * Creates a new instance of AutorBean
     */
    public AutorBean() {
        autor=new Autor();
    }
    public List<Autor> getLista(){
        lista=autorBL.getLista();
        return lista;
    }

//----------------------------------------------------------------------------
    //             get y set necesarios
//----------------------------------------------------------------------------
    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }
    //-----------------------------------------------------------------------------
    //                      EVENTOS
//-----------------------------------------------------------------------------
    public void prepararNuevo(ActionEvent evt){
        autor=new Autor();
        accion=Accion.NUEVO;
    }
    public void prepararEditar(ActionEvent evt){
        accion=Accion.EDITAR;
    }
    public void prepararEliminar(ActionEvent evt){
        accion=Accion.ELIMINAR;
    }
    
    
    
//-----------------------------------------------------------------------------
    //                      ACCIONES
//-----------------------------------------------------------------------------
    public String procesarPeticion(){
      switch(accion){
          case NUEVO:
              autorBL.registrar(autor);
              break;
          case EDITAR:
              autorBL.modificar(autor);
              break;
          case ELIMINAR:
              autorBL.eliminar(autor);
              break;
      }
      accion=Accion.NADA;
      return "AutorLista";
    }
     public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "AutorLista";
    }else{
       return "AutorCrearEditar"; 
    }
     }
     
}

