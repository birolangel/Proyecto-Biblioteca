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
import mx.edu.itschapala.sistemas.biblioteca.bl.PuestosBlLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Puestos;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class PuestosBean {
 @EJB
    private PuestosBlLocal puestosBL;
 //----------------------------------------------------------------------------
    //             caracteristicas
//----------------------------------------------------------------------------
    private List<Puestos> lista;
    private Accion accion;//variable para saber que se va a realizar
    private Puestos puestos;//objeto no autoadministrado  
    
    /**
     * Creates a new instance of PuestoBean
     */
    public PuestosBean() {
        puestos=new Puestos();
    }
     public List<Puestos> getLista(){
     lista=puestosBL.getLista();
     return lista;
}

    public Puestos getPuesto() {
        return puestos;
    }

    public void setPuesto(Puestos puestos) {
        this.puestos = puestos;
    }
      //-----------------------------------------------------------------------------
    //                      EVENTOS
//-----------------------------------------------------------------------------
    public void prepararNuevo(ActionEvent evt){
        puestos=new Puestos();
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
              puestosBL.registrar(puestos);
              break;
          case EDITAR:
              puestosBL.modificar(puestos);
              break;
          case ELIMINAR:
              puestosBL.eliminar(puestos);
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
