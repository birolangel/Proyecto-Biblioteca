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
import mx.edu.itschapala.sistemas.biblioteca.bl.CategoriaBlLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Categoria;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class CategoriaBean {

     @EJB
    private CategoriaBlLocal categoriaBL;

//----------------------------------------------------------------------------
    //             caracteristicas
//----------------------------------------------------------------------------
    
    private List<Categoria> lista;
    private Accion accion;//variable para saber que se va a realizar
    private Categoria categoria;//objeto no autoadministrado    
    
    /**
     * Creates a new instance of CategoriaBean
     */
    public CategoriaBean() {
        categoria=new Categoria();
    }
     public List<Categoria> getLista(){
    lista=categoriaBL.getLista();
    return lista;
    }
 //-----------------------------------------------------------------------------
    //                      GET Y SET NECESARIOS
//-----------------------------------------------------------------------------

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
     
     
     
//-----------------------------------------------------------------------------
    //                      EVENTOS
//-----------------------------------------------------------------------------
    public void prepararNuevo(ActionEvent evt){
        categoria=new Categoria();
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
              categoriaBL.registrar(categoria);
              break;
          case EDITAR:
              categoriaBL.modificar(categoria);
              break;
          case ELIMINAR:
              categoriaBL.eliminar(categoria);
              break;
      }
      accion=Accion.NADA;
      return "CategoriaLista";
    }
     public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "CategoriaLista";
    }else{
       return "CategoriaCrearEditar"; 
    }
     }
}
