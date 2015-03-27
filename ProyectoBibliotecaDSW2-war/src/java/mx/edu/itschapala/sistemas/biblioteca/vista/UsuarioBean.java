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
import mx.edu.itschapala.sistemas.biblioteca.bl.UsuarioBlLocal;
import mx.edu.itschapala.sistemas.biblioteca.modelo.Usuario;

/**
 *
 * @author Admin
 */
@ManagedBean
@SessionScoped
public class UsuarioBean {
 @EJB
    private UsuarioBlLocal usuarioBL;
 //----------------------------------------------------------------------------
    //             caracteristicas
//----------------------------------------------------------------------------
    
    private List<Usuario> lista;
     private Accion accion;//variable para saber que se va a realizar
    private Usuario usuario;//objeto no autoadministrado
        
        
    /**
     * Creates a new instance of UsuarioBean
     */
    public UsuarioBean() {
        usuario=new Usuario();
    }
     public List<Usuario> getLista(){
        lista=usuarioBL.getLista();
        return lista;
     }
     
//----------------------------------------------------------------------------
    //             get y set necesarios
//----------------------------------------------------------------------------

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
 //-----------------------------------------------------------------------------
    //                      EVENTOS
//-----------------------------------------------------------------------------
    public void prepararNuevo(ActionEvent evt){
        usuario=new Usuario();
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
              usuarioBL.registrar(usuario);
              break;
          case EDITAR:
              usuarioBL.modificar(usuario);
              break;
          case ELIMINAR:
              usuarioBL.eliminar(usuario);
              break;
      }
      accion=Accion.NADA;
      return "UsuarioLista";
    }
     public String procesarCancelar(){
    if(accion==Accion.ELIMINAR){
        return "UsuarioLista";
    }else{
       return "UsuarioCrearEditar"; 
    }
     }
}
